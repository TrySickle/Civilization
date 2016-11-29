package audio;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
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
    private static AudioClip menuSound = new AudioClip(
        new File("src/main/java/audio/menuclick.wav").toURI().toString());
    private static AudioClip clickSound = new AudioClip(
        new File("src/main/java/audio/click.wav").toURI().toString());
    private static AudioClip buttonSound = new AudioClip(
        new File("src/main/java/audio/button.mp3").toURI().toString());
    private static MediaPlayer startMusic = new MediaPlayer(
        new Media(new File("src/main/java/audio/start.mp3").
        toURI().toString()));
    private static MediaPlayer gameMusic = new MediaPlayer(
        new Media(new File("src/main/java/audio/game.mp3").
        toURI().toString()));

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
        case "menu":
            menuSound.play();
            break;
        case "click":
            clickSound.play();
            break;
        case "button":
            buttonSound.play();
            break;
        default:
            errorSound.play();
            break;
        }
    }

    public static void playMusic(String desc) {
        switch (desc) {
        case "start":
            startMusic.setCycleCount(MediaPlayer.INDEFINITE);
            startMusic.setVolume(0.5);
            startMusic.play();
            break;
        case "game":
            gameMusic.setCycleCount(MediaPlayer.INDEFINITE);
            gameMusic.setVolume(0.5);
            startMusic.stop();
            gameMusic.play();
            break;
        default:
            break;
        }
    }
}
