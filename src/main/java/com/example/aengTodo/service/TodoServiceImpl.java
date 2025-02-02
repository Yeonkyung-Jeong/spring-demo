package com.example.aengTodo.service;

import com.example.aengTodo.entity.ToDo;
import com.example.aengTodo.repository.TodoRepositoryImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoServiceImpl implements TodoService {
  private final TodoRepositoryImpl todoRepository;

  public TodoServiceImpl(TodoRepositoryImpl todoRepository){
    this.todoRepository = todoRepository;
  }

  // 전체 todo 가져오기
  @Override
  public List<ToDo> getAllTodos(){
    return todoRepository.findAll();
  }

  // 특정 todo 가져오기 - 얘는 왜 dto로 받고
  @Override
  public Optional<ToDo> getTodoById(UUID id){
    return todoRepository.findById(id);
  }

  // todo 등록하기 - 얘는 왜 엔티티로 받지?
  @Override
  public ToDo createTodo(ToDo todo){
    todoRepository.save(todo);
    return todo;
  }

  // todo 수정하기
  @Override
  public ToDo updateTodo(ToDo todo){
    todoRepository.update(todo);
    return todo;
  }

  // todo 삭제하기
  @Override
  public Optional<ToDo> deleteTodo(UUID id) {
    Optional<ToDo> todo = todoRepository.findById(id);
    if (todo.isPresent()) {
      todoRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
