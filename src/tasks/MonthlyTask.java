package tasks;

import enums.Repeatability;
import exeptions.IncorrectArgumentException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        super(title, type, description, dateTime, repeatability);
    }

    @Override
    public boolean appearsIn(LocalDate currentDate) {
        LocalDate taskDate = getDateTime().toLocalDate();
        return currentDate.isEqual(taskDate) || MonthDay.from(currentDate).equals(MonthDay.from(taskDate));
    }
}

