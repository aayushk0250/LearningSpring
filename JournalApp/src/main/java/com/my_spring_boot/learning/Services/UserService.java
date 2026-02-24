package com.my_spring_boot.learning.Services;

import com.my_spring_boot.learning.Entities.User;
import com.my_spring_boot.learning.Repositories.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public User sGetById(String s) {
        return uRepo.findById(s).orElse(null);
    }

    public boolean sPut(String id, User u) {
        ObjectId objectId = new ObjectId(id);
        u.setId(objectId);
        uRepo.save(u);
        return true;
    }

    public boolean sDel(String id) {
        if(!uRepo.existsById(id))   return false;
        uRepo.deleteById(id);
        return true;
    }
}
