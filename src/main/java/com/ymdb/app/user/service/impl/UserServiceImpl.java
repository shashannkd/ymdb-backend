package com.ymdb.app.user.service.impl;

import com.ymdb.app.user.entity.Credentials;
import com.ymdb.app.user.entity.User;
import com.ymdb.app.user.repository.UserRepository;
import com.ymdb.app.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserRepository repository;


    @Override
    public User addUser(User user) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return repository.save(user);
    }

    @Override
    @Transactional
    public Long deleteUser(String userId) {

        return repository.removeUserByUserId(userId);
    }

    @Override
    public boolean authenticate(Credentials credentials) {
        logger.info("Validation in progress : {}", credentials);
        User userFromDb = credentials.isEmail ? repository.findUserByEmailIdAndPassword(credentials.userName, credentials.password)
                : repository.findUserByUserIdAndPassword(credentials.userName, credentials.password);
        return userFromDb != null;
    }
}
