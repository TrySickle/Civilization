package runner;

import controller.GameController;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import model.Map;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private StartScreen startScreen = new StartScreen();
    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        Scene scene = new Scene(startScreen, 1067, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    /**
     * This is the main method that launches the javafx application
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
    * This method is responsible for setting the scene to the corresponding
    * layout.
    * and returning the scene.
    * @return Scene
    */

    public static Scene startGame() {
        TextInputDialog input = new TextInputDialog("Town Name");
        input.setTitle("A New Settlement");
        input.setHeaderText("You have built a Settlement!");
        input.setContentText("Enter the Name of your first town:");
        input.show();

        return null;
    }




}
