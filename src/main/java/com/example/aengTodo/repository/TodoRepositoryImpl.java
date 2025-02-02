package com.example.aengTodo.repository;

import com.example.aengTodo.entity.ToDo;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class TodoRepositoryImpl implements TodoRepository{
  // 등록, 삭제가 발생하기 때문에 LinkedList 선택함
  private final List<ToDo> todoList = new LinkedList<>(); // LinkedList를 직접 수정할 일은 없으므로 final로 선언


  // 전체 todo 조회
  // todoList의 복사본을 ArrayList에 넣어주기 : 단순 조회의 성능이 더 좋음 인덱스접근 O(1).
  @Override
  public List<ToDo> findAll(){
    return new ArrayList<>(todoList); // 투두들을 넣어주고 싶어. 그러면 그 변수가 있어야지. -> 위에서 선언해야겠네!
  }

  // 특정 todo 조회
  @Override
  public Optional<ToDo> findById(UUID id){
    for(ToDo todo : todoList){
      if(todo.getId().equals(id))
        return Optional.of(todo);
    }
  }

  // todo 등록
  @Override
  public void save(ToDo todo){
    todoList.add(todo);
  }

  // todo 수정
  @Override
  public void update(Todo todo){
    for (int i = 0; i < todoList.size(); i++) {
      if (todoList.get(i).getId().equals(todo.getId())) {
        todoList.set(i, todo); // 같은 위치에 새로운 todo 객체로 변경
        return;
      }
    }
  }

  // todo 삭제
  @Override
  public void deleteById(UUID id){
    todoList.removeIf(todo -> todo.getId().equals(id));
  }
}
