package day4;

public class Task3 {
    public static int[][] createAndFillArray(int m, int n) {
        //Создание двумерного массива и заполнение случайными целыми значениями от 1 до 50;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) Math.round(Math.random() * 50);
            }
        }
        return array;
    }

    public static int getIndexArrayWithMaxSum(int[][] array){
        int currentTotal = 0;
        int index = 0;
        int sumString;

        //Цикл по строкам;
        for(int i = 0; i < array.length; i++){
            sumString = 0;
            //Цикл по столбцам;
            for(int j = 0; j < array[i].length; j++){
                //Считаем сумму элементов в строке;
                sumString += array[i][j];
            }
            if(sumString > currentTotal){
                currentTotal = sumString;
                //Индекс строки с макстмальной суммой;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.print(getIndexArrayWithMaxSum(createAndFillArray(12, 8)));
    }
}
