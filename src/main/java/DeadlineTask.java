public class DeadlineTask extends Task {
    private String by;

    public DeadlineTask(String desc, String by) {
        super(desc);
        this.by = by;
    }

    public DeadlineTask(String desc, String by, boolean isDone) {
        super(desc);
        this.by = by;
        if (isDone) {
            this.mark(); // Mark the task as done
        }
    }

    @Override
    public String getType() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getType() + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone() ? "1" : "0") + " | " + getDesc() + " | " + by;
    }
}
