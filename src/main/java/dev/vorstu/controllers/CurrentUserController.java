package dev.vorstu.controllers;

import dev.vorstu.database.entities.UserInfoEntity;
import dev.vorstu.database.entities.auth.UserAuthEntity;
import dev.vorstu.database.repositories.UserAuthRepository;
import dev.vorstu.database.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currentUser")
public class CurrentUserController {

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserAuthRepository userAuthRepository;

    @GetMapping("self/info")
    public UserInfoEntity getSelfInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userInfoRepository.findByUsername(user.getUsername());
    }

    @GetMapping("self/auth")
    public UserAuthEntity getSelfAuth() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userAuthRepository.findByUsername(user.getUsername());
    }

}
