package model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<SubTask> subTasks;
    private TaskStatus status;

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


    public ArrayList<SubTask> getSubtasks() {
        return subTasks;
    }

    public void updateEpicStatus() {
        if (subTasks != null) {
            int doneTasks = 0;
            int newTasks = 0;
            for (SubTask task : subTasks) {
                switch (task.status){
                    case DONE -> doneTasks++;
                    case NEW -> newTasks++;
                }
                if(doneTasks == subTasks.size()){
                    status = TaskStatus.DONE;
                }
                if (newTasks == subTasks.size()){
                    status = TaskStatus.NEW;
                }
                if(doneTasks != subTasks.size() && newTasks != subTasks.size()){
                    status = TaskStatus.IN_PROGRESS;
                }
            }
        } else status = TaskStatus.NEW;
    }

    @Override
    public String toString() {
        return "model.Epic{name: " + getName() +
                ", description: " + getDescription() +
                ", status: " + status +
                ", " + subTasks + "}";
    }


    public TaskStatus getStatus() {
        return status;
    }
}
