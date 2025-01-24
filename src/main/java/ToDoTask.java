public class ToDoTask extends Task {
    public ToDoTask(String description) {
        super(description);
    }

    @Override
    public String getType() {
        return "[T]";
    }

    @Override
    public String toString() {
        return getType() + super.toString();
    }
}
