package com.my_spring_boot.learning.Entities;

import org.springframework.stereotype.Component;

// I'm a pojo: Plain Old Java Object: made for specific purpose and do only 1 task, i.e, here setting Journal Entries

public class Journals {
    private Long id;
    private String content;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String owner) {
        this.title = owner;
    }
}
