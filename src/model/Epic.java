package model;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<SubTask> subTasks;

    public Epic(String name, String description) {
        super(name, description);
    }
    public Epic(Epic afterEpic){
        super(afterEpic.name, afterEpic.description);
        this.subTasks = afterEpic.subTasks;
        this.id = afterEpic.id;
        setStatus(afterEpic.getStatus());
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
                switch (task.getStatus()){
                    case DONE -> doneTasks++;
                    case NEW -> newTasks++;
                }
            }
            if(doneTasks == subTasks.size()){
                setStatus(TaskStatus.DONE);
            }
            if (newTasks == subTasks.size()){
                setStatus(TaskStatus.NEW);
            }
            if(doneTasks != subTasks.size() && newTasks != subTasks.size()){
                setStatus(TaskStatus.IN_PROGRESS);
            }
        } else setStatus(TaskStatus.NEW);
    }

    @Override
    public String toString() {
        return "model.Epic{name: " + getName() +
                ", description: " + getDescription() +
                ", status(): " + getStatus() +
                ", " + subTasks + "}";
    }



}
