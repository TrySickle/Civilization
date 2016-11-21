package runner;

import java.util.Optional;
import controller.GameController;
import model.Civilization;
import view.StartScreen;
import view.CivEnum;
import view.GameScreen;
import view.GridFX;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

/**
 * Created by Tian-Yo Yang on 11/11/2016.
 */
public class CivilizationGame extends Application {
    private StartScreen startScreen;
    private Stage stage;
    private Scene scene;
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
        scene = new Scene(startScreen, 1067, 600);
        stage.setScene(scene);
        TextInputDialog input = new TextInputDialog("Town Name");
        input.setTitle("A New Settlement");
        input.setHeaderText("You have built a Settlement!");
        input.setContentText("Enter the Name of your first town:");

        ListView<CivEnum> civListView = startScreen.getCivList();
        Button startButton = startScreen.getStartButton();
        startButton.setOnAction(e -> {
            Optional<String> result = input.showAndWait();
            if (result.isPresent()) {
                GameController.setCivilization(new Civilization(
                    civListView.getSelectionModel().getSelectedItems()
                    .get(0).toString()));
                GridFX.getMap().putSettlement(result.get(), GameController.getCivilization(), 9, 0);
                GridFX.getMap().putSettlement("Bandits",
                    GameController.getBandits(), 4, 4);
                System.out.println(result.get());
                scene = new Scene(new GameScreen(), 1067, 600);
                stage.setScene(scene);
            }
        });

        return scene;
    }
}
