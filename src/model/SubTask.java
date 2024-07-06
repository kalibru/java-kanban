package model;

public class SubTask extends Task {
    private Epic epic;
    public SubTask(String name, String description) {
        super(name, description);
    }
    public SubTask(SubTask afterSubtask){
        super(afterSubtask.name,afterSubtask.description);
        this.id = afterSubtask.id;
        setStatus(afterSubtask.getStatus());
    }
    public void setEpic(Epic epic){
        this.epic = epic;
    }
    public Epic getEpic(){
        return epic;
    }
    @Override
    public String toString() {
        return "model.SubTask{name: " + getName() +
                ", description: " + getDescription() +
                ", status: " + getStatus() + "}";

    }
}
