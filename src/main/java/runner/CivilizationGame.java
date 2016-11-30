package runner;

import java.util.Optional;
import controller.GameController;
import model.Civilization;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
import model.QinDynasty;
import model.RomanEmpire;
import model.Egypt;
import model.Bandit;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import audio.Audio;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private StartScreen startScreen;
    private GameScreen gameScreen;
    private Stage stage;
    private Scene scene;
    private int height = 725;
    private int width = 850;
    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     */
    public void start(Stage primaryStage) {
        stage = primaryStage;
        startScreen = new StartScreen();
        startGame();
        stage.setResizable(false);
        stage.show();
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

    public Scene startGame() {
        scene = new Scene(startScreen, width, height);
        stage.setScene(scene);
        TextInputDialog input = new TextInputDialog("Town Name");
        input.setTitle("A New Settlement");
        input.setHeaderText("You have built a Settlement!");
        input.setContentText("Enter the Name of your first town:");

        ListView<CivEnum> civListView = startScreen.getCivList();
        Button startButton = startScreen.getStartButton();
        startButton.setOnAction(e -> {
                Audio.playSound("button");
                Optional<String> result = input.showAndWait();
                if (result.isPresent()) {
                    GameController.setCivilization(getCiv(
                        civListView.getSelectionModel().getSelectedItems()
                        .get(0).toString()));
                    GridFX.getMap().putSettlement(result.get(),
                        GameController.getCivilization(), 0, 9);
                    GridFX.getMap().addEnemies(
                        ((Bandit) GameController.getBandits()), 3);
                    gameScreen = new GameScreen();
                    scene = new Scene(gameScreen, width, height);
                    stage.setScene(scene);
                    gameScreen.update();
                    Audio.playMusic("game");
                }
            });

        return scene;
    }

    private Civilization getCiv(String name) {
        switch (name) {
        case "Ancient Egypt":
            return new Egypt();
        case "Qin Dynasty":
            return new QinDynasty();
        case "Roman Empire":
            return new RomanEmpire();
        default:
            return new Civilization("DEFAULT");
        }
    }
}
