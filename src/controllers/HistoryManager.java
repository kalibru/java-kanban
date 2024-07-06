package controllers;


import model.Epic;
import model.SubTask;
import model.Task;
import java.util.List;

public interface  HistoryManager {
    List<Task> getHistory();

    void addHistory(Task task);
    void addHistory(SubTask task);
    void addHistory(Epic task);

}
