package com.ymdb.app.user.service;

import com.ymdb.app.user.entity.Credentials;
import com.ymdb.app.user.entity.User;

public interface UserService {
    User addUser(User user);

    Long deleteUser(String userId);

    boolean authenticate(Credentials creds);
}
