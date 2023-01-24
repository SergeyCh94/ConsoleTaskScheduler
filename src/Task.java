import java.time.LocalDate;
import java.util.Objects;

public class Task {
    static int idGenerator = 0;
    private String title;
    private Type type;
    final int id;
    private String description;
    private LocalDate date;
    private Repeatability repeatability;
    private LocalDate nextDate;

    public Task(String title, Type type, String description, Repeatability repeatability) {
        id = idGenerator++;
        this.title = title;
        setTitle(title);
        this.type = type;
        setType(type);
        this.description = description;
        setDescription(description);
        this.repeatability = repeatability;
        date = LocalDate.now();
        nextDate();
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public LocalDate getNextDate() {
        return nextDate;
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

    public void nextDate() {
        switch (this.repeatability) {
            case ONE_TIME:
                nextDate = date;
                break;
            case DAILY:
                nextDate = date.plusDays(1);
                break;
            case WEEKLY:
                nextDate = date.plusWeeks(1);
                break;
            case MONTHLY:
                nextDate = date.plusMonths(1);
                break;
            case YEARLY:
                nextDate = date.plusYears(1);
                break;
            default:
                break;
        }
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
        return "Задача №: " + id + "\n" +
                "Заголовок: " + title + "\n" +
                "Тип задачи: " + type.getType() + "\n" +
                "Дата задачи: " + date + "\n" +
                "Повторяемость: " + repeatability.getRepeatability() + "\n";
    }
}
