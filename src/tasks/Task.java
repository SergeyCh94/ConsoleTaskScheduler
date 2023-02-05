package tasks;

import enums.Repeatability;
import enums.Type;
import exeptions.IncorrectArgumentException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    static int idGenerator = 0;
    private String title;
    private Type type;
    final int id;
    private String description;
    private LocalDateTime dateTime;
    private Repeatability repeatability;

    public Task(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectArgumentException {
        idGenerator++;
        this.id = idGenerator;
        setTitle(title);
        setType(type);
        setDescription(description);
        this.dateTime = dateTime;
        setRepeatability(repeatability);
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }


    public void setTitle(String title) throws IncorrectArgumentException {
        if (title == null || title.trim().isEmpty()) {
            throw new IncorrectArgumentException("Заголовок не может быть пустым");
        }
        this.title = title;
    }

    public void setType(Type type)  throws IncorrectArgumentException {
        if (type == null) {
            throw new IncorrectArgumentException("Тип не может быть пустым");
        }
        this.type = type;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.trim().isEmpty()) {
            throw new IncorrectArgumentException("Описание не может быть пустым");
        }
        this.description = description;
    }

    public void setRepeatability(Repeatability repeatability) throws IncorrectArgumentException {
        if (repeatability == null) {
            throw new IncorrectArgumentException("Повторность не может быть пустым");
        }
        this.repeatability = repeatability;
    }

    public abstract boolean appearsIn(LocalDate dateTime);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title)
                && type == task.type
                && Objects.equals(dateTime, task.dateTime)
                && Objects.equals(description, task.description)
                && Objects.equals(repeatability, task.repeatability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description, repeatability);
    }

    @Override
    public String toString() {
        return "Задача №: " + id + "\n" +
                "Заголовок: " + title + "\n" +
                "Тип задачи: " + type.getType() + "\n" +
                "Дата задачи: " + dateTime + "\n" +
                "Повторяемость: " + repeatability.getRepeatability() + "\n";
    }
}
