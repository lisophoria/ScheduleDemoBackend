package dev.vorstu.database;

import dev.vorstu.database.entities.UserInfoEntity;
import dev.vorstu.database.entities.auth.UserAuthEntity;
import dev.vorstu.database.entities.auth.BaseRole;
import dev.vorstu.database.entities.auth.UserRoleEntity;
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
    }
}
