package view;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import model.TerrainTile;

public class Translate {
    public static void translate(Node tile, TerrainTile start,
        TerrainTile end) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(tile);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setAutoReverse(false);
        translateTransition.setCycleCount(1);
        translateTransition.setByX(calcX(calcDirection(start, end)));
        translateTransition.setByY(calcY(calcDirection(start, end)));
        translateTransition.play();
    }

    public static String calcDirection(TerrainTile start, TerrainTile end) {
        String direction = "";
        if (start.getRow() < end.getRow()) {
            direction += "S";
        } else if (start.getRow() > end.getRow()) {
            direction += "N";
        }

        if (start.getCol() > end.getCol()) {
            direction += "W";
        } else if (start.getCol() < end.getCol()) {
            direction += "E";
        }

        return direction;
    }

    public static int calcX(String direction) {
        switch (direction) {
        case "N":
            return 0;
        case "NE":
            return 70;
        case "E":
            return 70;
        case "SE":
            return 70;
        case "S":
            return 0;
        case "SW":
            return -70;
        case "W":
            return -70;
        case "NW":
            return -70;
        default:
            return 0;
        }
    }

    public static int calcY(String direction) {
        switch (direction) {
        case "N":
            return -70;
        case "NE":
            return -70;
        case "E":
            return 0;
        case "SE":
            return 70;
        case "S":
            return 70;
        case "SW":
            return 70;
        case "W":
            return 0;
        case "NW":
            return -70;
        default:
            return 0;
        }
    }
}
