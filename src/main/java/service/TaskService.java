package service;

import entity.Task;
import java.util.List;

public interface TaskService {

  List<Task> allTasks();

  List<Task> allTasksByStatus(String status);

  void saveTask(String description);

  void updateTask(int id, String description);

  void updateStatus(int id, String status);

  void deleteTask(int id);
}
