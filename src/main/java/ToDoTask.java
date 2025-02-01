public class ToDoTask extends Task {
    public ToDoTask(String description) {
        super(description);
    }

    public ToDoTask(String desc, boolean isDone) {
        super(desc);
        if (isDone) {
            this.mark();
        }
    }

    @Override
    public String getType() {
        return "[T]";
    }

    @Override
    public String toString() {
        return getType() + super.toString();
    }

    @Override
    public String toFileString() {
        return "T | " + (isDone() ? "1" : "0") + " | " + getDesc();
    }
}
