package com.my_spring_boot.learning.Services;

import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Repositories.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo jeRepo;
    // JournalEntryRepo is not in bean rn but since it is an interface, it's implementation will be generated at runtime

    public void saveEntry(JournalEntry jEntry) {
        jeRepo.save(jEntry);
    }
}
