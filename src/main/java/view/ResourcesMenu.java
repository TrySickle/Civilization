package view;

import controller.GameController;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Civilization;

public class ResourcesMenu {
    private int stratLevel;
    private int techPoints;
    private int resources;
    private int numSettlements;
    private int money;
    private int food;
    private int happiness;
    private HBox hBox;
    /**
    * creates a resource bar and display the current state of
    * your civilization's resouces
    */
    public ResourcesMenu() {
        hBox = new HBox();
        hBox.setSpacing(15);
        update();
    }
    /**
    * should update all the resouce values to the current
    * state of your resource values
    */
    public void update() {
        Civilization civ = GameController.getCivilization();
        stratLevel = civ.getStrategy().getStrategyLevel();
        techPoints = civ.getTechnology().getTechPoints();
        resources = civ.getResources();
        numSettlements = civ.getNumSettlements();
        money = civ.getTreasury().getCoins();
        food = civ.getFood();
        happiness = civ.getHappiness();

        Text stratText = new Text(String.format("Strat Level: %d", stratLevel));
        Text techText = new Text(String.format("Tech Points: %d", techPoints));
        Text resourceText = new Text(String.format("Resources: %d", resources));
        Text settleText = new Text(String.format("Settlements: %d",
            numSettlements));
        Text moneyText = new Text(String.format("Money: %d", money));
        Text foodText = new Text(String.format("Food: %d", food));
        Text happyText = new Text(String.format("Happiness: %d", happiness));

        hBox.getChildren().setAll(stratText, techText, resourceText, settleText,
            moneyText, foodText, happyText);
    }
    /**
    * updates the resource bar and returns the resource bar
    * @return a hbox representation of the resource bar
    */
    public HBox getRootNode() {
        update();
        return hBox;
    }
}
