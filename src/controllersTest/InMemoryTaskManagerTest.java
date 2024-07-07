package controllersTest;
import controllers.InMemoryTaskManager;
import controllers.Managers;
import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    private InMemoryTaskManager manager;

    @BeforeEach
    void beforeEach() {
        manager = (InMemoryTaskManager) Managers.getDefault();
    }

    @Test
    void taskIdEqualsTest() {
        Task taskOne = new Task("Test name task", "Test description task");
        manager.add(taskOne);
        Task taskTwo = new Task("Test name task", "Test description task");
        manager.add(taskTwo);
        assertEquals(taskOne.getId(), taskTwo.getId());
        assertEquals(taskOne, taskTwo);
    }

    @Test
    void subtaskIdEqualsTest() {
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
    void getEpicSubtasksIdTest() {
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        assertEquals(epic.getSubtasks(), manager.getEpicSubtasks(epic.getId()));
    }


    @Test
    void delTasksTest() {
        Task task = new Task("Test name task", "Test description task");
        manager.add(task);
        manager.delTasks();
        assertTrue(manager.getTasks().isEmpty());
    }

    @Test
    void delEpicsTest() {
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        manager.delEpics();
        assertTrue(manager.getSubtasks().isEmpty());
        assertTrue(manager.getEpics().isEmpty());
    }

    @Test
    void delSubtasksTest() {
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        manager.delSubtasks();
        assertTrue(manager.getSubtasks().isEmpty());

    }

    @Test
    void delTaskTest() {
        Task task = new Task("Test name task", "Test description task");
        manager.add(task);
        manager.delTask(task.getId());
        assertTrue(manager.getTasks().isEmpty());

    }

    @Test
    void delEpicTest() {
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        manager.delEpic(epic.getId());
        assertTrue(manager.getSubtasks().isEmpty());
        assertTrue(manager.getEpics().isEmpty());

    }


    @Test
    void delSubtaskTest() {
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        manager.delSubtask(epic.getId(), subtask.getId());
        assertTrue(manager.getSubtasks().isEmpty());

    }

    @Test
    void updateEpicStatusTest() {
        SubTask subtask = new SubTask("Test name task", "Test description task");
        Epic epic = new Epic("Test name task", "Test description task");
        manager.add(epic);
        manager.add(epic, subtask);
        subtask.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateEpic(epic);
        assertEquals(TaskStatus.IN_PROGRESS, epic.getStatus());

    }

}