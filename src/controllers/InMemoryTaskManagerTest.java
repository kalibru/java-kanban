package controllers;
import model.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    @Test
    void taskIdEqualsTest() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task taskOne = new Task("Test name task", "Test description task");
        manager.add(taskOne);
        Task taskTwo = new Task("Test name task", "Test description task");
        manager.add(taskTwo);
        assertEquals(taskOne.getId(), taskTwo.getId());
        assertEquals(taskOne, taskTwo);
    }

    @Test
    void subtaskIdEqualsTest() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Epic epic = new Epic("Test name epic", "Test description epic");
        manager.add(epic);
        SubTask subtaskOne = new SubTask("Test name subtask", "Test description subtask");
        manager.add(epic, subtaskOne);
        SubTask subtaskTwo = new SubTask("Test name subtask", "Test description subtask");
        manager.add(epic, subtaskTwo);
        assertEquals(subtaskOne.getId(), subtaskTwo.getId());
        assertEquals(subtaskOne, subtaskTwo);
    }

    @Test
    void EpicIdEqualsTest() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Epic epicOne = new Epic("Test name epic", "Test description epic");
        manager.add(epicOne);

        Epic epicTwo = new Epic("Test name epic", "Test description epic");
        manager.add(epicTwo);

        SubTask subtask = new SubTask("Test name subtask", "Test description subtask");
        manager.add(epicOne, subtask);
        manager.add(epicTwo, subtask);

        assertEquals(epicOne.getId(), epicTwo.getId());
        assertEquals(epicOne, epicTwo);
    }

    @Test
    void addTaskIsEmptyListTest() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Test name task", "Test description task");
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(task);
        manager.add(epic);
        manager.add(epic, subtask);

        assertFalse(manager.getEpics().isEmpty());

        assertFalse(manager.getTasks().isEmpty());

        assertFalse(manager.getSubtasks().isEmpty());
    }

    @Test
    void getTasksIdTest() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Test name task", "Test description task");
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(task);
        manager.add(epic);
        manager.add(epic, subtask);

        assertEquals(task, manager.getTask(task.getId()));

        assertEquals(subtask, manager.getSubTask(subtask.getId()));

        assertEquals(epic, manager.getEpic(epic.getId()));

    }
    @Test
    void getEpicSubtasksIdTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        assertEquals(epic.getSubtasks(),manager.getEpicSubtasks(epic.getId()));
    }


    @Test
    void delTasksTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Test name task", "Test description task");
        manager.add(task);
        manager.delTasks();
        assertTrue(manager.getTasks().isEmpty());
    }

    @Test
    void delEpicsTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic,subtask);
        manager.delEpics();
        assertTrue(manager.getSubtasks().isEmpty());
        assertTrue(manager.getEpics().isEmpty());
    }

    @Test
    void delSubtasksTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic,subtask);
        manager.delSubtasks();
        assertTrue(manager.getSubtasks().isEmpty());

    }

    @Test
    void delTaskTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Test name task", "Test description task");
        manager.add(task);
        manager.delTask(task.getId());
        assertTrue(manager.getTasks().isEmpty());

    }

    @Test
    void delEpicTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic,subtask);
        manager.delEpic(epic.getId());
        assertTrue(manager.getSubtasks().isEmpty());
        assertTrue(manager.getEpics().isEmpty());

    }


    @Test
    void delSubtaskTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic,subtask);
        manager.delSubtask(epic.getId(),subtask.getId());
        assertTrue(manager.getSubtasks().isEmpty());

    }
    @Test
    void updateEpicStatusTest(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic,subtask);
        subtask.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateEpic(epic);
        assertEquals(TaskStatus.IN_PROGRESS, epic.getStatus());

    }

}