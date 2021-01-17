package seawar;

public class PlayingField {
    private Cell[][] field;

    //Создаем поле 10x10
    public PlayingField() {
        this.field = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }

    //Печатаем поле в консоль
    public void printField() {
        for (Cell[] subfield : field) {
            for (Cell cell : subfield) {
                System.out.print(cell.getColor());
            }
            System.out.println();
        }
        System.out.println();
    }

    public Cell[][] getField() {
        return field;
    }
}
