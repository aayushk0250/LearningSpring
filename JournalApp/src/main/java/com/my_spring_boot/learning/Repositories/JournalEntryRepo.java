package com.my_spring_boot.learning.Repositories;

import com.my_spring_boot.learning.Entities.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
                                                        // entity/pojo    , id
public interface JournalEntryRepo extends MongoRepository<JournalEntry, String> {
}

// controller -> services -> repo