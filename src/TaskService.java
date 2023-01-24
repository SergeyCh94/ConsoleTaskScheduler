import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private Map<Integer, Task> taskService = new HashMap<>();

    public void addTask(int id, Task task) {
        taskService.put(id, task);
    }

    public boolean removeTask(int id) throws TaskNotFoundException {
        boolean delete = false;
        for (Map.Entry<Integer, Task> entry : taskService.entrySet()) {
            if(entry.getValue().getId() == id) {
                taskService.remove(id);
                delete = true;
                break;
            } else {
                throw new TaskNotFoundException("Task not found");
            }
        }
        return delete;
    }

    public void getAllByDate(LocalDate inputData) throws TaskNotFoundException {
        System.out.println("input data: " + inputData);
        for (Map.Entry<Integer, Task> entry : taskService.entrySet()) {
            if(entry.getValue().getNextDate().isEqual(inputData)) {
                System.out.println(entry.getValue());
            } else {
                throw new TaskNotFoundException("Task not found");
            }
        }
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : taskService.entrySet()) {
            System.out.println("id: " + entry.getKey() + " " + entry.getValue());
        }
    }
}
