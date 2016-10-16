package model;

abstract class MilitaryUnit extends Unit {
    private int damage;

    public MilitaryUnit(int health, Civilization owner, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {
        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        setDamage(damage);
    }

    @Override
    public void tick() {
        super.tick();
        super.setCanAttack(true);
    }

    public abstract void battle(MapObject o);

    public void attack(MapObject o) {
        getOwner().getStrategy().battle();
        battle(o);
        super.setCanAttack(false);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }
}
