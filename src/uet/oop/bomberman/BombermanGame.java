package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.characters.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.tiles.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        Sandbox.setupScene();
        Scene s = Sandbox.getS();
        primaryStage.setScene(s);
        primaryStage.show();

//        SoundEffect.sound(SoundEffect.mediaPlayerBackSound);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
