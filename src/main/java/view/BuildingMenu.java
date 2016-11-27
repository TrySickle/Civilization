package view;

import controller.GameController;
import model.Building;
import model.Settlement;
import model.TerrainTile;
import model.MapObject;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

/**
 * This class should represents the bulding menu
 */
public class BuildingMenu extends AbstractMenu {
    private Button investButton = new Button("Invest");
    private Button demolishButton = new Button("Demolish");
    /**
    * there should be an invest and demolish button for this menu
    * as well as functions associated with the buttons
    */
    public BuildingMenu() {
        this.addMenuItem(investButton);
        this.addMenuItem(demolishButton);

        investButton.setOnAction(e -> {
            TerrainTileFX lastClickedFX = GameController.getLastClicked();
            if (!(lastClickedFX == null)) {
                TerrainTile lastClicked = lastClickedFX.getTile();
                MapObject occupant = lastClicked.getOccupant();
                if (GameController.getCivilization().getTreasury().getCoins() >=
                    25 && (occupant instanceof Building)) {
                        ((Building) occupant).invest();
                        GameController.getCivilization().getTreasury().
                            spend(25);
                        GameController.updateResourcesBar();
                } else {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("You can not afford that investment!");
                    alert.setTitle("Invalid Investment");
                    alert.showAndWait();
                }
            }

        });

        demolishButton.setOnAction(e -> {
            TerrainTileFX lastClickedFX = GameController.getLastClicked();
            if (!(lastClickedFX == null)) {
                TerrainTile lastClicked = lastClickedFX.getTile();
                if (lastClicked.getOccupant() instanceof Settlement) {
                    if (GameController.getCivilization().
                        getNumSettlements() > 1) {
                        ((Building) lastClicked.getOccupant()).demolish();
                        lastClicked.setOccupant(null);
                        GameController.getCivilization().
                            decrementNumSettlements();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("You can not demolish your last"
                            + " settlement!");
                        alert.setTitle("Invalid Demolish");
                        alert.showAndWait();
                    }
                } else {
                    ((Building) lastClicked.getOccupant()).demolish();
                    lastClicked.setOccupant(null);
                }
            }
            GameController.updateResourcesBar();
            lastClickedFX.updateTileView();
        });
    }
}
