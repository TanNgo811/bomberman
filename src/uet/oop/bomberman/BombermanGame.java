package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uet.oop.bomberman.gui.MainController;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;


    public void start(Stage primaryStage) {
//        primaryStage.setTitle("BomberNoBrain");
//        Sandbox.setupScene();
//        Scene s = Sandbox.getS();
//        primaryStage.setScene(s);
//        primaryStage.show();
//
//        if (SoundEffect.isCanPlay()) {
//            SoundEffect.playLoop(SoundEffect.mainStage);
//        }
        if (MainController.isMultiMode() == false) {
            primaryStage.setTitle("BomberNoBrain");

        } else {
            primaryStage.setTitle("Bomber Multiplayer");
        }
        Sandbox.setupScene();
        Scene s = Sandbox.getS();
        primaryStage.setScene(s);
        primaryStage.show();

        if (SoundEffect.isCanPlay()) {
            SoundEffect.playLoop(SoundEffect.mainStage);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}
