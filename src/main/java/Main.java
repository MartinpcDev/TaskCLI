import entity.Task;
import java.util.List;
import java.util.Scanner;
import service.TaskService;
import service.TaskServiceImpl;

public class Main {

  public static void main(String[] args) {
    TaskService taskService = new TaskServiceImpl();
    Scanner consola = new Scanner(System.in);
    boolean activo = true;
    System.out.println("Bienvenido al TaskTrackerCLI");
    while (activo) {
      System.out.print("> ");
      String opcion = consola.nextLine();
      String[] inputs = opcion.split(" ", 2);
      switch (inputs[0].toLowerCase()) {
        case "add" -> {
          taskService.saveTask(inputs[1]);
          System.out.println("Tarea Agregada");
        }
        case "list" -> {
          List<Task> tasks = taskService.allTasks();
          tasks.forEach(System.out::println);
        }
        case "update" -> {
          String[] updateInputs = inputs[1].split(" ", 2);
          taskService.updateTask(Integer.parseInt(updateInputs[0]), updateInputs[1]);
          System.out.println("Tarea actualizada.");
        }
        case "delete" -> {
          taskService.deleteTask(Integer.parseInt(inputs[1]));
          System.out.println("Tarea Eliminada");
        }
        case "inprogress" -> {
          taskService.updateStatus(Integer.parseInt(inputs[1]), "in_progress");
          System.out.println("Tarea marcada como en PROGRESO");
        }
        case "done" -> {
          taskService.updateStatus(Integer.parseInt(inputs[1]), "done");
          System.out.println("Tarea marcada como DONE");
        }
        case "listdone" -> {
          List<Task> tasks = taskService.allTasksByStatus("done");
          tasks.forEach(System.out::println);
        }
        case "listpending" -> {
          List<Task> tasks = taskService.allTasksByStatus("pending");
          tasks.forEach(System.out::println);
        }
        case "listinprogress" -> {
          List<Task> tasks = taskService.allTasksByStatus("in_progress");
          tasks.forEach(System.out::println);
        }
        case "exit" -> activo = false;
        default -> System.out.println("Comando no reconocido");
      }
    }
  }
}
