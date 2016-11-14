package view;

import controller.GameController;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {


    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        //TODO
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
      //TODO
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        //TODO
    }


    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
       //TODO
    }
}
