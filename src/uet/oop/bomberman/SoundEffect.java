package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class SoundEffect extends Application {

//    URL urlBackSound = new File
    //Background Sound
//    File soundFile = new File("./res/sound/backSound.mp3");
//    public static Media mediaBackSound = new Media(new File("F:\\OOP Code\\bomber_fx_2\\bomberman\\res\\sound\\backSound.mp3").toURI().toString());
//    public static Media mediaBackSound = new Media("src\\audio\\backSound.mp3");
//    public static Media mediaBackSound = new Media(soundFile.toString());

    public static Media mainStage = new Media(new File("res/sound/03_Stage Theme.mp3").toURI().toString());
    public static Media mainMenu = new Media(new File("res/sound/01_Title Screen.mp3").toURI().toString());
    public static Media endingStage = new Media(new File("res/sound/06_Ending.mp3").toURI().toString());

    public static AudioClip stageStart = new AudioClip((new File("res/sound/02_Stage Start.mp3")).toURI().toString()); // Dung khi cho vao Level scene
    public static AudioClip pass = new AudioClip((new File("res/sound/04_Stage Complete.mp3")).toURI().toString());
    public static AudioClip powerUp = new AudioClip((new File("res/sound/power_up.wav")).toURI().toString());
    public static AudioClip bombDrop = new AudioClip((new File("res/sound/drop_bomb.wav")).toURI().toString());
    public static AudioClip bombExplode = new AudioClip((new File("res/sound/bomb_explode.wav")).toURI().toString());
    public static AudioClip playerWalkV = new AudioClip((new File("res/sound/walk_verti.wav")).toURI().toString());
    public static AudioClip playerWalkH = new AudioClip((new File("res/sound/walk_horiz.wav")).toURI().toString());

    public static MediaPlayer mediaPlayer = new MediaPlayer(mainMenu);
    //    C:\Users\corng\Downloads\Compressed\Bomber-main_2\Bomber-main\src\Sound
//    public static MediaPlayer mediaPlayerBackSound = new MediaPlayer(mediaBackSound);

//    MediaView mediaView = new MediaView(mediaPlayerBackSound);

    public static void sound(Media m) {
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.play();
        System.out.println("play");
    }

    public static void playLoop(Media m) {
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.setVolume(0.3);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setAutoPlay(true);
//        System.out.println("play");
    }

    public void start(Stage primaryStage) throws Exception {
//        sound(mediaPlayerBackSound);
////        Group root = new Group(mediaView);
//        Scene scene = new Scene(root, 500, 200);
//
//        // Show the stage
//        primaryStage.setTitle("Media Player");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        // Play the media once the stage is shown
//        mediaPlayerBackSound.play();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
