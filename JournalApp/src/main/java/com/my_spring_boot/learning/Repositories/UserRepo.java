package com.my_spring_boot.learning.Repositories;

import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {}
