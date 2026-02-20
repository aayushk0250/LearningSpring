package com.my_spring_boot.learning.Controller;

import java.util.List;
import java.util.Optional;

import com.my_spring_boot.learning.Entities.JournalEntry;
import com.my_spring_boot.learning.Services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.Id;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    public JournalEntryService jes;

    @PostMapping
    public ResponseEntity<JournalEntry> controllerPost (@RequestBody JournalEntry js) {
        try{
            jes.sPost(js);
            return new ResponseEntity<>(js, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> controllerGet () {
        List<JournalEntry> all = jes.sGet();
        if(all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK );
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> controllerGetById(@PathVariable String id) {
        JournalEntry j = jes.sGetById(id);
        if(j != null) {
            return new ResponseEntity<>(j, HttpStatus.OK);
        }
        return new ResponseEntity<>(j, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{curId}")
    public ResponseEntity<?> controllerPut(@PathVariable String curId, @RequestBody JournalEntry updatedJournal) {
        JournalEntry j = jes.sGetById(curId);
        if(j != null) {
            return new ResponseEntity<>(j, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(updatedJournal, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{curId}")
    public ResponseEntity<JournalEntry> controllerDelete (@PathVariable String curId) {
        jes.sDel(curId);
        JournalEntry j = jes.sGetById(curId);
        if(j == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(j, HttpStatus.OK);
    }
}
