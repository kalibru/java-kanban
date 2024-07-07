package controllersTest;

import controllers.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    void getDefaultReturnInMemoryTaskManagerTest() {
        TaskManager manager = Managers.getDefault();
        InMemoryTaskManager managerTwo = new InMemoryTaskManager();
        assertEquals(managerTwo.getClass(), manager.getClass());
    }

    @Test
    void getDefaultReturnInMemoryHistoryManagerTest() {
        HistoryManager historyManager = new InMemoryHistoryManager();
        HistoryManager historyManagerTwo = Managers.getDefaultHistory();
        assertEquals(historyManagerTwo.getClass(), historyManager.getClass());
    }

}