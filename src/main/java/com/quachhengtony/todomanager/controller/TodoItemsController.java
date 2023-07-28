package com.quachhengtony.todomanager.controller;

import com.quachhengtony.todomanager.dto.TodoItemDto;
import com.quachhengtony.todomanager.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/todoitems")
public class TodoItemsController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping
    public ResponseEntity<List<TodoItemDto>> getAll() {
        return new ResponseEntity<>(todoItemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItemDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(todoItemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TodoItemDto> create(@RequestBody TodoItemDto dto) {
        TodoItemDto todoItemDto = todoItemService.create(dto);
        return new ResponseEntity<>(todoItemDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TodoItemDto dto) {
        todoItemService.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        todoItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
