import controllers.ManagerTasks;
import model.*;

public class Main {

    public static void main(String[] args) {
        Task sport = new Task("Спорт", "отжаться 100 раз");
        Task study = new Task("Учёба", "Завершить 4 спринг");
        Epic removal = new Epic("Переезд", "Переехать в другую квартиру");
        SubTask removal1 = new SubTask("Сбор", "Собрать коробки");
        SubTask removal2 = new SubTask("Выезд", "Перевезти собраные вещи в новую квартиру");
        Epic magazine = new Epic("Магазин", "Купить продукты");
        SubTask product = new SubTask("Молоко", "Купить свежее молоко");

        ManagerTasks manager = new ManagerTasks();

        manager.addTask(sport);
        manager.addTask(study);
        manager.addEpicTask(removal);
        manager.addEpicSubTask(removal, removal1);
        manager.addEpicSubTask(removal, removal2);
        manager.addEpicTask(magazine);
        manager.addEpicSubTask(magazine, product);
        manager.updateSubTask(removal,removal1);

        System.out.println(manager.getEpic());

        sport.status=TaskStatus.IN_PROGRESS;
        manager.updateTask(sport);

        study.status = TaskStatus.DONE;
        manager.updateTask(study);

        removal1.status =(TaskStatus.IN_PROGRESS);
        manager.updateEpicTask(removal);

        product.status=TaskStatus.DONE;
        manager.updateEpicTask(magazine);

        manager.delSubTask(-362558829,-112647749);

        System.out.println(manager.getTasks());

        manager.delEpicTask(-1364837361);
        manager.delTask(1223665245);

       System.out.println(manager.getSubTasks());
        System.out.println(manager.getEpic());
        System.out.println(manager.getTasks());


    }
}
