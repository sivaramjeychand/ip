package hamiltonianguy.tasks;

public abstract class Task {
    private String desc;
    private boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    public Task(String desc, boolean isDone) {
        this.desc = desc;
        this.isDone = isDone;
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

<<<<<<< HEAD:src/main/java/hamiltonianguy/tasks/Task.java
=======
    public boolean isDone() {
        return isDone;
    }

    public String getDesc() {
        return desc;
    }

>>>>>>> branch-Level-7:src/main/java/Task.java
    @Override
    public String toString() {
        String status = isDone ? "[X]" : "[ ]";
        return status + " " + desc;
    }
}

