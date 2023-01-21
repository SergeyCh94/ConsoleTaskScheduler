import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public void appearsIn(LocalDate localDate) {
        super.appearsIn(localDate);
    }
}
