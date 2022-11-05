package dev.vorstu.controllers;

import dev.vorstu.database.entities.chat.ChatEntity;
import dev.vorstu.database.entities.chat.MessageEntity;
import dev.vorstu.database.entities.dto.ChatDto;
import dev.vorstu.database.entities.dto.MessageDto;
import dev.vorstu.database.repositories.ChatRepository;
import dev.vorstu.database.repositories.MessageRepository;
import dev.vorstu.database.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/chats")
public class ChatController {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<ChatDto> getAllChats() {
        List<ChatEntity> chats =  chatRepository.findAll();
        List<ChatDto> chatDtos = new ArrayList<>(chats.size());
        chats.forEach(chat -> chatDtos.add(ChatDto.builder()
            .name(chat.getName())
            .uniqueId(chat.getUniqueId())
            .build()));
        return chatDtos;
    }

    @GetMapping("{id}")
    public ChatDto getChatById(@PathVariable("id")Long id) {
        ChatEntity chat =  chatRepository.findByUniqueId(id);
        return ChatDto.builder()
                .name(chat.getName())
                .uniqueId(chat.getUniqueId())
                .build();
    }

    @GetMapping("{id}/messages/{page}")
    public List<MessageDto> getChatMessages(@PathVariable("id")Long id, @PathVariable("page")int page) {
        Pageable request = PageRequest.of(
                page,
                10,
                Sort.by("uniqueId").descending());

        List<MessageEntity> messages = messageRepository.findAllByChat(
                chatRepository.findByUniqueId(id),
                request).getContent();

        List<MessageDto> messageDtos = new ArrayList<>(messages.size());

        messages.forEach(message -> {
            MessageDto messageDto = MessageDto.builder()
                    .content(message.getContent())
                    .user(message.getUser().getUsername())
                    .chat(message.getChat().getUniqueId())
                    .build();
            messageDtos.add(messageDto);
        });

        return messageDtos;
    }

    @PostMapping(value = "messages", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MessageDto newMessage(@RequestBody MessageDto messageDto) {
        MessageEntity message = new MessageEntity(messageDto.getContent(),
                this.chatRepository.findByUniqueId(messageDto.getChat()),
                this.userInfoRepository.findByUsername(messageDto.getUser()));
        this.messageRepository.save(message);
        return messageDto;
    }
}
