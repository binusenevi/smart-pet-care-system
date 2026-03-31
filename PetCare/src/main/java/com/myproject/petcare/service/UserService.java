package com.myproject.petcare.service;

import com.myproject.petcare.entity.User;
import com.myproject.petcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            user.setEmail("temp_" + System.currentTimeMillis() + "@petcare.com");
        }
        if (user.getPassword() == null) {
            user.setPassword("default123");
        }
        if (user.getRole() == null) {
            user.setRole("PET_OWNER");
        }

        return userRepository.save(user);
    }
}
