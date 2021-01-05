package day11.task2;

public class Shaman extends Hero implements Healer, MagicAttack {
    private double magicAtt;

    public Shaman() {
        super(10.0,0.2,0.2);
        this.magicAtt = 15.0;
    }

    @Override
    public void healHimself() {
        setHealth(getHealth() + 50);
        if (getHealth() >= MAX_HEALTH) {
            setHealth(MAX_HEALTH);
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
    public String toString() {
        return "Shaman{" +
                "health=" + getHealth() +
                '}';
    }

    public double getMagicAtt() {
        return magicAtt;
    }
}
