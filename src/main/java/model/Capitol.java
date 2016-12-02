package model;

import javafx.scene.image.Image;

class Capitol extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Capitol(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().increaseBuildExperience();
    }

    @Override
    public String toString() {
        return "Capitol " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/capitol_icon.PNG");
    }
}
