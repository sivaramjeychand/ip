import java.util.ArrayList;
import java.util.List;

public class Task {
    private List<String> items;
    private List<Boolean> marked;

    public Task() {
        items = new ArrayList<>();
        marked = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
        marked.add(false);  // Initialize new item as unmarked.
    }

    public void markItem(int index) {
        if (index >= 0 && index < marked.size()) {
            marked.set(index, true);  // Mark item as true.
        }
    }

    public void unmarkItem(int index) {
        if (index >= 0 && index < marked.size()) {
            marked.set(index, false);  // Unmark item as false.
        }
    }

    public void printList() {
        for (int i = 0; i < items.size(); i++) {
            String status = marked.get(i) ? "[X] " : "[ ] ";
            System.out.println("      " + (i + 1) + ". " + status + items.get(i));
        }
    }

    public void printElement(int index) {
        if (index >= 0 && index < items.size()) {
            String status = marked.get(index) ? "[X] " : "[ ] ";
            System.out.println("      " + (index + 1) + ". " + status + items.get(index));
        } else {
            System.out.println("      Invalid index.");
        }
    }
}
