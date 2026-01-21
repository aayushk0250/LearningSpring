package com.my_spring_boot.learning.Components;

import com.my_spring_boot.learning.Entities.Journals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobHoldUntil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/journal")
public class JournalEntry {
    HashMap<Long,Journals> jEntries = new HashMap<>();

    // Read
    @GetMapping("/entries")
    public ArrayList<Journals> printJentries() {
        return new ArrayList<>(jEntries.values());
    }

//    @PostMapping("/new")
//    public void makeJentry() {
//        System.out.println("Enter id: ");
//        Long id = sc.nextLong();
//        j.setId(id);
//
//        System.out.println("Enter Content: ");
//        String content = sc.nextLine();
//        j.setContent(content);
//
//        System.out.println("Enter your name: ");
//        String owner = sc.next();
//        j.setOwner(owner);
//        jEntries.put(id, j);
//    }

    // Create + Update
    @PostMapping("/new")
    public String makeJentry(@RequestBody Journals journal) {

        jEntries.put(journal.getId(), journal);

        return "Journal entry added successfully";
    }
}
