package day11.task2;

public class Magician extends Hero implements MagicAttack {
    private double magicAtt;

    public Magician() {
        super(5.0,0.0,0.8);
        this.magicAtt = 20.0;
    }

    @Override
    public void magicalAttack(Hero hero) {
        hero.reduceHealth(getMagicAtt() - getMagicAtt() * hero.getMagicDef());
    }

    @Override
    public String toString() {
        return "Magician{" +
                "health=" + getHealth() +
                '}';
    }

    public double getMagicAtt() {
        return magicAtt;
    }
}
