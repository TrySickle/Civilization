package view;

import controller.GameController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * This class represents the GameScreen class
 */
public class GameScreen extends BorderPane {
    private static HBox menuBox;
    private static ResourcesMenu resourcesMenu;
    /**
     * Creates a new view into the game. this layout should include
     * the rescource bar, grid map, and action menus
     *
     */
    public GameScreen() {
        menuBox = new HBox(new StatusMenu().getRootNode());
        resourcesMenu = new ResourcesMenu();
        this.setTop(resourcesMenu.getRootNode());
        this.setCenter(GridFX.getInstance());
        this.setLeft(menuBox);
    }

    /**
     * This method should update the gridfx and the resouce bar
     */
    public void update() {
        GridFX.update();
        resourcesMenu.update();
    }
    /**
    * this method should return the resource menu
    * @return reosuce menu
    */
    public static ResourcesMenu getResources() {
        return resourcesMenu;
    }

    /**
     * This method switches menus based on passed in game state.
     * Game.java calls this to selectively control which menus are displayed
     * @param state
     */
    public static void switchMenu(GameController.GameState state) {
        switch (state) {
        case NEUTRAL:
            menuBox.getChildren().set(0, new StatusMenu().getRootNode());
            break;
        case MILITARY:
            menuBox.getChildren().set(0, new MilitaryMenu().getRootNode());
            break;
        case WORKER:
            menuBox.getChildren().set(0, new WorkerMenu().getRootNode());
            break;
        case RECRUITING:
            menuBox.getChildren().set(0, new RecruitMenu().getRootNode());
            break;
        case BUILDING:
            menuBox.getChildren().set(0, new BuildingMenu().getRootNode());
            break;
        default:
            menuBox.getChildren().set(0, new StatusMenu().getRootNode());
            break;
        }
    }
}
