package com.my_spring_boot.learning.Components;
import com.my_spring_boot.learning.Entities.Journals;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/journal")
public class JournalEntry {
    HashMap<Long,Journals> jEntries = new HashMap<>();

    // GET -> Read
    @GetMapping("/entries")
    public ArrayList<Journals> printJentries() {
        return new ArrayList<>(jEntries.values());
    }

    // Post -> Create
    @PostMapping("/new")
    public String makeJentry(@RequestBody Journals journal) {
        jEntries.put(journal.getId(), journal);
        return "Journal entry added successfully";
    }

    // Put -> read/update
    @PutMapping("query/{myId}")
    public Journals getEntry(@PathVariable Long myId) {
        return jEntries.get(myId);
    }

    @PutMapping("update/{myId}")
    public Journals updateQuery(@PathVariable Long myId, @RequestBody Journals updateJ) {
        Journals j = jEntries.get(myId);
        j.setContent(updateJ.getContent());
        return j;
    }
    
    @DeleteMapping("delete/{myId}")
    public String deleteQuery(@PathVariable Long myId) {
        jEntries.remove(myId);
        return "Journal of id = " + myId + "is deleted successfully";
    }
}
