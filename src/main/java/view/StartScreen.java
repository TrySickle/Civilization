package view;

import model.Civilization;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 * This class represents the Start Screen for the Civ applicatios. This is the
 * layout that should be displayed upon running the Civ application.
 *
 * This class should have and display
 * 1. a background
 * 2. a list of Civilizations
 * 3. a Start button
 */
public class StartScreen extends StackPane {
    

    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        //TODO
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        //TODO
    }
    /**
    * return a ListView of CivEnums representing the list of 
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        //TODO
    }
    /**
    * shoud set the civilization taken in by the method to the civilization
    * selected for this screen
    */
    public void setCivilization(Civilization c) {
        //TODO
    }

}