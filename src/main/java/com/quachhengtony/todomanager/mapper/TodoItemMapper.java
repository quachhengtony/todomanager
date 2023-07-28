package com.quachhengtony.todomanager.mapper;

import com.quachhengtony.todomanager.dto.TodoItemDto;
import com.quachhengtony.todomanager.model.TodoItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {
    public TodoItemMapper INSTANCE = Mappers.getMapper(TodoItemMapper.class);
    public TodoItemDto toDTO(TodoItem todoItem);
    public TodoItem toModel(TodoItemDto todoItemDto);
}
