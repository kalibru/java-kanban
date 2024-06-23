import java.util.HashMap;

public class ManagerTasks {
    public  HashMap<Integer, Task> tasks = new HashMap<>();
    public  HashMap<Integer, Epic> epicTasks = new HashMap<>();

    public String printAllTasks() {

        String result;
        if (!tasks.isEmpty()) {
            result = tasks.values().toString();
        } else result = "Обычных задач пока нет";
        if (!epicTasks.isEmpty()) {
            result = result + "\n" + epicTasks.values();
        } else result = result + "\n" + "Больших задач пока нет";
        return result;
    }

    public String printIdTask(int id) {
        String result;
        if (tasks.containsKey(id)) {
            result = tasks.get(id).toString();
        } else if (epicTasks.containsKey(id)) {
            result = epicTasks.get(id).toString();
        } else {
            result = "Введен неверный идентификатор";
        }
        return result;
    }

    public String printEpicSubTasks(int id) {
        String result = "";
        if (epicTasks.containsKey(id)) {
            for (SubTask subTask : epicTasks.get(id).getSubTasks()) {
                result = result + subTask.toString() + "\n";
            }
        } else {
            result = "Введен невеный идентификатор";
        }
        return result;
    }

    public void delAllTusks() {
        tasks.clear();
        epicTasks.clear();
        System.out.println("Все задачи удалены.");
    }

    public void delTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            System.out.println("Задача удалена");
        } else System.out.println("Введен неверный идетификатор");
    }

    public void delEpicTask(int id) {
        if (epicTasks.containsKey(id)) {
            epicTasks.remove(id);
            System.out.println("Большая задача удалена");
        } else System.out.println("Введен неверный идентификатор");
    }

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void addEpicTask(Epic epicTask) {
        epicTasks.put(epicTask.getId(), epicTask);
    }

    public void addEpicSubTask(Epic epicTask, SubTask task) {
        if (epicTasks.containsKey(epicTask.getId())) {
            epicTasks.get(epicTask.getId()).addSubTask(task);
        } else System.out.println("Введите существующую большую задачу");
    }


    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        } else {
            System.out.println("Этой задачи не существует");
        }
    }

    public void updateSubTask(Epic epicTask, SubTask subTask) {
        if (epicTasks.containsKey(epicTask.getId())) {
            if (epicTasks.get(epicTask.getId()).getSubTasks().contains(subTask)) {
                int index = epicTasks.get(epicTask.getId()).getSubTasks().indexOf(subTask);
                epicTasks.get(epicTask.getId()).getSubTasks().set(index, subTask);
            } else {
                System.out.println("Этой подзадачи не существует");
            }
        } else {
            System.out.println("Этой большой задачи не существует");
        }
    }

    public void updateEpicTask(Epic epicTask) {
        if (epicTasks.containsKey(epicTask.getId())) {
            int doneTasks = 0;
            epicTask.setStatus(TaskStatus.NEW);
            for (SubTask subTasks : epicTask.getSubTasks()) {

                if (subTasks.getStatus().equals(TaskStatus.DONE)) {
                    doneTasks++;
                }
                if (doneTasks == epicTask.getSubTasks().size()) {
                    epicTask.setStatus(TaskStatus.DONE);
                } else if (doneTasks > 0) {
                    epicTask.setStatus(TaskStatus.IN_PROGRESS);
                }
                if (subTasks.getStatus().equals(TaskStatus.IN_PROGRESS)) {
                    epicTask.setStatus(TaskStatus.IN_PROGRESS);
                }

            }
            epicTasks.put(epicTask.getId(), epicTask);
        } else {
            System.out.println("Этой большой задачи не существует");
        }
    }

}
