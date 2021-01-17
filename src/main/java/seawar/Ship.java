package seawar;

public class Ship {
    private PlayingField field;
    private Cell[] cell_coordinates;
    private boolean isKilled;
    private boolean isHit;
    private boolean isOneDeckShip;
    private boolean isTwoDeckShip;
    private boolean isThreeDeckShip;
    private boolean isFourDeckShip;
    private int countOfHit;

    //Однопалубный корабль
    public Ship(PlayingField field, Player player, Cell cell) {

        //Проверка на количество созданных кораблей
        if (player.getCountOfOneDeckShips() == 4) {
            System.out.println("Больше нельзя создать однопалубных кораблей.");
            return;
        }

        player.setCountOfOneDeckShips(player.getCountOfOneDeckShips() + 1);

        this.field = field;

        cell_coordinates = new Cell[1];
        cell_coordinates[0] = cell;

        field.getField()[cell.getX()][cell.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell.getX()][cell.getY()].setFreeCell(false);
        field.getField()[cell.getX()][cell.getY()].setShipCell(true);

        isOneDeckShip = true;
        countOfHit = 1;

        System.out.println("------------------------------------------");
        System.out.printf("Создано %d/4 однопалубных кораблей %n", player.getCountOfOneDeckShips());
        System.out.println("------------------------------------------");
    }

    //Двупалубный корабль
    public Ship(PlayingField field, Player player, Cell cell1, Cell cell2) {

        //Проверка на количество созданных кораблей
        if (player.getCountOfTwoDeckShips() == 3) {
            System.out.println("Больше нельзя создать двухпалубых кораблей.");
            return;
        }

        player.setCountOfTwoDeckShips(player.getCountOfTwoDeckShips() + 1);

        this.field = field;

        cell_coordinates = new Cell[2];
        cell_coordinates[0] = cell1;
        cell_coordinates[1] = cell2;

        field.getField()[cell1.getX()][cell1.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell1.getX()][cell1.getY()].setFreeCell(false);
        field.getField()[cell1.getX()][cell1.getY()].setShipCell(true);

        field.getField()[cell2.getX()][cell2.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell2.getX()][cell2.getY()].setFreeCell(false);
        field.getField()[cell2.getX()][cell2.getY()].setShipCell(true);

        isTwoDeckShip = true;
        countOfHit = 2;

        System.out.println("------------------------------------------");
        System.out.printf("Создано %d/3 двухпалубных кораблей %n", player.getCountOfTwoDeckShips());
        System.out.println("------------------------------------------");
    }

    //Трехпалубный корабль
    public Ship(PlayingField field, Player player, Cell cell1, Cell cell2, Cell cell3) {

        //Проверка на количество созданных кораблей
        if (player.getCountOfThreeDeckShips() == 2) {
            System.out.println("Больше нельзя создать трехпалубных кораблей.");
            return;
        }

        player.setCountOfThreeDeckShips(player.getCountOfThreeDeckShips() + 1);

        this.field = field;

        cell_coordinates = new Cell[3];
        cell_coordinates[0] = cell1;
        cell_coordinates[1] = cell2;
        cell_coordinates[2] = cell3;

        field.getField()[cell1.getX()][cell1.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell1.getX()][cell1.getY()].setFreeCell(false);
        field.getField()[cell1.getX()][cell1.getY()].setShipCell(true);

        field.getField()[cell2.getX()][cell2.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell2.getX()][cell2.getY()].setFreeCell(false);
        field.getField()[cell2.getX()][cell2.getY()].setShipCell(true);

        field.getField()[cell3.getX()][cell3.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell3.getX()][cell3.getY()].setFreeCell(false);
        field.getField()[cell3.getX()][cell3.getY()].setShipCell(true);

        isThreeDeckShip = true;
        countOfHit = 3;

        System.out.println("------------------------------------------");
        System.out.printf("Создано %d/2 трехпалубных кораблей %n", player.getCountOfThreeDeckShips());
        System.out.println("------------------------------------------");
    }

    //Четырехпалубный корабль
    public Ship(PlayingField field, Player player, Cell cell1, Cell cell2, Cell cell3, Cell cell4) {

        //Проверка на количество созданных кораблей
        if (player.getCountOfFourDeckShips() == 1) {
            System.out.println("Больше нельзя создать четырехпалубных кораблей.");
            return;
        }

        player.setCountOfFourDeckShips(player.getCountOfFourDeckShips() + 1);

        this.field = field;

        cell_coordinates = new Cell[4];
        cell_coordinates[0] = cell1;
        cell_coordinates[1] = cell2;
        cell_coordinates[2] = cell3;
        cell_coordinates[3] = cell4;

        field.getField()[cell1.getX()][cell1.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell1.getX()][cell1.getY()].setFreeCell(false);
        field.getField()[cell1.getX()][cell1.getY()].setShipCell(true);

        field.getField()[cell2.getX()][cell2.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell2.getX()][cell2.getY()].setFreeCell(false);
        field.getField()[cell2.getX()][cell2.getY()].setShipCell(true);

        field.getField()[cell3.getX()][cell3.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell3.getX()][cell3.getY()].setFreeCell(false);
        field.getField()[cell3.getX()][cell3.getY()].setShipCell(true);

        field.getField()[cell4.getX()][cell4.getY()].setColor("\uD83D\uDEA2");
        field.getField()[cell4.getX()][cell4.getY()].setFreeCell(false);
        field.getField()[cell4.getX()][cell4.getY()].setShipCell(true);

        isFourDeckShip = true;
        countOfHit = 4;

        System.out.println("------------------------------------------");
        System.out.printf("Создано %d/1 четырехпалубных кораблей %n", player.getCountOfFourDeckShips());
        System.out.println("------------------------------------------");
    }

    //Создание ореола для корабля
    public void createHalo() {
        for (Cell cell : cell_coordinates) {
            for (int i = (cell.getX() == 0 ? 1 : cell.getX()) - 1; i < (cell.getX() == 9 ? 8 : cell.getX()) + 2; i++) {
                for (int j = (cell.getY() == 0 ? 1 : cell.getY()) - 1; j < (cell.getY() == 9 ? 8 : cell.getY()) + 2; j++) {

                    if (field.getField()[i][j].isShipCell()) {
                        continue;
                    }
                    field.getField()[i][j].setFreeCell(false);
                    field.getField()[i][j].setHaloCell(true);
                    field.getField()[i][j].setColor("\uD83D\uDFE9");
                }
            }
        }

    }

    public boolean isOneDeckShip() {
        return isOneDeckShip;
    }

    public boolean isTwoDeckShip() {
        return isTwoDeckShip;
    }

    public boolean isThreeDeckShip() {
        return isThreeDeckShip;
    }

    public boolean isFourDeckShip() {
        return isFourDeckShip;
    }

    public int getCountOfHit() {
        return countOfHit;
    }

    public void setCountOfHit(int countOfHit) {
        this.countOfHit = countOfHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public Cell[] getCell_coordinates() {
        return cell_coordinates;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}
