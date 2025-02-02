package com.example.aengTodo.service;

public @interface TodoService {
  // 전체 todo 가져오기
  public List<TodoDto> getAllTodos();
  // 특정 todo 가져오기 - 얘는 왜 dto로 받고
  public Optional<TodoDto> getTodoById(UUID id);
  // todo 등록하기 - 얘는 왜 엔티티로 받지?
  public ToDo createTodo(ToDo todo);
  // todo 수정하기
  public ToDo updateTodo(ToDo todo);
  // todo 삭제하기
  public Optional<TodoDto> deleteTodo(UUID id);
}
