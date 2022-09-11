package dev.vorstu.controllers;

import dev.vorstu.database.entities.auth.UserAuthEntity;
import dev.vorstu.database.repositories.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private UserAuthRepository userAuthRepository;

    @GetMapping("users")
    public Set<UserAuthEntity> getAllUsers() {
        Set<UserAuthEntity> users = userAuthRepository.findAll();
        users.forEach((data) -> data.setPassword(null));
        return users;
    }

    @PostMapping(value="users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserAuthEntity createUser(@RequestBody UserAuthEntity user) {
        return userAuthRepository.save(user);
    }
}
