import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Main class that provides a console-based menu for the ToDoList program.
 
public class SchEDGEit {
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===> To-Do List Menu <===");
            System.out.println("1. Add a new task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark a task as complete");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    LocalDate date;
                    while (true) {
                        System.out.print("Enter task due date (YYYY-MM-DD): ");
                        String dateInput = scanner.nextLine();
                        try {
                            date = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }

                    int priority;
                    while (true) {
                        System.out.print("Enter task priority (1 for high, 3 for low): ");
                        try {
                            priority = Integer.parseInt(scanner.nextLine());
                            if (priority >= 1 && priority <= 3) {
                                break;
                            } else {
                                System.out.println("Priority must be between 1 and 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid priority. Please enter a number between 1 and 3.");
                        }
                    }

                    System.out.print("Is this a recurring task? (yes/no): ");
                    String recurringInput = scanner.nextLine().trim().toLowerCase();
                    if (recurringInput.equals("yes") || recurringInput.equals("y")) {
                        System.out.print("Enter recurrence interval in days: ");
                        int recurrenceDays = Integer.parseInt(scanner.nextLine());
                        todoList.addTask(new RecurringTask(description, date, priority, recurrenceDays));
                    } else {
                        todoList.addTask(new RegularTask(description, date, priority));
                    }
                    break;

                case "2":
                    System.out.print("Sort by 'priority' or 'date': ");
                    String sortBy = scanner.nextLine();
                    todoList.viewTasks(sortBy);
                    break;

                case "3":
                    System.out.print("Enter task description to mark as complete: ");
                    String completeDescription = scanner.nextLine();
                    todoList.completeTask(completeDescription);
                    break;

                case "4":
                    System.out.print("Enter task description to delete: ");
                    String deleteDescription = scanner.nextLine();
                    todoList.deleteTask(deleteDescription);
                    break;

                case "5":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
