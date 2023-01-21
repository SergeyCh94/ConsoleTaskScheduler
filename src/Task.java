import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private String title;
    private Type type;
    private int id;
    private LocalDate date;
    private String description;
    private String repeatability;

    public Task(String title, Type type, String description) throws IncorrectArgumentException{
        id = ID_GENERATOR.getAndIncrement();
        setTitle(title);
        this.title = title;
        setType(type);
        this.type = type;
        setRepeatability(repeatability);
        this.description = description;
        setDescription(description);
        this.date = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setTitle(String title) throws IncorrectArgumentException{
        if (title == null || title.isEmpty()) {
            throw new IncorrectArgumentException("Пустое поле - Заголовок");
        }
        this.title = title;
    }

    public void setDescription(String description) throws IncorrectArgumentException{
        if (description == null || description.isEmpty()) {
            throw new IncorrectArgumentException("Пустое поле - Описание");
        }
        this.description = description;
    }

    public void setRepeatability(String repeatability) throws IncorrectArgumentException{
        if (repeatability == null || repeatability.isEmpty()) {
            throw new IncorrectArgumentException("Пустое поле - Тип задачи");
        }
        this.repeatability = repeatability;
    }

    public void setType(Type type) throws IncorrectArgumentException{
        if (type == null) {
            throw new IncorrectArgumentException("Пустое поле - Тип задачи");
        }
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title)
                && type == task.type
                && Objects.equals(date, task.date)
                && Objects.equals(description, task.description)
                && Objects.equals(repeatability, task.repeatability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, date, description, repeatability);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
