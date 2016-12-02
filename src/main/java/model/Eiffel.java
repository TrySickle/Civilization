package model;

import javafx.scene.image.Image;

class Eiffel extends Landmark {

    /**
     * Public constructor.
     *
     * @param owner the Civilization that owns this Building.
     */
    public Eiffel(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().philosophize();
    }

    @Override
    public String toString() {
        return "Eiffel Tower " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/eiffel_icon.JPG");
    }
}
