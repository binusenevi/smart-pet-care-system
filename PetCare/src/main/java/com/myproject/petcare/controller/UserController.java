
package com.myproject.petcare.controller;

import com.myproject.petcare.entity.User;
import com.myproject.petcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/test")
    public String test() {
        return "User Controller is working!";
    }
}