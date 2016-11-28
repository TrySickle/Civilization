package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import model.TerrainTile;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by RuYiMarone on 11/11/2016.
 */
public class RecruitMenu extends AbstractMenu {
    private ListView<String> recruitMenu;
    private Button selectButton = new Button("Select");
    /**
    * recuit menu should have a list of worker/units
    * to choose from. There should also be a select button
    * and the function of the button should be implemented
    *here
    */
    public RecruitMenu() {
        ObservableList<String> units =
            FXCollections.observableArrayList("Melee Unit", "Ranged Unit",
                "Hybrid Unit", "Siege Unit", "Settlers", "Farmers",
                "Coal Miners", "Anglers", "Master Builders");
        recruitMenu = new ListView<String>(units);
        recruitMenu.setFixedCellSize(24);
        recruitMenu.setMinWidth(140);
        recruitMenu.setMaxWidth(140);
        recruitMenu.setMinHeight(220);
        recruitMenu.setMaxHeight(220);
        this.addMenuItem(recruitMenu);
        this.addMenuItem(selectButton);

        selectButton.setOnAction(e -> {
                String selectedUnit =
                    recruitMenu.getSelectionModel().
                    getSelectedItems().get(0);
                Civilization civ = GameController.getCivilization();
                TerrainTileFX lastClickedFX =
                    GameController.getLastClicked();
                if (!(lastClickedFX == null)) {
                    TerrainTile lastClicked = lastClickedFX.getTile();
                    Unit unit;
                    switch (selectedUnit) {
                    case "Melee Unit":
                        unit = civ.getMeleeUnit();
                        break;
                    case "Ranged Unit":
                        unit = civ.getRangedUnit();
                        break;
                    case "Hybrid Unit":
                        unit = civ.getHybridUnit();
                        break;
                    case "Siege Unit":
                        unit = civ.getSiegeUnit();
                        break;
                    case "Settlers":
                        unit = civ.getSettlerUnit("nah");
                        break;
                    case "Farmers":
                        unit = civ.getFarmerUnit();
                        break;
                    case "Coal Miners":
                        unit = civ.getCoalMinerUnit();
                        break;
                    case "Anglers":
                        unit = civ.getAnglerUnit();
                        break;
                    case "Master Builders":
                        unit = civ.getMasterBuilderUnit();
                        break;
                    default:
                        unit = civ.getMeleeUnit();
                        break;
                    }
                    if (unit.isAffordable()) {
                        lastClicked.setOccupant(unit);
                        unit.applyInitialCosts();
                        GameController.setLastClicked(lastClickedFX);
                    } else {
                        Alert alert = new Alert(
                            Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can not afford this unit!");
                        alert.setTitle("Invalid Recruit");
                        alert.showAndWait();
                    }
                }
            });
    }
}
