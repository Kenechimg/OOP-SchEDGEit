import java.time.LocalDate;

// RegularTask class representing a one-time task, extending the Task class.
 
public class RegularTask extends Task {
    public RegularTask(String description, LocalDate date, int priority) {
        super(description, date, priority);
    }

    @Override
    public String taskDetails() {
        return "Regular Task.";
    }
}
