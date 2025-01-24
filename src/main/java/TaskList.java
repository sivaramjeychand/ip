import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).mark();
            System.out.println("      Nice! I've marked this task as done:");
            System.out.println("      " + tasks.get(index));
        }
    }

    public void unmarkTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).unmark();
            System.out.println("      OK, I've marked this task as not done yet:");
            System.out.println("      " + tasks.get(index));
        }
    }

    public void printList() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("      " + (i + 1) + ". " + tasks.get(i));
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}
