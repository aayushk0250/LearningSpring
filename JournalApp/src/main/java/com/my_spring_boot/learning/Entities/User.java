package com.my_spring_boot.learning.Entities;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;
    // even if we put its data type string, **data mongodb** converts string to ObjectId

    @Indexed(unique = true) // will not index it automatically, need to write it in application properties
    @NonNull
    private String useName;

    @NonNull
    private String password;

    // this will allow below list to take a ref of JournalEntry
    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
}
