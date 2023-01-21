import java.time.LocalDate;

public class WeeklyTask extends Task{

    public WeeklyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public void appearsIn(LocalDate localDate) {
        super.appearsIn(localDate);
    }
}
