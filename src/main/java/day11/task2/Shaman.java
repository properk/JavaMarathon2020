package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack {
    private final double MAX_HEALTH = 100;
    private final double MIN_HEALTH = 0;
    private double health;
    private double physDef;
    private double magicDef;
    private double physAtt;
    private double magicAtt;

    public Shaman() {
        setHealth(MAX_HEALTH);
        this.physAtt = 10;
        this.magicAtt = 15;
        this.physDef = 0.2;
        this.magicDef = 0.2;
    }

    public void setHealth(double health) {
        this.health = health;
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

    public double getMagicAtt() {
        return magicAtt;
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

    @Override
    public void healHimself() {
        this.health += 50;
        if (health >= MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public void healTeammate(Hero hero) {
        if (hero instanceof Warrior) {
            Warrior warrior = (Warrior) hero;
            warrior.addHealth(30);
        } else if (hero instanceof Magician) {
            Magician magician = (Magician) hero;
            magician.addHealth(30);
        } else if (hero instanceof Shaman) {
            Shaman shaman = (Shaman) hero;
            shaman.addHealth(30);
        } else if (hero instanceof Paladin) {
            Paladin paladin = (Paladin) hero;
            paladin.addHealth(30);
        }
    }

    @Override
    public void magicalAttack(Hero hero) {
        if (hero instanceof Paladin) {
            Paladin paladin = (Paladin) hero;
            paladin.reduceHealth(getMagicAtt() - getMagicAtt() * paladin.getMagicDef());
        } else if (hero instanceof Magician) {
            Magician magician = (Magician) hero;
            magician.reduceHealth(getMagicAtt() - getMagicAtt() * magician.getMagicDef());
        } else if (hero instanceof Shaman) {
            Shaman shaman = (Shaman) hero;
            shaman.reduceHealth(getMagicAtt() - getMagicAtt() * shaman.getMagicDef());
        } else if (hero instanceof Warrior) {
            Warrior warrior = (Warrior) hero;
            warrior.reduceHealth(getMagicAtt() - getMagicAtt() * warrior.getMagicDef());
        }
    }

    @Override
    public void physicalAttack(Hero hero) {
        if (hero instanceof Paladin) {
            Paladin paladin = (Paladin) hero;
            paladin.reduceHealth(getPhysAtt() - getPhysAtt() * paladin.getPhysDef());
        } else if (hero instanceof Magician) {
            Magician magician = (Magician) hero;
            magician.reduceHealth(getPhysAtt() - getPhysAtt() * magician.getPhysDef());
        } else if (hero instanceof Shaman) {
            Shaman shaman = (Shaman) hero;
            shaman.reduceHealth(getPhysAtt() - getPhysAtt() * shaman.getPhysDef());
        } else if (hero instanceof Warrior) {
            Warrior warrior = (Warrior) hero;
            warrior.reduceHealth(getPhysAtt() - getPhysAtt() * warrior.getPhysDef());
        }
    }

    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + health +
                '}';
    }
}
