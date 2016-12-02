package model;

import javafx.scene.image.Image;

class GrenadierUnit extends RangedUnit {

    /**
     * Public constructor.
     *
     * @param owner the owner of this unit.
     */
    public GrenadierUnit(Civilization owner) {
        super(owner);
        setCanAttack(true);
    }

    @Override
    public char symbol() {
        return 'W';
    }


    @Override
    public String toString() {
        return "Grenadier Unit. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/grenadier_unit.PNG");
    }
}
