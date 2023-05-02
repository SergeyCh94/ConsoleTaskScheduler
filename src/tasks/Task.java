package tasks;

import enums.Repeatability;
import exeptions.IncorrectArgumentException;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 0;

    private final int id;
    private final String title;
    private final Type type;
    private final String description;
    private final LocalDateTime dateTime;
    private final Repeatability repeatability;

    public Task(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        if (title == null || title.trim().isEmpty()) {
            throw new IncorrectArgumentException("Title cannot be empty");
        }
        if (type == null) {
            throw new IncorrectArgumentException("Type cannot be null");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IncorrectArgumentException("Description cannot be empty");
        }
        if (repeatability == null) {
            throw new IncorrectArgumentException("Repeatability cannot be null");
        }

        idGenerator++;
        this.id = idGenerator;
        this.title = title;
        this.type = type;
        this.description = description;
        this.dateTime = dateTime;
        this.repeatability = repeatability;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public abstract boolean appearsIn(LocalDate dateTime);

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(title, task.title) &&
                type == task.type &&
                Objects.equals(description, task.description) &&
                Objects.equals(dateTime, task.dateTime) &&
                repeatability == task.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, description, dateTime, repeatability);
    }

    @Override
    public String toString() {
        return "Task #" + id +
                "\nTitle: " + title +
                "\nType: " + type +
                "\nDescription: " + description +
                "\nDate time: " + dateTime +
                "\nRepeatability: " + repeatability;
    }
}
