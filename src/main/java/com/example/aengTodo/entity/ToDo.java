package com.example.aengTodo.entity;

import java.time.LocalDateTime;

@Entity
public class ToDo {
  private Long id;
  private String title;
  private String content;
  private LocalDateTime createAt;
  private LocalDateTime deadLine;
  private boolean isCompleted;

  // 기본 생성자
  public ToDo(){
    this.createAt = LocalDateTime.now();
  }

  // 생성자
  public ToDo(String title, String content, LocalDateTime deadline){
    this.title = title;
    this.content = content;
    this.deadLine = deadLine;
    this.createAt = LocalDateTime.now();
    this.isCompleted = false;
  }

  // Getter & Setter
  public Long getId() { return id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }
  public LocalDateTime getCreateAt() { return createAt; }
  public LocalDateTime getDeadLine() { return deadLine; }
  public void setDeadLine(LocalDateTime deadLine) { this.deadLine = deadLine; }
  public boolean isCompleted() { return isCompleted; }
  public void setCompleted(boolean completed) { isCompleted = completed; }
}

