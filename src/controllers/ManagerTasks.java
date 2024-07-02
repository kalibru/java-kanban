package controllers;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
public class ManagerTasks {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, SubTask> subtasks = new HashMap<>();

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public ArrayList<Epic> getEpic() {
        return new ArrayList<>(epics.values());
    }

    public ArrayList<SubTask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public Epic getEpic(int id) {
        return epics.get(id);
    }

    public SubTask getSubTask(int id) {
        return subtasks.get(id);
    }

    public void delTasks() {
        tasks.clear();
    }

    public void delEpics() {
        epics.clear();
        subtasks.clear();
    }

    public void delSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.clearSubTask();
            epic.updateEpicStatus();
        }
    }


    public void delTask(int id) {
        tasks.remove(id);
    }

    public void delEpic(int id) {
        epics.remove(id);
        if (epics.get(id) != null) {
            for (SubTask task : epics.get(id).getSubtasks()) {
                subtasks.remove(task.getId());
            }
        }
    }

    public void delSubtask(int EpicId, int id) {
        subtasks.remove(id);
        epics.get(EpicId).getSubtasks().removeIf(task -> task.getId() == id);
        epics.get(EpicId).updateEpicStatus();
    }

    public int add(Task task) {
        final int id = task.hashCode();
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public int add(Epic epic) {
        final int id = epic.hashCode();
        epic.setId(id);
        epics.put(id, epic);
        epic.updateEpicStatus();
        return id;
    }

    public int add(Epic epic, SubTask task) {
        final int id = task.hashCode();
        task.setId(id);
        epic.addSubTask(task);
        subtasks.put(id, task);
        epic.updateEpicStatus();
        return id;
    }


    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateSubTask(Epic epic, SubTask subTask) {
        int index = epics.get(epic.getId()).getSubtasks().indexOf(subTask);
        epics.get(epic.getId()).getSubtasks().set(index, subTask);
        epic.updateEpicStatus();
    }

    public void updateEpic(Epic epic) {
        epic.updateEpicStatus();
        epics.put(epic.getId(), epic);
    }
}
