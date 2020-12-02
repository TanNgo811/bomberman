package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class SoundEffect extends Application {

//    URL urlBackSound = new File
    //Background Sound
//    File soundFile = new File("./res/sound/backSound.mp3");
//    public static Media mediaBackSound = new Media(new File("F:\\OOP Code\\bomber_fx_2\\bomberman\\res\\sound\\backSound.mp3").toURI().toString());
    public static Media mediaBackSound = new Media("src\\audio\\backSound.mp3");
//    public static Media mediaBackSound = new Media(soundFile.toString());



    //    C:\Users\corng\Downloads\Compressed\Bomber-main_2\Bomber-main\src\Sound
    public static MediaPlayer mediaPlayerBackSound = new MediaPlayer(mediaBackSound);

    MediaView mediaView = new MediaView(mediaPlayerBackSound);

    public static void sound(MediaPlayer mp) {
        mp.play();
        System.out.println("play");
    }

    public void start(Stage primaryStage) throws Exception {
//        sound(mediaPlayerBackSound);
        Group root = new Group(mediaView);
        Scene scene = new Scene(root, 500, 200);

        // Show the stage
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Play the media once the stage is shown
        mediaPlayerBackSound.play();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
