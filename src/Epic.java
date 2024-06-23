
import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<SubTask> subTasks;

    Epic(String name, String description) {
        super(name, description);
    }

    public void addSubTask(SubTask task) {
        if (subTasks == null) {
            subTasks = new ArrayList<>();
        }
        subTasks.add(task);
    }


    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "Epic{name: " + getName() +
                ", description: " + getDescription() +
                ", status: " + getStatus() +
                ", ID: " + getId() +
                ", " + subTasks + "}";
    }
}
