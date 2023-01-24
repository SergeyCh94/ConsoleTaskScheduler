import java.time.LocalDate;

public class DailyTask extends Task{
    public DailyTask(String title, Type type, String description, Repeatability repeatability) {
        super(title, type, description, repeatability);
    }
}
