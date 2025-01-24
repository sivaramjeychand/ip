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

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public void deleteTask(int index) {
        if (isValidIndex(index)) {
            Task removedTask = tasks.remove(index);
            System.out.println("      Noted. I've removed this task:");
            System.out.println("        " + removedTask);
        }
    }

    public void markTask(int index) {
        if (isValidIndex(index)) {
            try {
                tasks.get(index).mark();
                System.out.println("      Nice! I've marked this task as done:");
                System.out.println("      " + tasks.get(index));
            } catch (IllegalStateException e) {
                System.out.println("      " + e.getMessage());
            }
        }
    }

    public void unmarkTask(int index) {
        if (isValidIndex(index)) {
            try {
                tasks.get(index).unmark();
                System.out.println("      OK, I've marked this task as not done yet:");
                System.out.println("      " + tasks.get(index));
            } catch (IllegalStateException e) {
                System.out.println("      " + e.getMessage());
            }
        }
    }

    public void printList() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("      " + (i + 1) + ". " + tasks.get(i));
        }
    }

    private boolean isValidIndex(int index) {
        if (tasks.isEmpty()) {
            System.out.println("      OOPS!!! The task list is empty. Add tasks to your list before doing anything else");
            return false;
        }
        if (index < 0 || index >= tasks.size()) {
            System.out.println("      OOPS!!! The task index is out of range.");
            return false;
        }
        return true;
    }
}
