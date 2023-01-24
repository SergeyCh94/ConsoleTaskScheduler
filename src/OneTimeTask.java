import java.time.LocalDate;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, String description, Repeatability repeatability) {
        super(title, type, description, repeatability);
    }
}
