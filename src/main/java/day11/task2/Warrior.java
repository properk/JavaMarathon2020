package day11.task2;

public class Warrior extends Hero implements PhysAttack {

    public Warrior() {
        super(30.0, 0.0, 0.8, 0.0);
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.reduceHealth(getPhysAtt() - getPhysAtt() * hero.getPhysDef());
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + getHealth() +
                '}';
    }
}
