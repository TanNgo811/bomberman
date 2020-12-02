package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        Sandbox.setupScene();
        Scene s = Sandbox.getS();
        primaryStage.setScene(s);
        primaryStage.show();

        SoundEffect.playLoop(SoundEffect.mainStage);

    }

    public static void main(String[] args) {
        launch(args);
    }


}
