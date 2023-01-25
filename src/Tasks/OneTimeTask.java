package Tasks;

import Enums.Repeatability;
import Enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class OneTimeTask extends Task{
    public OneTimeTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) {
        super(title, type, description, dateTime, repeatability);
    }

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.isEqual(getDate().toLocalDate());
    }
}
