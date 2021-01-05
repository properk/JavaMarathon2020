package day11.task1;

public class Task1 {

    static void businessProcess(Worker worker){
        for(int i = 0; i < 10000; i++){
            worker.doWork();
        }
        worker.bonus();
    }

    public static void main(String[] args) {
        //Создаем склад
        Warehouse warehouse = new Warehouse();

        //Создаем упаковщика и курьера, назначаем им единый склад
        Picker picker = new Picker(warehouse);
        Courier courier = new Courier(warehouse);

        //Делаем работу 10000 раз
        businessProcess(picker);
        businessProcess(courier);

        //Данные о собранных заказах
        System.out.println("Количество собранных заказов: " + warehouse.getCountPickedOrders());

        //Данные о доставленных заказов
        System.out.println("Количество доставленных заказов: " + warehouse.getCountDeliveredOrders());

        //Данные об упаковщике
        System.out.println("Сколько заработал упаковщик: " + picker.getSalary());
        System.out.println("Выплачен ли бонус упаковщику: " + picker.isPayed());

        //Данные о курьере
        System.out.println("Сколько заработал курьер: " + courier.getSalary());
        System.out.println("Выплачен ли бонус упаковщику: " + courier.isPayed());


        //Проверка на бонусы (бонус выплачивается 1 раз)
        picker.bonus();
        picker.bonus();
        courier.bonus();
        courier.bonus();
        courier.bonus();

        System.out.println(picker.getSalary());
        System.out.println(courier.getSalary());

        //Создаем второй склад
        Warehouse warehouse2 = new Warehouse();
        Picker picker2 = new Picker(warehouse2);
        Courier courier2 = new Courier(warehouse2);

        //Делаем работу 1 раз
        picker2.doWork();
        courier2.doWork();

        //Проверяем, что у работников 1-го склада ничего не поменялось:
        //Данные о собранных заказах
        System.out.println("Количество собранных заказов: " + warehouse.getCountPickedOrders());

        //Данные о доставленных заказов
        System.out.println("Количество доставленных заказов: " + warehouse.getCountDeliveredOrders());

        //Данные об упаковщике
        System.out.println("Сколько заработал упаковщик: " + picker.getSalary());
        System.out.println("Выплачен ли бонус упаковщику: " + picker.isPayed());

        //Данные о курьере
        System.out.println("Сколько заработал курьер: " + courier.getSalary());
        System.out.println("Выплачен ли бонус упаковщику: " + courier.isPayed());

    }
}
