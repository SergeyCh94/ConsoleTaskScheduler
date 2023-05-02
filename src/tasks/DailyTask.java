package tasks;

import enums.Repeatability;
import exeptions.IncorrectArgumentException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        super(title, type, description, dateTime, repeatability);
        if (!Repeatability.DAILY.equals(repeatability)) {
            throw new IncorrectArgumentException("Repeatability must be DAILY for DailyTask");
        }
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isAfter(getDateTime().toLocalDate()) || date.isEqual(getDateTime().toLocalDate());
    }

}

