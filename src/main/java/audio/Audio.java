package audio;

import javafx.scene.media.AudioClip;
import java.io.File;
import javafx.util.Duration;

public class Audio {
    private static AudioClip moneySound = new AudioClip(
        new File("src/main/java/audio/money.wav").toURI().toString());
    private static AudioClip errorSound = new AudioClip(
        new File("src/main/java/audio/error.mp3").toURI().toString());
    private static AudioClip battleSound = new AudioClip(
        new File("src/main/java/audio/battle.mp3").toURI().toString());
    private static AudioClip plainsSound = new AudioClip(
        new File("src/main/java/audio/plains.mp3").toURI().toString());
    private static AudioClip waterSound = new AudioClip(
        new File("src/main/java/audio/water.mp3").toURI().toString());
    private static AudioClip snowSound = new AudioClip(
        new File("src/main/java/audio/snow.mp3").toURI().toString());
    private static AudioClip mountainSound = new AudioClip(
        new File("src/main/java/audio/mountain.mp3").toURI().toString());
    private static AudioClip sandSound = new AudioClip(
        new File("src/main/java/audio/sand.mp3").toURI().toString());
    private static AudioClip forestSound = new AudioClip(
        new File("src/main/java/audio/forest.mp3").toURI().toString());
    private static AudioClip victorySound = new AudioClip(
        new File("src/main/java/audio/victory.mp3").toURI().toString());
    private static AudioClip recruitSound = new AudioClip(
        new File("src/main/java/audio/recruit.wav").toURI().toString());
    private static AudioClip convertSound = new AudioClip(
        new File("src/main/java/audio/convert.wav").toURI().toString());
    private static AudioClip exploreSound = new AudioClip(
        new File("src/main/java/audio/explore.wav").toURI().toString());
    private static AudioClip endTurnSound = new AudioClip(
        new File("src/main/java/audio/endturn.wav").toURI().toString());
    private static AudioClip demolishSound = new AudioClip(
        new File("src/main/java/audio/demolish.mp3").toURI().toString());

    public static void playSound(String name) {
        switch (name) {
        case "invest":
            moneySound.play();
            break;
        case "error":
            errorSound.play();
            break;
        case "attack":
            battleSound.play();
            break;
        case "Plains":
            plainsSound.play();
            break;
        case "Mountain":
            mountainSound.play();
            break;
        case "Ice":
            snowSound.play();
            break;
        case "Water":
            waterSound.play();
            break;
        case "Desert":
            sandSound.play();
            break;
        case "Forest":
            forestSound.play();
            break;
        case "victory":
            victorySound.play();
            break;
        case "recruit":
            recruitSound.play();
            break;
        case "convert":
            convertSound.play();
            break;
        case "explore":
            exploreSound.play();
            break;
        case "endTurn":
            endTurnSound.play();
            break;
        case "demolish":
            demolishSound.play();
            break;
        default:
            errorSound.play();
            break;
        }
    }
}
