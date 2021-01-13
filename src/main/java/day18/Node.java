package day18;

public class Node {
    private int value;
    private Node rightSon;
    private Node leftSon;

    public Node(int value) {
        this.value = value;
    }

    public void setRightSon(Node rightSon) {
        this.rightSon = rightSon;
    }

    public void setLeftSon(Node leftSon) {
        this.leftSon = leftSon;
    }

    public int getValue() {
        return value;
    }

    public Node getRightSon() {
        return rightSon;
    }

    public Node getLeftSon() {
        return leftSon;
    }
}
