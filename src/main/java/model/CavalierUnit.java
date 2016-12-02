package model;

import javafx.scene.image.Image;

/**
 * Represents a Legion unit.
 *
 * @author Jim Harris
 * @version 1.0
 */
class CavalierUnit extends MeleeUnit {
    private int attackCount = 0;
    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public CavalierUnit(Civilization owner) {
        super(owner);
        this.setDamage((int) (this.getDamage() * 1.25));
    }

    @Override
    public void attack(MapObject o) {
        getOwner().getStrategy().battle();
        battle(o);
        if (attackCount++ >= 1) {
            setCanAttack(false);
        }
    }

    @Override
    public void tick() {
        super.tick();
        attackCount = 0;
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
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
        return "Cavalier. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new
            Image("File:./src/main/java/view/Civ_Icon/cavalier.PNG");
    }

}
