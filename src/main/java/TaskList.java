import java.util.List;

public class TaskList {
    private List<Task> tasks;
    private Storage storage;

    public TaskList(Storage storage) {
        this.storage = storage;
        this.tasks = storage.load(); // Load tasks on startup
    }

    public void addTask(Task task) {
        tasks.add(task);
        storage.save(tasks); // Save after adding
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public void deleteTask(int index) {
        if (isValidIndex(index)) {
            Task removedTask = tasks.remove(index);
            storage.save(tasks); // Save after deletion
            System.out.println("      Noted. I've removed this task:");
            System.out.println("        " + removedTask);
        }
    }

    public void markTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).mark();
            storage.save(tasks); // Save after marking done
            System.out.println("      Nice! I've marked this task as done:");
            System.out.println("      " + tasks.get(index));
        }
    }

    public void unmarkTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).unmark();
            storage.save(tasks); // Save after unmarking
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