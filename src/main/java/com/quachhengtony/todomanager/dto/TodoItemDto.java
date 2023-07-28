package com.quachhengtony.todomanager.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDto {
    @Nullable
    private Long id;
    private String name;
    private String description;
    @Nullable
    private Instant createdDate;
}
