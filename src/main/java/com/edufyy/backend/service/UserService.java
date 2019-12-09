package com.edufyy.backend.service;

import com.edufyy.backend.model.User;
import com.edufyy.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
    }
}
