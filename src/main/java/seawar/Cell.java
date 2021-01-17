package seawar;

public class Cell {
    private int x;
    private int y;
    private boolean isFreeCell;
    private boolean isHaloCell;
    private boolean isShipCell;
    private String color;

    //Ячейка поля
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isFreeCell = true;
        this.setColor("\uD83D\uDFE8");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFreeCell() {
        return isFreeCell;
    }

    public void setFreeCell(boolean freeCell) {
        isFreeCell = freeCell;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHaloCell() {
        return isHaloCell;
    }

    public void setHaloCell(boolean haloCell) {
        isHaloCell = haloCell;
    }

    public boolean isShipCell() {
        return isShipCell;
    }

    public void setShipCell(boolean shipCell) {
        isShipCell = shipCell;
    }
}
