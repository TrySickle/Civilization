package view;

import model.Civilization;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;

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

    private BackgroundImage background;
    private Text selectText;
    private ListView<CivEnum> civListView;
    private Button startButton;
    /**
    * constuctor of the start screen. Should set the background
    * image and display a list of civilizations and a start button
    */
    public StartScreen() {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        Image bImage = new Image(
            "File:./src/main/java/view/civ_background.png");
        background = new BackgroundImage(bImage, BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, false, true));
        selectText = new Text("Select a Civilization to Begin");
        selectText.setFont(new Font(16));
        selectText.setFill(Color.RED);
        ObservableList<CivEnum> civs = FXCollections.observableArrayList(CivEnum.ANCIENT_EGYPT,
            CivEnum.QIN_DYNASTY, CivEnum.ROMAN_EMPIRE);
        civListView = new ListView<CivEnum>(civs);
        civListView.setFixedCellSize(24);
        civListView.setMinWidth(200);
        civListView.setMaxWidth(200);
        civListView.setMinHeight(96);
        civListView.setMaxHeight(96);
        startButton = new Button("START");
        vbox.getChildren().addAll(selectText, civListView, startButton);
        this.setBackground(new Background(background));
        this.getChildren().addAll(vbox);
        this.setMargin(vbox, new Insets(0, 0, 80, 0));
    }
    /**
    * gets the start button
    * @return the start button
    */
    public Button getStartButton() {
        return startButton;
    }
    /**
    * return a ListView of CivEnums representing the list of
    * available civilizations to choose from
    * @return listview of CivEnum
    */
    public ListView<CivEnum> getCivList() {
        return civListView;
    }
}
