package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.controls.InputManager;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.levels.Level;

import java.util.ArrayList;

public class GameLoop {

    static final int WIDTH = 31;
    static final int HEIGHT = 13;

    static double currentGameTime;
    static double oldGameTime;
    static double deltaTime;
    static long startNanoTime = System.nanoTime();

    static GraphicsContext gc = Sandbox.getGraphicContext();
    static Canvas canvas = Sandbox.getCanvas();

    public static ArrayList<Entity> entities = Level.getEntities();
    public static ArrayList<Entity> stillObjects = Level.getStillObjects();
    public static ArrayList<Entity> blockObjects = Level.getBlockObjects();


    public static double getCurrentGameTime() {
        return currentGameTime;
    }

    public static void start(GraphicsContext gc) {
//        GameState.gameStatus=GlobalConstants.GameStatus.Running;
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                oldGameTime = currentGameTime;
                currentGameTime = (currentNanoTime - startNanoTime) / 1000000000.0;
                deltaTime = currentGameTime - oldGameTime;
//                gc.clearRect(0, 0, WIDTH, HEIGHT);
                //TODO This will have to be something like, currentScene.getEntities()
                updateGame();
                renderGame();
            }
        }.start();
    }

    public double getDeltaTime() {
        return deltaTime * 100;
    }

    public static void updateGame() {
        InputManager.handlePlayerMovements();
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).isRemoved()) entities.remove(i);
            else entities.get(i).update();
        }
        for (int i = 0; i < blockObjects.size(); i++) {
            if (blockObjects.get(i).isRemoved()) blockObjects.remove(i);
            else blockObjects.get(i).update();
        }

    }

    public static void renderGame() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }



}
