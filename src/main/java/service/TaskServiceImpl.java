package service;

import entity.Task;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import util.TaskStatus;

public class TaskServiceImpl implements TaskService {

  private List<Task> tasks = new ArrayList<>();
  private static final String FILE_PATH = "D:\\Estudios Backend\\javaLearning\\TaskCLI\\src\\main\\resources\\tasks.txt";

  public TaskServiceImpl() {
    this.tasks = loadTasks();
  }

  private List<Task> loadTasks() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
      String line = reader.readLine();
      while (line != null) {
        tasks.add(Task.fromTxt(line));
        line = reader.readLine();
      }
    } catch (IOException e) {
      System.out.println("No se pudo cargar el archivo: " + e.getMessage());
    }
    return tasks;
  }

  private void saveTasks() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
      for (Task task : tasks) {
        writer.write(task.toString());
        writer.newLine();
      }
      loadTasks();
      writer.close();
    } catch (IOException e) {
      System.out.println("No se pudo guardar en el archivo: " + e.getMessage());
    }
  }

  @Override
  public List<Task> allTasks() {
    return tasks;
  }

  @Override
  public List<Task> allTasksByStatus(String status) {
    return tasks.stream()
        .filter(task -> task.getStatus().equals(TaskStatus.valueOf(status.toUpperCase())))
        .toList();
  }

  @Override
  public void saveTask(String description) {
    int id = tasks.size() + 1;
    int finalId = id;
    Optional<Task> taskOptional = tasks.stream()
        .filter(task -> task.getId() == finalId).findFirst();
    if (taskOptional.isPresent()) {
      id++;
    }
    Task task = new Task(id, description);
    tasks.add(task);
    saveTasks();
  }

  @Override
  public void updateTask(int id, String description) {
    Optional<Task> taskOptional = tasks.stream()
        .filter(task -> task.getId() == id).findFirst();
    if (taskOptional.isPresent()) {
      Task taskUpdated = taskOptional.get();
      taskUpdated.setDescription(description);
      saveTasks();
    }
  }

  @Override
  public void updateStatus(int id, String status) {
    Optional<Task> taskOptional = tasks.stream()
        .filter(task -> task.getId() == id).findFirst();
    if (taskOptional.isPresent()) {
      Task taskUpdated = taskOptional.get();
      taskUpdated.setStatus(TaskStatus.valueOf(status.toUpperCase()));
      saveTasks();
    }
  }

  @Override
  public void deleteTask(int id) {
    tasks.removeIf(task -> task.getId() == id);
    saveTasks();
  }
}
