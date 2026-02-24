package com.my_spring_boot.learning.Controller;

import com.my_spring_boot.learning.Entities.User;
import com.my_spring_boot.learning.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;

    @GetMapping
    public List<User> getAllUser() {
        return uService.sGet();
    }

    @PostMapping
    public boolean createUser(@RequestBody User u) {
        return uService.sPost(u);
    }

    @PutMapping("/{id}")
    public boolean updateUser(@RequestBody User u, @PathVariable String id) {
        return uService.sPut(id, u);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return uService.sDel(id);
    }
}
