package model;

public class SubTask extends Task {
    public SubTask(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "model.SubTask{name: " + getName() +
                ", description: " + getDescription() +
                ", status: " + status + "}";

    }
}
