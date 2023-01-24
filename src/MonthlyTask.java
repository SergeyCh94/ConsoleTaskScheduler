import java.time.LocalDate;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description, Repeatability repeatability) {
        super(title, type, description, repeatability);
    }
}
