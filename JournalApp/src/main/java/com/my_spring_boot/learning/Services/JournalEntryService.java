package com.my_spring_boot.learning.Services;

import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Repositories.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {
    @Autowired
    public JournalEntryRepo jeRepo;
    public boolean sPost(JournalEntry js) {
        jeRepo.save(js);
        return true;
    }
    public List<JournalEntry> sGet() {
        return jeRepo.findAll();
    }

}
