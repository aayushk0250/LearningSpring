package com.my_spring_boot.learning.Services;

import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Repositories.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo jeRepo;

    // CREATE
    public void saveEntry(JournalEntry jEntry) {
        jeRepo.save(jEntry);
    }

    // UPDATE
    public void updateCur(String id, JournalEntry j) {
        j.setId(id);
        jeRepo.save(j);
    }

    // READ - get all entries
    public List<JournalEntry> getAllEntries() {
        return jeRepo.findAll();
    }

    // READ - get entry by id
    public Optional<JournalEntry> getEntryById(String id) {
        return jeRepo.findById(id);
    }

    // DELETE - by id
    public void deleteEntryById(String id) {
        jeRepo.deleteById(id);
    }
}
