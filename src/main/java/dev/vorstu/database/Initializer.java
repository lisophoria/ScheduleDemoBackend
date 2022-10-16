package dev.vorstu.database;

import dev.vorstu.database.entities.UserInfoEntity;
import dev.vorstu.database.entities.auth.UserAuthEntity;
import dev.vorstu.database.entities.auth.BaseRole;
import dev.vorstu.database.entities.auth.UserRoleEntity;
import dev.vorstu.database.entities.chat.ChatEntity;
import dev.vorstu.database.entities.chat.MessageEntity;
import dev.vorstu.database.repositories.ChatRepository;
import dev.vorstu.database.repositories.MessageRepository;
import dev.vorstu.database.repositories.UserAuthRepository;
import dev.vorstu.database.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class Initializer {
    @Autowired
    private UserAuthRepository userAuthRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;

    public void initial() {
        UserAuthEntity admin = new UserAuthEntity(
                "admin",
                true,
                "1234",
                Collections.singleton(
                        new UserRoleEntity("admin", BaseRole.SUPER_USER)));

        userAuthRepository.save(admin);

        UserAuthEntity lisophoria = new UserAuthEntity(
                "lisophoria",
                true,
                "1234",
                Collections.singleton(
                        new UserRoleEntity("lisophoria", BaseRole.STUDENT)));

        userAuthRepository.save(lisophoria);

        UserInfoEntity lisophoriaInfo = new UserInfoEntity(
                "lisophoria",
                "Victor",
                "Astakhov",
                19,
                lisophoria
        );
        userInfoRepository.save(lisophoriaInfo);

        UserAuthEntity someuser = new UserAuthEntity(
                "someuser",
                true,
                "1234",
                Collections.singleton(
                        new UserRoleEntity("someuser", BaseRole.STUDENT)));

        userAuthRepository.save(someuser);

        UserInfoEntity someuserInfo = new UserInfoEntity(
                "someuser",
                "some",
                "user",
                14,
                someuser
        );
        userInfoRepository.save(someuserInfo);

        ChatEntity chat = new ChatEntity();
        chatRepository.save(chat);

        MessageEntity message = new MessageEntity("hello", chat, lisophoriaInfo);
        messageRepository.save(message);
    }
}
