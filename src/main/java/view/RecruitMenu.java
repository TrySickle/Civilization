package view;

import controller.GameController;
import model.Civilization;
import model.Unit;
import model.MeleeUnit;
import model.RangedUnit;
import model.HybridUnit;
import model.SiegeUnit;
import model.SettlerUnit;
import model.FarmerUnit;
import model.CoalMinerUnit;
import model.AnglerUnit;
import model.MasterBuilderUnit;
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
                    recruitMenu.getSelectionModel().getSelectedItems().get(0);
                Civilization civ = GameController.getCivilization();
                TerrainTileFX lastClickedFX = GameController.getLastClicked();
                if (!(lastClickedFX == null)) {
                    TerrainTile lastClicked = lastClickedFX.getTile();
                    Unit unit;
                    switch (selectedUnit) {
                    case "Melee Unit":
                        unit = new MeleeUnit(civ);
                        break;
                    case "Ranged Unit":
                        unit = new RangedUnit(civ);
                        break;
                    case "Hybrid Unit":
                        unit = new HybridUnit(civ);
                        break;
                    case "Siege Unit":
                        unit = new SiegeUnit(civ);
                        break;
                    case "Settlers":
                        unit = new SettlerUnit(civ, "nah");
                        break;
                    case "Farmers":
                        unit = new FarmerUnit(civ);
                        break;
                    case "Coal Miners":
                        unit = new CoalMinerUnit(civ);
                        break;
                    case "Anglers":
                        unit = new AnglerUnit(civ);
                        break;
                    case "Master Builders":
                        unit = new MasterBuilderUnit(civ);
                        break;
                    default:
                        unit = new MeleeUnit(civ);
                        break;
                    }
                    if (unit.isAffordable()) {
                        lastClicked.setOccupant(unit);
                        unit.applyInitialCosts();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText("Can not afford this unit!");
                        alert.setTitle("Invalid Recruit");
                        alert.showAndWait();
                    }
                }
                lastClickedFX.updateTileView();
                GameController.updateResourcesBar();
            });
    }
}
