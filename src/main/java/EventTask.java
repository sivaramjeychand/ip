public class EventTask extends Task {
    private String from;
    private String to;

    public EventTask(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    public EventTask(String desc, String from, String to, boolean isDone) {
        super(desc);
        this.from = from;
        this.to = to;
        if (isDone) {
            this.mark();
        }
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

