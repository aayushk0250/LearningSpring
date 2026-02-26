package com.my_spring_boot.learning.Services;

import com.my_spring_boot.learning.Entities.User;
import com.my_spring_boot.learning.Repositories.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    public UserRepo uRepo;

    public boolean sPost(User u) {
        uRepo.save(u);
        return true;
    }
    public List<User> sGet() {
        return uRepo.findAll();
    }
    public Optional<User> sGetById(ObjectId id) {
        return uRepo.findById(id);
    }

    public void sPut(ObjectId id, User u) {
        u.setId(id);
//        u.setPassword(u.getPassword());
        uRepo.save(u);
    }

    public void sDel(ObjectId id) {
        uRepo.deleteById(id);
    }

    public User findUserByUserName(String UserName) {
        return uRepo.findByUserName(UserName);
    }
}
