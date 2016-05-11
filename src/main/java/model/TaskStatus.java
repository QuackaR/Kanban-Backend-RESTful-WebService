package model;

public enum TaskStatus {

    BACKLOG("Backlog"),
    TODO("ToDo"),
    PROGRESS("Progress"),
    WAITING("Waiting"),
    DONE("Done");

    private String name;

    TaskStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskStatus{" +
                "name='" + name + '\'' +
                '}';
    }
}
