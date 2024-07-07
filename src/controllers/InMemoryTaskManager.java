package controllers;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private final HashMap<Integer, SubTask> subtasks = new HashMap<>();
    private HistoryManager historyManager = Managers.getDefaultHistory();
    @Override
    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public ArrayList<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    @Override
    public ArrayList<SubTask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }
    @Override
    public List<Task> getHistory(){
        return new ArrayList<>(historyManager.getHistory());
    }

    @Override
    public Task getTask(int id) {
        historyManager.addHistory(tasks.get(id));
        return tasks.get(id);
    }

    @Override
    public Epic getEpic(int id) {
        historyManager.addHistory(epics.get(id));
        return epics.get(id);
    }

    @Override
    public SubTask getSubTask(int id) {
        historyManager.addHistory(subtasks.get(id));
        return subtasks.get(id);
    }

    @Override
    public ArrayList<SubTask> getEpicSubtasks(int id) {
        return epics.get(id).getSubtasks();
    }

    @Override
    public void delTasks() {
        tasks.clear();
    }

    @Override
    public void delEpics() {
        epics.clear();
        subtasks.clear();
    }

    @Override
    public void delSubtasks() {
        subtasks.clear();
        for (Epic epic : epics.values()) {
            epic.clearSubTask();
            epic.updateEpicStatus();
        }
    }


    @Override
    public void delTask(int id) {
        tasks.remove(id);
    }

    @Override
    public void delEpic(int id) {
        if (epics.get(id) != null) {
            for (SubTask task : epics.get(id).getSubtasks()) {
                subtasks.remove(task.getId());
            }
        }
        epics.remove(id);
    }

    @Override
    public void delSubtask(int EpicId, int id) {
        subtasks.remove(id);
        epics.get(EpicId).getSubtasks().removeIf(task -> task.getId() == id);
        epics.get(EpicId).updateEpicStatus();
    }

    @Override
    public int add(Task task) {
        final int id = task.hashCode();
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    @Override
    public int add(Epic epic) {
        final int id = epic.hashCode();
        epic.setId(id);
        epics.put(id, epic);
        epic.updateEpicStatus();
        return id;
    }

    @Override
    public int add(Epic epic, SubTask task) {
        final int id = task.hashCode();
        task.setId(id);
        epic.addSubTask(task);
        task.setEpic(epic);
        task.setEpic(epic);
        subtasks.put(id, task);
        epic.updateEpicStatus();
        return id;
    }


    @Override
    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void updateSubTask(Epic epic, SubTask subTask) {
        int index = epics.get(epic.getId()).getSubtasks().indexOf(subTask);
        epics.get(epic.getId()).getSubtasks().set(index, subTask);
        epic.updateEpicStatus();
    }

    @Override
    public void updateEpic(Epic epic) {
        epic.updateEpicStatus();
        epics.put(epic.getId(), epic);
    }

}

