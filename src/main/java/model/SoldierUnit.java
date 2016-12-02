package model;

import javafx.scene.image.Image;

class SoldierUnit extends HybridUnit {

    /**
     * Public constructor
     *
     * @param owner The owner of this unit.
     */
    public SoldierUnit(Civilization owner) {
        super(100, owner);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof HybridUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'B';
    }


    @Override
    public String toString() {
        return "Soldier. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/"
                + "soldier_unit.JPG");
    }
}
