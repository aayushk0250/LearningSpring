package com.my_spring_boot.learning.Controller;

import com.my_spring_boot.learning.Entities.User;
import com.my_spring_boot.learning.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;

    public List<User> getAllUser() {
        return uService.sGet();
    }

    public boolean createUser(@RequestBody User u) {
        return uService.sPost(u);
    }
}
