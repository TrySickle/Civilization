package view;

import controller.GameController;
import model.Convertable;
import model.TerrainTile;
import controller.TileType;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import audio.Audio;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class WorkerMenu extends AbstractMenu {
    private Button moveButton = new Button("Move");
    private Button convertButton = new Button("Convert");
    /**
    * There should be a convert and move button
    * as well as the functions associated with those
    * buttons
    */
    public WorkerMenu() {
        this.addMenuItem(moveButton);
        this.addMenuItem(convertButton);

        moveButton.setOnAction(e -> {
                GameController.moving();
            });

        convertButton.setOnAction(e -> {
                TerrainTileFX lastClickedFX = GameController.getLastClicked();
                if (!(lastClickedFX == null)) {
                    TerrainTile lastClicked = lastClickedFX.getTile();
                    Convertable occupant = (Convertable)
                        (lastClicked.getOccupant());
                    TileType type = lastClicked.getType();
                    if (occupant.canConvert(type)) {
                        lastClicked.setOccupant(occupant.convert());
                        GameController.setLastClicked(lastClickedFX);
                        Audio.playSound("convert");
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("You can not convert that!");
                        alert.setTitle("Invalid Action");
                        Audio.playSound("error");
                        alert.showAndWait();
                    }
                }
            });
    }
}
