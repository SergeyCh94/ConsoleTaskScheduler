package Tasks;

import Enums.Repeatability;
import Enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) {
        super(title, type, description, dateTime, repeatability);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isAfter(getDate().toLocalDate()) || date.isEqual(getDate().toLocalDate());
    }
}
