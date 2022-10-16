package dev.vorstu.controllers;

import dev.vorstu.database.entities.chat.ChatEntity;
import dev.vorstu.database.entities.chat.MessageEntity;
import dev.vorstu.database.repositories.ChatRepository;
import dev.vorstu.database.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chats")
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<ChatEntity> getAllChats() {
        return chatRepository.findAll();
    }

    @GetMapping("{id}")
    public ChatEntity getChatById(@PathVariable("id")Long id) {
        return chatRepository.findByUniqueId(id);
    }

    @PostMapping(value = "messages", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MessageEntity newMessage(@RequestBody MessageEntity message) {
        return messageRepository.save(message);
    }
}
