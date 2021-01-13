package day18;

public class Task1 {

    public static int recursionSum(int[] numbers, int length){
        //Объявляем переменную sum (начальная сумма)
        int sum = 0;

        //Условия возврата из метода
        if(length == 0){
            return sum;
        }

        //Декрементируем переменную length
        length--;

        //Вычисление суммы
        sum = numbers[length] + recursionSum(numbers, length);

        //Возрврат суммы
        return sum;
    }

    public static void main(String[] args) {
        //Проверка массива //65346
        int[] numbers = {1, 10, 1241, 50402, -50, 249, 10215, 665, 2295, 7, 311};
        System.out.println(recursionSum(numbers, numbers.length));

        //Проверка еще одного массива //1545
        int[] numbers2 = {999, -999, 121, 502, 0, 29, 215, 65, 295, 7, 311};
        System.out.println(recursionSum(numbers2, numbers2.length));
    }
}
