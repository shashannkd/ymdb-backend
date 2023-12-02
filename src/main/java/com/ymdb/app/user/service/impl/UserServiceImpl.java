package com.ymdb.app.user.service.impl;

import com.ymdb.app.user.entity.User;
import com.ymdb.app.user.repository.UserRepository;
import com.ymdb.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

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
}
