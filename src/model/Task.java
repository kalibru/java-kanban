package model;

import java.util.Objects;

public class Task {
    private final int id;
    protected String name;
    protected String description;
    public TaskStatus status = TaskStatus.NEW;


    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = hashCode();
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        if (name != null) {
            hash = hash + name.hashCode();
        }
        hash = hash * 31;
        if (description != null) {
            hash = hash + description.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "model.Task{name: " + name +
                ", description: " + description +
                ", status: " + status +
                ", Id: " + id + "}";
    }
}
