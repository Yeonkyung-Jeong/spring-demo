package com.example.aengTodo.repository;

import com.example.aengTodo.entity.ToDo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Repository
public interface TodoRepository {
  // 전체 todo 조회
  List<ToDo> findAll(); // 맨 앞에 public abstract 생략 가능해서 생략.
  // 특정 todo 조회
  Optional<ToDo> findById(UUID id);
  // todo 등록
  void save(ToDo todo);
  // todo 수정
  void update(Todo todo);
  // todo 삭제
  void deleteById(UUID id);
}
