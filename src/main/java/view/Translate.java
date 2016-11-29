package view;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import model.TerrainTile;
import controller.GameController;

public class Translate {
    public static void translate(Node tile, TerrainTile start,
        TerrainTile end) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(tile);
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setAutoReverse(false);
        translateTransition.setCycleCount(1);
        translateTransition.setByX(calcX(start, end));
        translateTransition.setByY(calcY(start, end));
        translateTransition.play();
        translateTransition.setOnFinished(e -> {
                GameScreen.getGridFX().getChildren().remove(GameController.
                    getMover());
                GridFX.update();
            });
    }

    public static int calcX(TerrainTile start, TerrainTile end) {
        if (start.getCol() > end.getCol()) {
            return -70;
        } else if (start.getCol() < end.getCol()) {
            return 70;
        } else {
            return 0;
        }
    }

    public static int calcY(TerrainTile start, TerrainTile end) {
        if (start.getRow() < end.getRow()) {
            return 70;
        } else if (start.getRow() > end.getRow()) {
            return -70;
        } else {
            return 0;
        }
    }
}
