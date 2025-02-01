public class DeadlineTask extends Task {
    private String by;

    public DeadlineTask(String desc, String by) {
        super(desc);
        this.by = by;
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
