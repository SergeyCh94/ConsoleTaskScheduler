package tasks;

import enums.Repeatability;
import enums.Type;
import exeptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        super(title, type, description, dateTime, repeatability);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isEqual(getDate().toLocalDate()) || date.getDayOfYear() == getDate().getDayOfYear() &&
                date.isAfter(getDate().toLocalDate());
    }
}
