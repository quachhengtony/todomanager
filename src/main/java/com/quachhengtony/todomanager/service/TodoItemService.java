package com.quachhengtony.todomanager.service;

import com.quachhengtony.todomanager.dto.TodoItemDto;
import com.quachhengtony.todomanager.mapper.TodoItemMapper;
import com.quachhengtony.todomanager.model.TodoItem;
import com.quachhengtony.todomanager.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private TodoItemMapper todoItemMapper;

    public List<TodoItemDto> getAll() {
        List<TodoItem> todoItemList = todoItemRepository.findAll();
//        List<TodoItemDto> todoItemDtoList = new ArrayList<>();

//        for (TodoItem todoItem : todoItemList) {
//            TodoItemDto todoItemDto = new TodoItemDto();
//            todoItemDto.setId(todoItem.getId());
//            todoItemDto.setName(todoItem.getName());
//            todoItemDto.setDescription(todoItem.getDescription());
//            todoItemDto.setCreatedDate(todoItem.getCreatedDate());
//            todoItemDtoList.add(todoItemDto);
//        }

        return todoItemList.stream().map(todoItemMapper::toDTO).collect(Collectors.toList());
    }

    public TodoItemDto getById(Long id) {
        Optional<TodoItem> createdTodoItem = todoItemRepository.findById(id);
        if (!createdTodoItem.isPresent()) {
            return null;
        }
//        return new TodoItemDto(createdTodoItem.get().getId(), createdTodoItem.get().getName(), createdTodoItem.get().getDescription(), createdTodoItem.get().getCreatedDate());
        return todoItemMapper.toDTO(createdTodoItem.get());
    }

    public TodoItemDto create(TodoItemDto dto) {
        TodoItem todoItem = TodoItem.builder().name(dto.getName()).description(dto.getDescription()).createdDate(Instant.now()).build();
//        TodoItem createdTodoItem = todoItemRepository.save(todoItem);
//        return new TodoItemDto(createdTodoItem.getId(), createdTodoItem.getName(), createdTodoItem.getDescription(), createdTodoItem.getCreatedDate());
        return todoItemMapper.toDTO(todoItemRepository.save(todoItem));
    }

    public Boolean update(Long id, TodoItemDto dto) {
        Optional<TodoItem> existingTodoItem = todoItemRepository.findById(id);
        if (!existingTodoItem.isPresent()) {
            return false;
        }
        TodoItem todoItem = todoItemMapper.toModel(dto);
        todoItem.setId(existingTodoItem.get().getId());
        todoItem.setCreatedDate(existingTodoItem.get().getCreatedDate());
//        TodoItem todoItem = TodoItem.builder().id(id).name(dto.getName()).description(dto.getDescription()).createdDate(existingTodoItem.get().getCreatedDate()).build();
        todoItemRepository.save(todoItem);
        return true;
    }

    public Boolean delete(Long id) {
        Optional<TodoItem> existingTodoItem = todoItemRepository.findById(id);
        if (!existingTodoItem.isPresent()) {
            return false;
        }
        todoItemRepository.delete(existingTodoItem.get());
        return true;
    }
}
