package com.my_spring_boot.learning.Controller;

import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    public JournalEntryService jes;

    @PostMapping
    public boolean controllerPost (@RequestBody JournalEntry js) {
        return jes.sPost(js);
    }
    @GetMapping
    public List<JournalEntry> controllerGet () {
        return jes.sGet();
    }
}
