package controllers;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.List;


public interface TaskManager {

    ArrayList<Task> getTasks();

    ArrayList<Epic> getEpics();

    ArrayList<SubTask> getSubtasks();

    ArrayList<SubTask> getEpicSubtasks(int id);

    Task getTask(int id);

    Epic getEpic(int id);

    SubTask getSubTask(int id);

    void delTasks();

    void delEpics();

    void delSubtasks();

    void delTask(int id);

    void delEpic(int id);

    void delSubtask(int EpicId, int id);

    int add(Task task);

    int add(Epic epic);

    int add(Epic epic, SubTask task);

    void updateTask(Task task);

    void updateSubTask(Epic epic, SubTask subTask);

    void updateEpic(Epic epic);

    List<Task> getHistory();

}
