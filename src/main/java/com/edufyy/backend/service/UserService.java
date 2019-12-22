package com.edufyy.backend.service;

import com.edufyy.backend.model.User;
import com.edufyy.backend.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements InitializingBean {

    @Autowired
    UserRepository userRepository;

    public void add(User user) {
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User();
        user.setEmail("palande1996@gmail.com");
        user.setPassword("praimfaya");
        user.setName("Becca Pramheda");
        user.setPhone("+999999999999");
        user.setSource("Natblida");
        user.setPremium(true);

        userRepository.save(user);
    }
}
