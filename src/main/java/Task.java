public abstract class Task {
    private String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public abstract String getType();

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + desc;
    }
}

