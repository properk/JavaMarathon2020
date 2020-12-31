package day7;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

public class Player {
    private int stamina;
    public static final int MAX_STAMINA = 100;
    public static final int MIN_STAMINA = 0;
    private static int countPlayers;
    private static final int MAX_PLAYERS = 6;
    private boolean playerIsGone = false;


    public Player(int stamina) {
        this.stamina = stamina;
        if (countPlayers < 6) {
            countPlayers++;
        }
    }

    public int getStamina() {
        return stamina;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public void run() {
        //Проверка, если выносливость равна 0, то выходим из метода
        if(stamina == MIN_STAMINA){
            return;
        }

        stamina--;

        //После уменьшения выносливости на -1, проверяем равна ли она 0. Если да, то уменьшаем количество игроков на поле
        if(stamina == MIN_STAMINA){
            countPlayers--;
        }
    }

    public static void info() {
        if (countPlayers < 6) {
            System.out.println("Команды неполные. На поле еще есть " + (MAX_PLAYERS - countPlayers) + " свободных места");
        } else System.out.println("На поле нет свободных мест");
    }
}