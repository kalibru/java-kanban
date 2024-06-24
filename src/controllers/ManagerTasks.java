package controllers;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
public class ManagerTasks {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epicTasks = new HashMap<>();
    private HashMap<Integer, SubTask> subTasks = new HashMap<>();

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getEpic() {
        return new ArrayList<>(epicTasks.values());
    }

    public ArrayList<SubTask> getSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        return epicTasks.get(id);
    }

    public SubTask getSubTask(int id) {
        return subTasks.get(id);
    }

    public void delTasks() {
        tasks.clear();
    }

    public void delEpicTasks() {
        epicTasks.clear();
        subTasks.clear();
    }

    public void delSubTasks() {
        subTasks.clear();
        for (Epic epic : epicTasks.values()) {
            epic.clearSubTask();
            epic.updateEpicStatus();
        }
    }


    public void delTask(int id) {
        tasks.remove(id);
    }

    public void delEpicTask(int id) {
        epicTasks.remove(id);
        if(epicTasks.get(id)!=null) {
            for (SubTask task : epicTasks.get(id).getSubTasks()) {
                subTasks.remove(task.getId());
            }
        }
    }

    public void delSubTask(int EpicId, int id) {
        subTasks.remove(id);
        epicTasks.get(EpicId).getSubTasks().removeIf(task -> task.getId() == id);
        epicTasks.get(EpicId).updateEpicStatus();
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void addEpicTask(Epic epicTask) {
        epicTasks.put(epicTask.getId(), epicTask);
            epicTask.updateEpicStatus();

    }

    public void addEpicSubTask(Epic epicTask, SubTask task) {
        epicTasks.get(epicTask.getId()).addSubTask(task);
        subTasks.put(task.getId(), task);
        epicTask.updateEpicStatus();

    }


    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateSubTask(Epic epicTask, SubTask subTask) {
        int index = epicTasks.get(epicTask.getId()).getSubTasks().indexOf(subTask);
        epicTasks.get(epicTask.getId()).getSubTasks().set(index, subTask);
        epicTask.updateEpicStatus();
    }

    public void updateEpicTask(Epic epicTask) {
        epicTask.updateEpicStatus();
        epicTasks.put(epicTask.getId(), epicTask);
    }

}
