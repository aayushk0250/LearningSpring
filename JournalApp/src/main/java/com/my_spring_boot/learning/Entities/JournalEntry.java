package com.my_spring_boot.learning.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
//@Getter,
//@Setter,
//@RequiredArgsConstructor,
//@ToString,
//@EqualsAndHashCode,
//@Value
// or just use:
@Data
public class JournalEntry {
    @Id
    String id;
    String title;
    String content;

// used lambok to eliminate below getters and setters and many more:

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }

}
