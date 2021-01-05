package day11.task2;

public class Magician extends Hero implements MagicAttack, PhysAttack {

    public Magician() {
        super(5.0,20.0,0.0,0.8);
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
        return "Magician{" +
                "health=" + getHealth() +
                '}';
    }
}
