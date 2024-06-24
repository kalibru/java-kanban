package model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<SubTask> subTasks;
    private TaskStatus status = TaskStatus.NEW;

    public Epic(String name, String description) {
        super(name, description);
    }

    public void addSubTask(SubTask task) {
        if (subTasks == null) {
            subTasks = new ArrayList<>();
        }
        subTasks.add(task);
        updateEpicStatus();
    }

    public void clearSubTask() {
        subTasks.clear();
    }


    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    public void updateEpicStatus() {
        if (subTasks != null) {
            int doneTasks = 0;
            for (SubTask task : subTasks) {
                if (task.status.equals(TaskStatus.DONE)) {
                    doneTasks++;
                }
                if (doneTasks == subTasks.size()) {
                    setStatus(TaskStatus.DONE);
                } else if (doneTasks > 0) {
                    setStatus(TaskStatus.IN_PROGRESS);
                }
                if (task.status.equals(TaskStatus.IN_PROGRESS)) {
                    setStatus(TaskStatus.IN_PROGRESS);
                }
            }
        } else status = TaskStatus.NEW;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "model.Epic{name: " + getName() +
                ", description: " + getDescription() +
                ", status: " + status +
                ", ID: " + getId() +
                ", " + subTasks + "}";
    }


    public TaskStatus getStatus() {
        return status;
    }
}
