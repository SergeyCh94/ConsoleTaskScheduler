package tasks;

import enums.Repeatability;
import exeptions.IncorrectArgumentException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        super(title, type, description, dateTime, repeatability);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isEqual(getDateTime().toLocalDate()) || date.getDayOfYear() == getDateTime().getDayOfYear() &&
                date.isAfter(getDateTime().toLocalDate());
    }
}
