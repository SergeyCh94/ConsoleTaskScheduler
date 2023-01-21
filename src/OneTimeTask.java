import java.time.LocalDate;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public void appearsIn(LocalDate localDate) {
        super.appearsIn(localDate);
    }
}
