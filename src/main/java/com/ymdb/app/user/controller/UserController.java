package com.ymdb.app.user.controller;

import com.ymdb.app.user.entity.Credentials;
import com.ymdb.app.user.entity.User;
import com.ymdb.app.user.service.impl.UserServiceImpl;
import jakarta.annotation.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    public UserServiceImpl userService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getStatus")
    public String testPath() {
        return "<h1>The Service is up!!</h1>";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody User user) {
        logger.info("User: register call");
        User newUser = userService.addUser(user);
        return newUser != null ? ResponseEntity.ok("User Registered Successfully with id: " + newUser.getUserId()) : ResponseEntity.ok("User Registration Failed for userId " + user.getUserId());
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId) {
        logger.info("User: delete call");
        return userService.deleteUser(userId) != null ? ResponseEntity.ok("User with userId " + userId + " Deleted Successfully") : ResponseEntity.ok("User Deletion Failed for userId " + userId);
    }

    @PostMapping("/authenticate")
    public boolean authenticate(@Nonnull @RequestBody Credentials credentials) {
        return userService.authenticate(credentials);
    }

}
