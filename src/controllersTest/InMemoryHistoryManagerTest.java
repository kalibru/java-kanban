package controllersTest;
import controllers.HistoryManager;
import controllers.Managers;
import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class InMemoryHistoryManagerTest {
    private static HistoryManager manager;

    @BeforeEach
    public void beforeEach() {
        manager = Managers.getDefaultHistory();
    }

    @Test
    void addHistoryTaskPreviousVersionTest() {
        Task task = new Task("Test name task", "Test description task");
        manager.addHistory(task);

        assertEquals(manager.getHistory().getFirst(), task);
    }


    @Test
    void addHistoryFullSizeTest() {
        Epic epic = new Epic("Test name epic", "Test description epic");
        SubTask subTask = new SubTask("Test name subtask", "Test description subtask");
        Task task2 = new Task("Test name task2", "Test description task2");
        Task task3 = new Task("Test name task3", "Test description task3");
        Task task4 = new Task("Test name task4", "Test description task4");
        Task task5 = new Task("Test name task5", "Test description task5");
        Task task6 = new Task("Test name task6", "Test description task6");
        Task task7 = new Task("Test name task7", "Test description task7");
        Task task8 = new Task("Test name task8", "Test description task8");
        Task task9 = new Task("Test name task9", "Test description task9");
        manager.addHistory(epic);
        manager.addHistory(subTask);
        manager.addHistory(task2);
        manager.addHistory(task3);
        manager.addHistory(task4);
        manager.addHistory(task5);
        manager.addHistory(task6);
        manager.addHistory(task7);
        manager.addHistory(task8);
        manager.addHistory(task9);

        manager.addHistory(epic);

        assertEquals(10, manager.getHistory().size());

        manager.addHistory(subTask);

        assertEquals(10, manager.getHistory().size());

        manager.addHistory(task2);

        assertEquals(10, manager.getHistory().size());


    }

}