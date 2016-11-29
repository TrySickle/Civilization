package view;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;
import model.TerrainTile;
import controller.GameController;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

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

    public static void attackTranslate(TerrainTile start, TerrainTile end) {
        ImageView sword = new ImageView(new
            Image("file:./src/main/java/view/attack.png"));
        sword.setRotate(getRotation(start, end));
        GameScreen.getGridFX().add(sword, start.getCol(), start.getRow());
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(sword);
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setAutoReverse(false);
        translateTransition.setCycleCount(1);
        translateTransition.setByX(calcX(start, end));
        translateTransition.setByY(calcY(start, end));
        translateTransition.play();
        translateTransition.setOnFinished(e -> {
                GameScreen.getGridFX().getChildren().remove(sword);
            });
    }

    public static int getRotation(TerrainTile start, TerrainTile end) {
        if (start.getRow() > end.getRow()) {
            if (start.getCol() > end.getCol()) {
                return -135;
            } else if (start.getCol() == end.getCol()) {
                return 180;
            } else {
                return 135;
            }
        } else if (start.getRow() == end.getRow()) {
            if (start.getCol() > end.getCol()) {
                return 90;
            } else {
                return -90;
            }
        } else {
            if (start.getCol() > end.getCol()) {
                return 45;
            } else if (start.getCol() == end.getCol()) {
                return 0;
            } else {
                return -45;
            }
        }
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
