package day11.task2;

public abstract class Hero {
    private static final double MAX_HEALTH = 100;
    private static final double MIN_HEALTH = 0;
    private double health;
    private double physDef;
    private double magicDef;
    private double physAtt;

    public Hero(double physAtt, double physDef, double magicDef) {
        this.health = MAX_HEALTH;
        this.physAtt = physAtt;
        this.physDef = physDef;
        this.magicDef = magicDef;
    }

    public double getHealth() {
        return health;
    }

    public double getPhysDef() {
        return physDef;
    }

    public double getMagicDef() {
        return magicDef;
    }

    public double getPhysAtt() {
        return physAtt;
    }

    public static double getMaxHealth() {
        return MAX_HEALTH;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void addHealth(double health) {
        this.health += health;
        if (this.health >= MAX_HEALTH) {
            setHealth(MAX_HEALTH);
        }
    }

    public void reduceHealth(double health) {
        this.health -= health;
        if (this.health <= MIN_HEALTH) {
            setHealth(MIN_HEALTH);
        }
    }

    public void physicalAttack(Hero hero) {
        hero.reduceHealth(getPhysAtt() - getPhysAtt() * hero.getPhysDef());
    }
}
