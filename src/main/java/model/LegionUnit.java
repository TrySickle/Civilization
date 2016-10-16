package model;

class LegionUnit extends MeleeUnit {
    public LegionUnit(Civilization owner) {
        super(owner);
        setDamage((int) (getDamage() * 1.5));
    }

    @Override
    public void battle(MapObject o) {
        o.damage(getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }
}
