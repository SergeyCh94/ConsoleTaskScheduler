package tasks;

import enums.Repeatability;
import enums.Type;
import exeptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        super(title, type, description, dateTime, repeatability);
    }

    @Override
    public boolean appearsIn(LocalDate dateTime) {
        return dateTime.isEqual(getDate().toLocalDate()) || dateTime.getDayOfMonth() == getDate().getDayOfMonth() &&
                dateTime.isAfter(getDate().toLocalDate());
    }
}
