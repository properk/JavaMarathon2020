package seawar;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Seawar {
    public static boolean winner;

    public static void main(String[] args) {
        //Для определения, кто первым ходит
        Player firstMovePlayer;
        Player secondMovePlayer;

        //Создаем игроков
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        //Создаем поля для игроков
        PlayingField fieldForPlayer1 = new PlayingField();
        PlayingField fieldForPlayer2 = new PlayingField();

        //Устанавливаем поля игрокам
        player1.setField(fieldForPlayer1);
        player2.setField(fieldForPlayer2);

        //Вводим координаты кораблей для игроков
        printHelper(player1);
        printHelper(player2);

          //Тестовые координаты для Player 1

//        player1.addShip("0,2");
//        player1.addShip("0,4");
//        player1.addShip("0,6");
//        player1.addShip("0,8");
//
//        player1.addShip("2,1;2,2");
//        player1.addShip("2,4;2,5");
//        player1.addShip("2,7;2,8");
//
//        player1.addShip("4,1;5,1;6,1");
//        player1.addShip("4,3;5,3;6,3");
//
//        player1.addShip("9,4;9,5;9,6;9,7");
//
//        //Тестовые координаты для Player 2
//
//        player2.addShip("1,2");
//        player2.addShip("1,4");
//        player2.addShip("1,6");
//        player2.addShip("1,8");
//
//        player2.addShip("3,1;3,2");
//        player2.addShip("3,4;3,5");
//        player2.addShip("3,7;3,8");
//
//        player2.addShip("6,1;6,2;6,3");
//        player2.addShip("8,2;8,3;8,4");
//
//        player2.addShip("5,8;6,8;7,8;8,8");

        //Определяем, кто первым будет ходить
        if (WhoMakesFirstMove() == 1) {
            firstMovePlayer = player1;
            secondMovePlayer = player2;
            System.out.println("------------------------------------------------------------");
            System.out.printf("Первым ходит %s. Введите координаты для удара (формат: x,y):%n", firstMovePlayer.getName());
        } else {
            firstMovePlayer = player2;
            secondMovePlayer = player1;
            System.out.println("------------------------------------------------------------");
            System.out.printf("Первым ходит %s. Введите координаты для удара (формат: x,y):%n", firstMovePlayer.getName());
        }

        System.out.println("------------------------------------------------------------");

        //Начало игры (поочередные ходы), извиняюсь, что так запутано
        while (!winner) {
            if (firstMovePlayer.isWinner() || secondMovePlayer.isWinner()) {
                break;
            }
            if (newAttack(firstMovePlayer, secondMovePlayer)) {
                if (firstMovePlayer.isWinner()) {
                    break;
                }
                if (secondMovePlayer.isWinner()) {
                    break;
                }
                newAttack(secondMovePlayer, firstMovePlayer);
            } else {
                newAttack(firstMovePlayer, secondMovePlayer);
            }
        }

        //Вывод сообщения о победителе
        if (firstMovePlayer.isWinner()) {
            System.out.println("-------------------------");
            System.out.printf("\uD83C\uDFC6 \uD83C\uDFC6 \uD83C\uDFC6 Победил %s \uD83C\uDFC6 \uD83C\uDFC6 \uD83C\uDFC6%n", firstMovePlayer.getName());
        }

        if (secondMovePlayer.isWinner()) {
            System.out.println("-------------------------");
            System.out.printf("\uD83C\uDFC6 \uD83C\uDFC6 \uD83C\uDFC6Победил %s \uD83C\uDFC6 \uD83C\uDFC6 \uD83C\uDFC6%n", secondMovePlayer.getName());
        }

        //Отображения полей после конца игры
        System.out.println("-------------------------");
        System.out.printf("Поле %s: %n", player1.getName());
        System.out.println("-------------------------");
        fieldForPlayer1.printField();
        System.out.println("-------------------------");
        System.out.printf("Уничтожено кораблей: %d/10%n", player1.getCountOfKilledShips());

        System.out.println("-------------------------");
        System.out.printf("Поле %s: %n", player2.getName());
        System.out.println("-------------------------");
        fieldForPlayer2.printField();
        System.out.println("-------------------------");
        System.out.printf("Уничтожено кораблей: %d/10%n", player2.getCountOfKilledShips());
        System.out.println("-------------------------");
    }

    //Ввод координат
    public static void enterNewCoordinates(Player player) {
        Scanner scanner = new Scanner(System.in);
        String coordinates = scanner.nextLine();

        //Пока корабль успешно не добавлен, просим ввести координаты
        while (!player.addShip(coordinates)) {
            coordinates = scanner.nextLine();
        }
    }

    //Атака (кто, кого)
    public static boolean newAttack(Player player1, Player player2) {

        Scanner scanner = new Scanner(System.in);
        String coordinates = scanner.nextLine();

        while (!player1.attack(player2, coordinates)) {
            if (player1.isWinner()) {
                break;
            }
            coordinates = scanner.nextLine();
        }

        return true;
    }

    //Возвращает случайное число 1 или 2
    public static int WhoMakesFirstMove() {
        double a = Math.random() + 1;
        return (int) Math.round(a);
    }

    //Расстановка кораблей
    public static void printHelper(Player player) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("Начинаем расставлять корабли на поле для %s. Другой игрок, не смотри!%n", player.getName());
        System.out.println("------------------------------------------------------------");
        System.out.println("Формат ввода: ");
        System.out.println("------------------------------------------------------------");
        System.out.println("x1,y1 - для однопалубных кораблей");
        System.out.println("x1,y1,x2,y2 - для двухпалубных кораблей");
        System.out.println("x1,y1,x2,y2,x3,y3 - для трехпалубных кораблей");
        System.out.println("x1,y1,x2,y2,x3,y3,x4,y4 - для четырехпалубного корабля");
        System.out.println("------------------------------------------------------------");

        //Вводим последовательно координаты кораблей

        System.out.println("Введите координаты 1-го однопалубного корабля (x1,y1):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 2-го однопалубного корабля (x1,y1):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 3-го однопалубного корабля (x1,y1):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 4-го однопалубного корабля (x1,y1):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 1-го двухпалубного корабля (x1,y1;x2,y2):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 2-го двухпалубного корабля (x1,y1;x2,y2):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 3-го двухпалубного корабля (x1,y1;x2,y2):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 1-го трехпалубного корабля (x1,y1;x2,y2;x3,y3):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты 2-го трехпалубного корабля (x1,y1;x2,y2;x3,y3):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Введите координаты четырехпалубного корабля (x1,y1;x2,y2;x3,y3;x4,y4):");
        System.out.println("------------------------------------------------------------");
        enterNewCoordinates(player);
        System.out.println("Отлично. Все корабли размещены.");

        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

}
