package com.my_spring_boot.learning.Repositories;

import com.my_spring_boot.learning.Entities.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, String> {}
