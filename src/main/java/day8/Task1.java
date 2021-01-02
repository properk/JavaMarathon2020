package day8;

public class Task1 {
    public static void workOfStringBuilder(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 20000; i++) {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString());
    }

    public static void workOfString(int number) {
        String string = "";
        for (int i = 0; i <= 20000; i++) {
            string += i + " ";
        }
        System.out.print(string);
    }


    public static void main(String[] args) {
        long start;
        long finish;
        long timeConsumedMillis;
        long timeSB;
        long timeString;

        //StringBuilder
        start = System.currentTimeMillis();
        workOfStringBuilder(20000);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        timeSB = timeConsumedMillis;

        //String
        start = System.currentTimeMillis();
        workOfString(20000);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        timeString = timeConsumedMillis;

        System.out.println();
        System.out.println("Время создания строки с помощью StringBuilder: " + timeSB);
        System.out.println("Время создания строки с помощью String: " + timeString);

    }
}
