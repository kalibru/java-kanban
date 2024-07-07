package controllers;


import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final ArrayList<Task> taskHistory = new ArrayList<>(10);

    @Override
    public List<Task> getHistory() {
        return taskHistory;
    }

    @Override
    public void addHistory(Task task) {
        if (taskHistory.size() == 10) {
            taskHistory.removeFirst();
        }
        taskHistory.addLast(task);
    }

}
