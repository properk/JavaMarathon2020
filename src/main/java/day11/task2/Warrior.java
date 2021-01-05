package day11.task2;

public class Warrior extends Hero {

    public Warrior() {
        super(30.0, 0.8, 0.0);
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + getHealth() +
                '}';
    }
}
