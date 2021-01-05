package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack {

    public Shaman() {
        super(10.0,15.0,0.2,0.2);
    }

    @Override
    public void healHimself() {
        setHealth(getHealth() + 50);
        if (getHealth() >= getMaxHealth()) {
            setHealth(getMaxHealth());
        }
    }

    public void healTeammate(Hero hero) {
        hero.addHealth(30);
    }

    @Override
    public void magicalAttack(Hero hero) {
        hero.reduceHealth(getMagicAtt() - getMagicAtt() * hero.getMagicDef());
    }

    @Override
    public void physicalAttack(Hero hero) {
        hero.reduceHealth(getPhysAtt() - getPhysAtt() * hero.getPhysDef());
    }

    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + getHealth() +
                '}';
    }
}
