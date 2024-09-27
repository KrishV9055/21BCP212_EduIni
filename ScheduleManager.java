package EduIni;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) throws Exception {
        if (!isConflict(task)) {
            tasks.add(task);
            tasks.sort(Comparator.comparing(Task::getStartTime));
            System.out.println("Task added successfully. No conflicts.");
        } else {
            throw new Exception("Error: Task conflicts with an existing task.");
        }
    }

    public void removeTask(String description) {
        Task task = findTaskByDescription(description);
        if (task != null) {
            tasks.remove(task);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private boolean isConflict(Task newTask) {
        for (Task task : tasks) {
            if (isTimeOverlap(newTask, task)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTimeOverlap(Task newTask, Task existingTask) {
        // Assuming time in HH:MM format
        return !(newTask.getEndTime().compareTo(existingTask.getStartTime()) <= 0 ||
                newTask.getStartTime().compareTo(existingTask.getEndTime()) >= 0);
    }

    private Task findTaskByDescription(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                return task;
            }
        }
        return null;
    }
}
