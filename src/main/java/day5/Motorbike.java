package day5;

public class Motorbike {
    private int yearOfIssue;
    private String color;
    private String modelName;

    public Motorbike(int yearOfIssue, String color, String modelName) {
        this.yearOfIssue = yearOfIssue;
        this.color = color;
        this.modelName = modelName;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
