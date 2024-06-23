public class SubTask extends Task {
    SubTask(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "SubTask{name: " + getName() +
                ", description: " + getDescription() +
                ", status: " + getStatus() +
                ", ID: " + getId() + "}";

    }
}
