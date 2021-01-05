package day11.task1;

public class Courier implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Courier(Warehouse warehouse) {
        this.salary = 0;
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void addSalary(int add) {
        salary += add;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "salary=" + salary +
                ", isPayed=" + isPayed +
                '}';
    }

    @Override
    public void doWork() {
        warehouse.addCountDeliveredOrders();
        addSalary(100);
    }

    @Override
    public void bonus() {
        if (isPayed) {
            System.out.println("Бонус уже был выплачен");
            return;
        }
        if (warehouse.getCountDeliveredOrders() / 10000 == 1) {
            addSalary(50000);
            isPayed = true;
        } else if (!isPayed) {
            System.out.println("Бонус пока не доступен");
        }
    }
}
