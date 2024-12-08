import java.time.LocalDate;

//Abstract Task class demonstrating Encapsulation and Abstraction.
//Represents a task with description, date, priority, and completion status.

public abstract class Task {
    public String description;
    public LocalDate date;
    public int priority;
    public boolean completed;

    public Task(String description, LocalDate date, int priority) {
        this.description = description;
        this.date = date;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markComplete() {
        this.completed = true;
    }

    public abstract String taskDetails();

    @Override
    public String toString() {
        String status = completed ? "Completed" : "Pending";
        return description + " (Due: " + date + ", Priority: " + priority + ") - " + status;
    }
}
