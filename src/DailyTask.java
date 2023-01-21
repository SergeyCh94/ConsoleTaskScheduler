import java.time.LocalDate;

public class DailyTask extends Task{

    public DailyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public void appearsIn(LocalDate localDate) {
        super.appearsIn(localDate);
    }
}
