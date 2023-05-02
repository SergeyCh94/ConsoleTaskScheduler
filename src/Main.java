import enums.Repeatability;
import enums.Type;
import exeptions.IncorrectArgumentException;
import exeptions.TaskNotFoundException;
import tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException, TaskNotFoundException {
        OneTimeTask oneTimeTask = new OneTimeTask("OneTimeTask", Type.PERSONAL, "Task one time",
                LocalDateTime.of(2023,12,12,10,00), Repeatability.ONE_TIME);
        DailyTask dailyTask = new DailyTask("DailyTask", Type.PERSONAL, "Task daily",
                LocalDateTime.of(2024,12,12,10,00), Repeatability.DAILY);
        WeeklyTask weeklyTask = new WeeklyTask("WeeklyTask", Type.PERSONAL, "Task weekly",
                LocalDateTime.of(2025,12,12,10,00), Repeatability.WEEKLY);
        MonthlyTask monthlyTask = new MonthlyTask("MonthlyTask", Type.PERSONAL, "Task monthly",
                LocalDateTime.of(2026,12,12,10,00), Repeatability.MONTHLY);
        YearlyTask yearlyTask = new YearlyTask("YearlyTask", Type.PERSONAL, "Task yearly",
                LocalDateTime.of(2027,12,12,10,00), Repeatability.YEARLY);

        TaskService taskService = new TaskService();
        taskService.addTask(oneTimeTask);
        taskService.addTask(dailyTask);
        taskService.addTask(weeklyTask);
        taskService.addTask(monthlyTask);
        taskService.addTask(yearlyTask);

        System.out.println("All tasks: ");
        taskService.printAllTasks();
        System.out.println("________________________________________");

        taskService.removeTask(oneTimeTask.getId());
        System.out.println("Tasks after removing oneTimeTask: ");
        taskService.printAllTasks();
        System.out.println("________________________________________");

        System.out.println("Tasks on date " + LocalDate.of(2024,12,12) + ": ");
        System.out.println(taskService.getAllByDate(LocalDate.of(2024,12,12)));
    }
}
