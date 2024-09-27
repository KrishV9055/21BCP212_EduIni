package EduIni;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskFactory taskFactory = new TaskFactory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:MM): ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time (HH:MM): ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority (Low, Medium, High): ");
                    String priority = scanner.nextLine();

                    Task task = taskFactory.createTask(description, startTime, endTime, priority);
                    try {
                        scheduleManager.addTask(task);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter task description to remove: ");
                    String removeDescription = scanner.nextLine();
                    scheduleManager.removeTask(removeDescription);
                    break;

                case 3:
                    scheduleManager.viewTasks();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

