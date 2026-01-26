package com.my_spring_boot.learning.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

// I'm a pojo: Plain Old Java Object: made for specific purpose and do only 1 task, i.e, here setting Journal Entries

// ORM ref - mapping of class entity to the mongodb collection and 1 class = 1 document
// Document asks spring that below class entity is mapped to a mongodb collection
// below class is an instance of a document (row) in the mongodb

@Document(collection = "journal_entries")
public class JournalEntry {
    @Id // unique key
    private String id;
    private String title;
    private String content;
    private Date date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
