package tasks;

import exeptions.TaskNotFoundException;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskService {
    private Map<Integer, Task> taskService = new HashMap<>();

    public void addTask(Task task) {
        taskService.put(task.getId(), task);
    }

    public boolean removeTask(int id) throws TaskNotFoundException {
        boolean delete = false;
        for (Map.Entry<Integer, Task> entry : taskService.entrySet()) {
            if(entry.getValue().getId() == id) {
                taskService.remove(id);
                delete = true;
                break;
            } else {
                throw new TaskNotFoundException("Tasks.Task not found");
            }
        }
        return delete;
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskService.values().stream()
                .filter(e ->e.appearsIn(localDate)).collect(Collectors.toList());
    }

    public void printAllTasks() {
        for (Map.Entry<Integer, Task> entry : taskService.entrySet()) {
            System.out.println("id: " + entry.getKey() + " " + entry.getValue());
        }
    }
}
