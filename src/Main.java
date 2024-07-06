import controllers.*;
import model.*;

public class Main {

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Task epic : manager.getEpics()) {
            System.out.println(epic);

            for (Task task : manager.getEpicSubtasks(epic.getId())) {
                System.out.println("--> " + task);
            }
        }
        System.out.println("Подзадачи:");
        for (Task subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
    public static void main(String[] args) {
        Task sport = new Task("Спорт", "отжаться 100 раз");
        Task study = new Task("Учёба", "Завершить 4 спринг");
        Epic removal = new Epic("Переезд", "Переехать в другую квартиру");
        SubTask removal1 = new SubTask("Сбор", "Собрать коробки");
        SubTask removal2 = new SubTask("Выезд", "Перевезти собраные вещи в новую квартиру");
        Epic magazine = new Epic("Магазин", "Купить продукты");
        SubTask product = new SubTask("Молоко", "Купить свежее молоко");
        TaskManager manager = Managers.getDefault();


        System.out.println(manager.add(sport));
        System.out.println(manager.add(study));
        System.out.println(manager.add(removal));
        manager.add(removal, removal1);
        manager.add(removal, removal2);
        manager.add(magazine);
        manager.add(magazine, product);
        manager.updateSubTask(removal,removal1);
        manager.getTask(-1537218437);
        manager.getTask(1223665245);
        manager.getEpic(-362558829);

        sport.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateTask(sport);
        study.setStatus(TaskStatus.DONE);
        manager.updateTask(study);


        removal1.setStatus(TaskStatus.IN_PROGRESS);
        manager.updateEpic(removal);

        product.setStatus(TaskStatus.DONE);
        manager.updateEpic(magazine);
        printAllTasks(manager);
        sport.setStatus(TaskStatus.DONE);


        printAllTasks(manager);



    }
}
