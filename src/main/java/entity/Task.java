package entity;

import java.time.LocalDateTime;
import util.TaskStatus;

public class Task {

  private int id;
  private String description;
  private TaskStatus status;
  private LocalDateTime createdAt;

  public Task(int id, String description) {
    this.id = id;
    this.description = description;
    this.status = TaskStatus.PENDING;
    this.createdAt = LocalDateTime.now();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskStatus getStatus() {
    return status;
  }

  public void setStatus(TaskStatus status) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return id + ";" + description + ";" + status + ";" + createdAt;
  }

  public static Task fromTxt(String taskTxt) {
    String[] parts = taskTxt.split(";");
    Task task = new Task(Integer.parseInt(parts[0]), parts[1]);
    task.setStatus(TaskStatus.valueOf(parts[2].toUpperCase()));
    task.setCreatedAt(LocalDateTime.parse(parts[3]));
    return task;
  }
}
