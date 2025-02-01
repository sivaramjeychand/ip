public class EventTask extends Task {
    private String from;
    private String to;

    public EventTask(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getType() {
        return "[E]";
    }

    @Override
    public String toString() {
        return getType() + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toFileString() {
        return "E | " + (isDone() ? "1" : "0") + " | " + getDesc() + " | " + from + " | " + to;
    }
}
