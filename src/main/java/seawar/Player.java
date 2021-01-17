package seawar;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private PlayingField field;
    private static int playersCount;
    private int countOfFourDeckShips;
    private int countOfThreeDeckShips;
    private int countOfTwoDeckShips;
    private int countOfOneDeckShips;
    private List<Ship> ships;
    private List<String> moves;
    private int countOfKilledShips;
    private boolean isWinner;

    //Создание игрока
    public Player(String name) {
        //Игроков не может быть больше 2-х
        if (playersCount == 2) {
            System.out.println("Создано максимальное количество игроков");
            return;
        }
        this.name = name;
        this.ships = new ArrayList<>();
        this.moves = new ArrayList<>();
        playersCount++;
        countOfKilledShips = 0;
    }

    //Назначить игроку выбранное игровое поле
    public void setField(PlayingField field) {
        this.field = field;
    }

    //Добавление корабля
    public boolean addShip(String coordinates) {
        Ship ship;

        //Если передана пустая строка, вернуть false
        if (coordinates == null || coordinates.isEmpty()) {
            System.out.println(ConsoleErrors.EMPTY_STRING.getMessage());
            return false;
        }

        //Массив координат для будущего корабля
        String[] ship_coordinates;

        int x1;
        int y1;
        int x2;
        int y2;
        int x3;
        int y3;
        int x4;
        int y4;

        //Определение, для создания какого корабля пришли координаты

        //Для однопалубного
        if (coordinates.matches("^[0-9],[0-9]$")) {

            ship_coordinates = coordinates.split(",");

            //Присваиваем переменным значения из массива
            x1 = Integer.parseInt(ship_coordinates[0]);
            y1 = Integer.parseInt(ship_coordinates[1]);

            //Если ячейки поля свободны, то создаем корабль, ставим корабль
            if (field.getField()[x1][y1].isFreeCell()) {

                try {
                    //Создать корабль
                    ship = new Ship(field, this, field.getField()[x1][y1]);
                    //Добавляем корабль в список (чтобы можно было потом обратиться к нему)
                    ships.add(ship);
                    //Создать ореол корабля
                    ship.createHalo();

                } catch (NullPointerException e) {
                    System.out.println("Вы создаете не тот корабль, попробуйте ввести координаты еще раз.");
                    return false;
                }

                return true;

            } else {
                System.out.println(ConsoleErrors.ON_HALO_SHIP.getMessage());
                return false;
            }
        }

        //Для двухпалубного
        if (coordinates.matches("^[0-9],[0-9];[0-9],[0-9]$")) {

            ship_coordinates = coordinates.replace(";", ",").split(",");

            //Присваиваем переменным значения из массива
            x1 = Integer.parseInt(ship_coordinates[0]);
            y1 = Integer.parseInt(ship_coordinates[1]);
            x2 = Integer.parseInt(ship_coordinates[2]);
            y2 = Integer.parseInt(ship_coordinates[3]);

            //Проверка валидности координат (вертикальный или горизонтальный корабль)
            if (((x1 == x2) && (Math.abs(y1 - y2) == 1))
                    || ((y1 == y2) && (Math.abs(x1 - x2) == 1))) {

                //Если ячейки поля свободны, то создаем корабль, ставим корабль
                if (field.getField()[x1][y1].isFreeCell()
                        && field.getField()[x2][y2].isFreeCell()) {

                    try {
                        //Создать корабль
                        ship = new Ship(field,
                                this,
                                field.getField()[x1][y1],
                                field.getField()[x2][y2]);
                        //Добавляем корабль в список (чтобы можно было потом обратиться к нему)
                        ships.add(ship);
                        //Создать ореол корабля
                        ship.createHalo();

                    } catch (NullPointerException e) {
                        System.out.println("Вы создаете не тот корабль, попробуйте ввести координаты еще раз.");
                        return false;
                    }

                    return true;

                } else {
                    System.out.println(ConsoleErrors.ON_HALO_SHIP.getMessage());
                    return false;
                }
            } else System.out.println(ConsoleErrors.WRONG_SHIP.getMessage());

        }

        //Для трехпалубного
        if (coordinates.matches("^[0-9],[0-9];[0-9],[0-9];[0-9],[0-9]$")) {

            ship_coordinates = coordinates.replace(";", ",").split(",");

            //Присваиваем переменным значения из массива
            x1 = Integer.parseInt(ship_coordinates[0]);
            y1 = Integer.parseInt(ship_coordinates[1]);
            x2 = Integer.parseInt(ship_coordinates[2]);
            y2 = Integer.parseInt(ship_coordinates[3]);
            x3 = Integer.parseInt(ship_coordinates[4]);
            y3 = Integer.parseInt(ship_coordinates[5]);

            //Проверка валидности координат (вертикальный или горизонтальный корабль)
            if (((x1 == x2 && x2 == x3) && (Math.abs(y1 - y2) == 1 && Math.abs(y2 - y3) == 1))
                    || ((y1 == y2 && y2 == y3) && (Math.abs(x1 - x2) == 1 && Math.abs(x2 - x3) == 1))) {

                //Если ячейки поля свободны, то создаем корабль, ставим корабль
                if (field.getField()[x1][y1].isFreeCell()
                        && field.getField()[x2][y2].isFreeCell()
                        && field.getField()[x3][y3].isFreeCell()) {

                    try {
                        //Создать корабль
                        ship = new Ship(field,
                                this,
                                field.getField()[x1][y1],
                                field.getField()[x2][y2],
                                field.getField()[x3][y3]);
                        //Добавляем корабль в список (чтобы можно было потом обратиться к нему)
                        ships.add(ship);
                        //Создать ореол корабля
                        ship.createHalo();

                    } catch (NullPointerException e) {
                        System.out.println("Вы создаете не тот корабль, попробуйте ввести координаты еще раз.");
                        return false;
                    }

                    return true;

                } else {
                    System.out.println(ConsoleErrors.ON_HALO_SHIP.getMessage());
                    return false;
                }
            } else System.out.println(ConsoleErrors.WRONG_SHIP.getMessage());

        }

        //Для четырехпалубного
        if (coordinates.matches("^[0-9],[0-9];[0-9],[0-9];[0-9],[0-9];[0-9],[0-9]$")) {

            ship_coordinates = coordinates.replace(";", ",").split(",");

            //Присваиваем переменным значения из массива
            x1 = Integer.parseInt(ship_coordinates[0]);
            y1 = Integer.parseInt(ship_coordinates[1]);
            x2 = Integer.parseInt(ship_coordinates[2]);
            y2 = Integer.parseInt(ship_coordinates[3]);
            x3 = Integer.parseInt(ship_coordinates[4]);
            y3 = Integer.parseInt(ship_coordinates[5]);
            x4 = Integer.parseInt(ship_coordinates[6]);
            y4 = Integer.parseInt(ship_coordinates[7]);

            //Проверка валидности координат (вертикальный или горизонтальный корабль)
            if (((x1 == x2 && x2 == x3 && x3 == x4)
                    && (Math.abs(y1 - y2) == 1 && Math.abs(y2 - y3) == 1 && Math.abs(y3 - y4) == 1))
                    || ((y1 == y2 && y2 == y3 && y3 == y4)
                    && (Math.abs(x1 - x2) == 1 && Math.abs(x2 - x3) == 1) && Math.abs(x3 - x4) == 1)) {

                //Если ячейки поля свободны
                if (field.getField()[x1][y1].isFreeCell()
                        && field.getField()[x2][y2].isFreeCell()
                        && field.getField()[x3][y3].isFreeCell()
                        && field.getField()[x4][y4].isFreeCell()) {

                    try {
                        //Создать корабль
                        ship = new Ship(field,
                                this,
                                field.getField()[x1][y1],
                                field.getField()[x2][y2],
                                field.getField()[x3][y3],
                                field.getField()[x4][y4]);
                        //Добавляем корабль в список (чтобы можно было потом обратиться к нему)
                        ships.add(ship);
                        //Создать ореол корабля
                        ship.createHalo();

                    } catch (NullPointerException e) {
                        System.out.println("Вы создаете не тот корабль, попробуйте ввести координаты еще раз.");
                        return false;
                    }

                    return true;

                } else {
                    System.out.println(ConsoleErrors.ON_HALO_SHIP.getMessage());
                    return false;
                }
            } else {
                System.out.println(ConsoleErrors.WRONG_SHIP.getMessage());
                return false;
            }
        }

        System.out.println(ConsoleErrors.NON_DIGITS.getMessage());
        return false;
    }

    //Атака поля сопернина по координатам
    public boolean attack(Player player, String inputLine) {

        String line = inputLine;
        String[] coordinates;
        Cell targetCell;
        Ship targetShip;

            if (line.matches("^[0-9],[0-9]$")) {

                if (!moves.contains(line)) {
                    //Записываем ход
                    moves.add(line);

                    //Берем координаты
                    coordinates = line.split(",");

                    //Целевая ячейка, по которой наносим удар
                    targetCell = player.field.getField()[Integer.parseInt(coordinates[0])][Integer.parseInt(coordinates[1])];

                    //Если эта ячейка, на которой есть корабль, то
                    if (targetCell.isShipCell()) {

                        //Помечаем цветом, что ячейка подбита
                        targetCell.setColor("\uD83D\uDFE5");

                        //Поиск корабля противника, у которого есть эта координата
                        targetShip = getAttackedShip(player, targetCell);

                        //Если он однопалубный
                        if (targetShip.isOneDeckShip()) {

                            targetShip.setCountOfHit(0);
                            targetShip.setHit(true);
                            targetShip.setKilled(true);
                            countOfKilledShips++;
                            System.out.println("Утопил однопалубный корабль!");

                            //Проверка на победу
                            if (countOfKilledShips == 10) {
                                this.isWinner = true;
                                return false;
                            }

                            System.out.printf("Отлично %s. Можете ввести координаты для удара по полю %s еще раз (формат: x,y):%n", this.getName(), player.getName());
                            return false;

                            //Если двухпалубный
                        } else if (targetShip.isTwoDeckShip()) {

                            targetShip.setCountOfHit(targetShip.getCountOfHit() - 1);
                            targetShip.setHit(true);

                            //Если у корабля нет запаса ударов
                            if (targetShip.getCountOfHit() == 0) {
                                targetShip.setKilled(true);
                                countOfKilledShips++;
                                System.out.println("Утопил двухпалубный корабль!");

                                //Проверка на победу
                                if (countOfKilledShips == 10) {
                                    this.isWinner = true;
                                    return false;
                                }

                            } else {
                                System.out.println("Попадание!");
                            }
                            System.out.printf("Отлично %s. Можете ввести координаты для удара по полю %s еще раз (формат: x,y):%n", this.getName(), player.getName());
                            return false;

                            //Если трехпалубный
                        } else if (targetShip.isThreeDeckShip()) {

                            targetShip.setCountOfHit(targetShip.getCountOfHit() - 1);
                            targetShip.setHit(true);

                            //Если у корабля нет запаса ударов
                            if (targetShip.getCountOfHit() == 0) {
                                targetShip.setKilled(true);
                                countOfKilledShips++;
                                System.out.println("Утопил трехпалубный корабль!");

                                //Проверка на победу
                                if (countOfKilledShips == 10) {
                                    this.isWinner = true;
                                    return false;
                                }

                            } else {
                                System.out.println("Попадание!");
                            }
                            System.out.printf("Отлично %s. Можете ввести координаты для удара по полю %s еще раз (формат: x,y):%n", this.getName(), player.getName());
                            return false;

                            //Если четырехпалубный
                        } else if (targetShip.isFourDeckShip()) {

                            targetShip.setCountOfHit(targetShip.getCountOfHit() - 1);
                            targetShip.setHit(true);

                            //Если у корабля нет запаса ударов
                            if (targetShip.getCountOfHit() == 0) {
                                targetShip.setKilled(true);
                                countOfKilledShips++;
                                System.out.println("Утопил четырехпалубный корабль!");

                                //Проверка на победу
                                if (countOfKilledShips == 10) {
                                    this.isWinner = true;
                                    return false;
                                }

                            } else System.out.println("Попадание!");

                            System.out.printf("Отлично %s. Можете ввести координаты для удара по полю %s еще раз (формат: x,y):%n", this.getName(), player.getName());
                            return false;

                        }

                    } else {
                        System.out.printf("Мимо! Следующий ход делает %s, введите координаты (x,y)%n", player.getName());
                        return true;
                    }

                } else {
                    System.out.println("Вы уже били по этим координатам, введите другие.");
                    return false;
                }
            } else {
                System.out.println("Неверный формат координат, попробуйте еще раз.");
                return false;
            }

        return true;
    }

    //Получить корабль, который стоит на ячейке
    private Ship getAttackedShip(Player player, Cell targetCell) {
        return player.ships.stream()
                .filter(ship ->
                        {
                            boolean find = false;
                            for (Cell cell : ship.getCell_coordinates()) {
                                if (cell.getX() == targetCell.getX() && cell.getY() == targetCell.getY()) {
                                    find = true;
                                    break;
                                }
                            }
                            return find;
                        }
                )
                .findAny()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public int getCountOfFourDeckShips() {
        return countOfFourDeckShips;
    }

    public void setCountOfFourDeckShips(int countOfFourDeckShips) {
        this.countOfFourDeckShips = countOfFourDeckShips;
    }

    public int getCountOfThreeDeckShips() {
        return countOfThreeDeckShips;
    }

    public void setCountOfThreeDeckShips(int countOfThreeDeckShips) {
        this.countOfThreeDeckShips = countOfThreeDeckShips;
    }

    public int getCountOfTwoDeckShips() {
        return countOfTwoDeckShips;
    }

    public void setCountOfTwoDeckShips(int countOfTwoDeckShips) {
        this.countOfTwoDeckShips = countOfTwoDeckShips;
    }

    public int getCountOfOneDeckShips() {
        return countOfOneDeckShips;
    }

    public void setCountOfOneDeckShips(int countOfOneDeckShips) {
        this.countOfOneDeckShips = countOfOneDeckShips;
    }

    public int getCountOfKilledShips() {
        return countOfKilledShips;
    }

    public void setCountOfKilledShips(int countOfKilledShips) {
        this.countOfKilledShips = countOfKilledShips;
    }

    public boolean isWinner() {
        return isWinner;
    }
}
