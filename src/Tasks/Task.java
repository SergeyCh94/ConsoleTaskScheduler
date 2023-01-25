package Tasks;

import Enums.Repeatability;
import Enums.Type;

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

    public Task(String title, Type type, String description, LocalDateTime dateTime, Repeatability repeatability) {
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

    public LocalDateTime getDate() {
        return dateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }


    public void setTitle(String title) throws IllegalArgumentException {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Заголовок не может быть пустым");
        }
        this.title = title;
    }

    public void setType(Type type)  throws IllegalArgumentException {
        if (type == null) {
            throw new IllegalArgumentException("Тип не может быть пустым");
        }
        this.type = type;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Описание не может быть пустым");
        }
        this.description = description;
    }

    public void setRepeatability(Repeatability repeatability) throws IllegalArgumentException {
        if (repeatability == null) {
            throw new IllegalArgumentException("Повторность не может быть пустым");
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
