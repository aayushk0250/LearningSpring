package com.my_spring_boot.learning.Controller;

import com.my_spring_boot.learning.Entities.User;
import com.my_spring_boot.learning.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable ObjectId id) {
        return uService.sGetById(id);
    }

    @PutMapping()
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User userInDb = uService.findUserByUserName(user.getUserName());
        if(userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            uService.sPost(userInDb);   // bina baki change kiye id password udpate ho gya

            return new ResponseEntity<>(userInDb, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(userInDb, HttpStatus.NOT_FOUND);
    }



    @DeleteMapping()
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        User userInDb = uService.findUserByUserName(user.getUserName());
        if(userInDb != null) {
            uService.sDel(userInDb.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
