
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    static TaskService taskService = new TaskService();

    private static void printMenu() {
        System.out.println("1. Добавить задачу \n" +
                "2. Получить задачу на день \n" +
                "3. Удалить задачу по ID \n" +
                "4. Вывод всех задач \n");
    }
    public static void main(String[] args) throws IllegalArgumentException {
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                System.out.println("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            createTask(scanner);
                            break;
                        case 2:
                            System.out.println("Введите ID задачи: ");
                            int remove = scanner.nextInt();
                            if (taskService.removeTask(remove)){
                                System.out.println("Задача удалена");
                            } else {
                                System.out.println("Задача не найдена");
                            }
                            break;
                        case 3:
                            System.out.println("Введите дату: ");
                            String date = scanner.next();
                            LocalDate localDate = LocalDate.parse(date);
                            taskService.getAllByDate(localDate);
                            break;
                        case 4:
                            taskService.printAllTasks();
                            break;
                        default:
                            throw new IllegalArgumentException("Некорректный пункт меню");
                    }
                }
            }
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTask(Scanner scanner) {
        System.out.println("Введите заголовок: ");
        String title = scanner.next();
        System.out.println("Введите описание: ");
        String description = scanner.next();
        int repeatability;

        System.out.println("Введите повторность: 1 - однократная,2 - ежедневная,3 - еженедельная,4 - ежемесячная,5- ежегодная");
        repeatability = scanner.nextInt();

        while (repeatability > 0 && repeatability < 6);
        switch (repeatability) {
            case 1:
                Task task1 = new Task(title, Type.PERSONAL, description, Repeatability.ONE_TIME);
                taskService.addTask(task1.getId(), task1);
                break;
            case 2:
                Task task2 = new Task(title, Type.PERSONAL, description, Repeatability.DAILY);
                taskService.addTask(task2.getId(), task2);
                break;
            case 3:
                Task task3 = new Task(title, Type.PERSONAL, description, Repeatability.WEEKLY);
                taskService.addTask(task3.getId(), task3);
                break;
            case 4:
                Task task4 = new Task(title, Type.PERSONAL, description, Repeatability.MONTHLY);
                taskService.addTask(task4.getId(), task4);
                break;
            case 5:
                Task task5 = new Task(title, Type.PERSONAL, description, Repeatability.YEARLY);
                taskService.addTask(task5.getId(), task5);
                break;
            default:
                System.out.println("Неверная повторность");
                break;
        }
    }
}