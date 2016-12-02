package model;

import javafx.scene.image.Image;

class BigBen extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public BigBen(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().philosophize();
    }

    @Override
    public String toString() {
        return "Big Ben " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/bigben_icon.JPG");
    }
}
