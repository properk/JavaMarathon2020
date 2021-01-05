package day11.task1;

public class Picker implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
        this.salary = 0;
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void addSalary(int add){
        salary += add;
    }

    @Override
    public String toString() {
        return "Picker{" +
                "salary=" + salary +
                ", isPayed=" + isPayed +
                '}';
    }

    @Override
    public void doWork() {
        warehouse.addCountPickedOrders();
        addSalary(80);
    }

    @Override
    public void bonus() {
        if (isPayed){
            System.out.println("Бонус уже был выплачен");
            return;
        }
        if(warehouse.getCountPickedOrders() / 10000 == 1){
            addSalary(70000);
            isPayed = true;
        } else if (!isPayed){
            System.out.println("Бонус пока не доступен");
        }
    }
}
