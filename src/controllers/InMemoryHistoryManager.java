package controllers;

import model.Epic;
import model.SubTask;
import model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private final ArrayList<Task> taskHistory = new ArrayList<>(10);
    @Override
    public List<Task> getHistory(){
        return taskHistory;
    }
    @Override
    public void addHistory(Task task){
        if(taskHistory.size() == 10){
            taskHistory.removeFirst();
            taskHistory.addLast(new Task(task));
        }else taskHistory.addLast(new Task(task));
    }
    @Override
    public void addHistory(SubTask task){
        if(taskHistory.size() == 10){
            taskHistory.removeFirst();
            taskHistory.addLast(new SubTask(task));
        }else taskHistory.addLast(new SubTask(task));
    }
    @Override
    public void addHistory(Epic task){
        if(taskHistory.size() == 10){
            taskHistory.removeFirst();
            taskHistory.addLast(new Epic(task));
        }else taskHistory.addLast(new Epic(task));
    }
}
