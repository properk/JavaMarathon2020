package day11.task2;

public class Paladin extends Hero implements Healer {

    public Paladin() {
        super(15.0,0.5,0.2);
    }

    @Override
    public void healHimself() {
        setHealth(getHealth() + 25);
        if (getHealth() >= MAX_HEALTH) {
            setHealth(MAX_HEALTH);
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        hero.addHealth(10);
    }

    @Override
    public String toString() {
        return "Paladin{" +
                "health=" + getHealth() +
                '}';
    }
}
