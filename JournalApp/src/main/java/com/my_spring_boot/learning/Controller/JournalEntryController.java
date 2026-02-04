package com.my_spring_boot.learning.Controller;
import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService jeService;

    @PostMapping("new")
    public boolean createEntry(@RequestBody JournalEntry jEntry) {
        jeService.saveEntry(jEntry);
        return true;
    }
    @PostMapping("update/{id}")
    public void postUpdate(@PathVariable String id, @RequestBody JournalEntry j) {
        jeService.updateCur(id, j);
    }

    @GetMapping("show-all")
    public List<JournalEntry> showAll() {
        return jeService.getAllEntries();
    }

    @GetMapping("show/{id}")
    public Optional<JournalEntry> showById(@PathVariable String id) {
        return jeService.getEntryById(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteById(@PathVariable String id) {
        jeService.deleteEntryById(id);
        return true;
    }

}
