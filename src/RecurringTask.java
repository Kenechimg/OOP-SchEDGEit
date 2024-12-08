import java.time.LocalDate;

//RecurringTask class representing a recurring task, extending the Task class.
 
public class RecurringTask extends Task {
    private final int recurrenceDays; // Field is now final

    public RecurringTask(String description, LocalDate date, int priority, int recurrenceDays) {
        super(description, date, priority);
        this.recurrenceDays = recurrenceDays;
    }

    public int getRecurrenceDays() {
        return recurrenceDays;
    }

    @Override
    public String taskDetails() {
        return "Recurring Task every " + recurrenceDays + " days.";
    }

    @Override
    public String toString() {
        return super.toString() + " (Recurs every " + recurrenceDays + " days)";
    }
}