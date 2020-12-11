package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uet.oop.bomberman.gui.MainController;
import uet.oop.bomberman.levels.Level;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public void start(Stage primaryStage) {
        if (!MainController.isMultiMode()) {
            primaryStage.setTitle("BomberNoBrain");

        } else {
            primaryStage.setTitle("Bomber Multiplayer");
        }
        Sandbox.setupScene();
        Scene s = Sandbox.getS();
        primaryStage.setScene(s);
        primaryStage.show();

        if (SoundEffect.isCanPlay()) {
            if (Level.level!=6) SoundEffect.playLoop(SoundEffect.mainStage);
            else SoundEffect.playLoop(SoundEffect.endingStage);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}
