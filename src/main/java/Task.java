public abstract class Task {
    private String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    public void mark() {
        if (isDone) {
            throw new IllegalStateException("OOPS!!! This task is already marked as done.");
        }
        this.isDone = true;
    }

    public void unmark() {
        if (!isDone) {
            throw new IllegalStateException("OOPS!!! This task is not marked as done yet.");
        }
        this.isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getDesc() {
        return desc;
    }

    public abstract String getType();

    public abstract String toFileString();

    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + desc;
    }
}

