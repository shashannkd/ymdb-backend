package com.ymdb.app.user.service;

import com.ymdb.app.user.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User addUser(User user);

    Long deleteUser(String userId);
}
