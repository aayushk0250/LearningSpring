package com.my_spring_boot.learning.Controller;
import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

}
