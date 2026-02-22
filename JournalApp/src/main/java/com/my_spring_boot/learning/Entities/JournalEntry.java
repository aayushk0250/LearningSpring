package com.my_spring_boot.learning.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "journal_entries")
//@Getter,
//@Setter,
//@RequiredArgsConstructor,
//@ToString,
//@EqualsAndHashCode,
//@Value
// or just use: (provided by lambok)
@Data
public class JournalEntry {
    @Id
    String id;
    @NonNull
    String title;
    String content;
}
