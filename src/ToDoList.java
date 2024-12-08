import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//ToDoList class that manages tasks, demonstrating Encapsulation and Abstraction.

public class ToDoList {
    private final List<Task> tasks; // Field is now final

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription());
    }

    public void deleteTask(String description) {
        tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
        System.out.println("Task '" + description + "' removed.");
    }

    public void completeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markComplete();
                System.out.println("Task '" + description + "' marked as complete.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void viewTasks(String sortBy) {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        if (sortBy.equalsIgnoreCase("priority")) {
            sortedTasks.sort(Comparator.comparingInt(Task::getPriority));
        } else if (sortBy.equalsIgnoreCase("date")) {
            sortedTasks.sort(Comparator.comparing(Task::getDate));
        }

        System.out.println("\n--- Current Tasks ---");
        for (Task task : sortedTasks) {
            System.out.println(task);
            System.out.println("Details: " + task.taskDetails());
        }
    }
}
