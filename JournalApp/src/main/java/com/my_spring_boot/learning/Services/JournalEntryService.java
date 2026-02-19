package com.my_spring_boot.learning.Services;
import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Repositories.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public JournalEntry sGetById(String s) {
        return jeRepo.findById(s).orElse(null);
    }

    public boolean sPut(String Id, JournalEntry je) {
        je.setId(Id);
        jeRepo.save(je);
        return true;
    }
    public void sDel(String id) {
        jeRepo.deleteById(id);
    }
}
