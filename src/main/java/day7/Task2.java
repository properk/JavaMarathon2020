package day7;

import java.util.Random;

import static day7.Player.info;

public class Task2 {

    public static int generateStamina(int min, int max) {
        Random random = new Random();
        int genStamina = random.nextInt((max - min) + 1);
        genStamina += min;
        return genStamina;
    }

    public static void main(String[] args) {
        //Создание 3 игроков
        Player player1 = new Player(generateStamina(90, Player.MAX_STAMINA));
        Player player2 = new Player(generateStamina(90, Player.MAX_STAMINA));
        Player player3 = new Player(generateStamina(90, Player.MAX_STAMINA));
        info();

        //Создаем еще 3 игроков
        Player player4 = new Player(generateStamina(90, Player.MAX_STAMINA));
        Player player5 = new Player(generateStamina(90, Player.MAX_STAMINA));
        Player player6 = new Player(generateStamina(90, Player.MAX_STAMINA));
        info();

        //Создаем еще 2-х игроков
        Player player7 = new Player(generateStamina(90, Player.MAX_STAMINA));
        Player player8 = new Player(generateStamina(90, Player.MAX_STAMINA));

        //Количество игроков
        System.out.println(Player.getCountPlayers());

        //player1 бегает, пока не выдохнется
        for (int i = 0; i < 100; i++) {
            player1.run();
        }

        //Доп. проверка, что все работает нормально
        player1.run();
        System.out.println(player1.getStamina());

        //Количество игроков, после ухода player1
        System.out.println(Player.getCountPlayers());
        info();
    }
}