package com.quachhengtony.todomanager.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "todo_item")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
    @Id
    @SequenceGenerator(
            name = "todo_item_sequence",
            allocationSize = 1,
            sequenceName = "todo_item_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_item_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private Instant createdDate;
}
