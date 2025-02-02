package com.example.aengTodo.controller;

import com.example.aengTodo.service.TodoService;
import com.example.aengTodo.entity.ToDo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  // 전체 todo 가져오기
  @GetMapping
  public List<ToDo> getAllTodos() {
    return todoService.getAllTodos();  // service에서 findAll() 호출
  }

  // 특정 todo 가져오기
  @GetMapping("/{id}")
  public Optional<ToDo> getTodoById(@PathVariable UUID id) {
    return todoService.getTodoById(id);  // service에서 findById() 호출
  }

  // todo 등록하기
  @PostMapping
  public ToDo createTodo(@RequestBody ToDo todo) {
    return todoService.createTodo(todo);  // service에서 save() 호출
  }

  // todo 수정하기
  @PutMapping("/{id}")
  public ToDo updateTodo(@PathVariable UUID id, @RequestBody ToDo todo) {
    todo.setId(id);  // id를 path로 받아서 todo에 설정
    return todoService.updateTodo(todo);  // service에서 update() 호출
  }

  // todo 삭제하기
  @DeleteMapping("/{id}")
  public Optional<ToDo> deleteTodo(@PathVariable UUID id) {
    return todoService.deleteTodo(id);  // service에서 deleteById() 호출
  }
}
