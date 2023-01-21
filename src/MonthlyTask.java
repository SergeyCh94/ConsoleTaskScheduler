import java.time.LocalDate;

public class MonthlyTask extends Task{

    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public void appearsIn(LocalDate localDate) {
        super.appearsIn(localDate);
    }
}
