package day11.task2;

public class Paladin extends Hero implements Healer, PhysAttack {

    public Paladin() {
        super(15.0,0.0,0.5,0.2);
    }

    @Override
    public void healHimself() {
        setHealth(getHealth() + 25);
        if (getHealth() >= getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        hero.addHealth(10);
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.reduceHealth(getPhysAtt() - getPhysAtt() * hero.getPhysDef());
    }

    @Override
    public String toString() {
        return "Palladin{" +
                "health=" + getHealth() +
                '}';
    }
}
