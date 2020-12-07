package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uet.oop.bomberman.controls.EventHandler;
import uet.oop.bomberman.controls.InputManager;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.entities.characters.Player2;
import uet.oop.bomberman.entities.characters.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.gui.MainController;
import uet.oop.bomberman.levels.Level;

import java.util.ArrayList;

public class Sandbox {

    static final int WIDTH = BombermanGame.WIDTH;
    static final int HEIGHT = BombermanGame.HEIGHT;

    static double currentGameTime;
    static double oldGameTime;
    static double deltaTime;
    static long startNanoTime = System.nanoTime();

    public static ArrayList<Entity> powerUps = new ArrayList<>();
    public static ArrayList<Entity> layerObjects = new ArrayList<>();
    public static ArrayList<Entity> blockObjects = new ArrayList<>();
    public static ArrayList<Entity> enemies = new ArrayList<>();
    public static ArrayList<Entity> bombs = new ArrayList<>();

    public static Player player;
    public static Player2 player2;

    static Scene s;
    static Group root;
    static Canvas c;
    static GraphicsContext gc;

    boolean multiMode = false;
    /*
    * Single Player
    * */
    public static void init() {
        if (MainController.isMultiMode() == true) {
            Level.createMultiplayerMap();
        } else {
            Level.createMap();
        }

        layerObjects = Level.getLayerObjects();
        blockObjects = Level.getBlockObjects();
        enemies = Level.getEnemies();
        powerUps = Level.getPowerUps();
        player = Level.getPlayer();
        player2 = Level.getPlayer2();
        bombs.removeAll(bombs);
        if (SoundEffect.isCanPlay()) {
            SoundEffect.stageStart.play(0.5);

        }
        EventHandler.attachEventHandlers(s);
    }

    public static void setupScene(){
        root = new Group();
        s = new Scene(root);
        c = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        root.getChildren().add(c);
        gc = c.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);
        start(gc);

        init();
    }

//    /*
//    * Multiplayer
//    * */
//    public static void initMulti() {
//        Level.createMultiplayerMap();
//
//        layerObjects = Level.getLayerObjects();
//        blockObjects = Level.getBlockObjects();
//        enemies = Level.getEnemies();
//        powerUps = Level.getPowerUps();
//        player = Level.getPlayer();
//        player2 = Level.getPlayer2();
//        bombs.removeAll(bombs);
//        if (SoundEffect.isCanPlay()) {
//            SoundEffect.stageStart.play(0.5);
//
//        }
//        EventHandler.attachEventHandlers(s);
//    }
//
//    public static void setupMultiPlayerScene(){
//        root = new Group();
//        s = new Scene(root);
//        c = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
//        root.getChildren().add(c);
//        gc = c.getGraphicsContext2D();
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(2);
//        gc.setFill(Color.BLUE);
//        start(gc);
//
//        initMulti();
//    }

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
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).isRemoved()) enemies.remove(i);
            else enemies.get(i).update();
        }
        for (int i = 0; i < blockObjects.size(); i++) {
            if (blockObjects.get(i).isRemoved()) blockObjects.remove(i);
            else blockObjects.get(i).update();
        }
        player.update();
        for (int i = 0; i < bombs.size(); i++) {
            if (bombs.get(i).isRemoved()) bombs.remove(i);
            else bombs.get(i).update();
        }
        for (int i = 0; i < powerUps.size(); i++) {
            if (powerUps.get(i).isRemoved()) powerUps.remove(i);
            else powerUps.get(i).update();
        }
        updateItem();
        updatePortal();

    }

    public static void renderGame() {
        gc.clearRect(0, 0, c.getWidth(), c.getHeight());
        layerObjects.forEach(g -> g.render(gc));
        bombs.forEach(g -> g.render(gc));
        powerUps.forEach(g -> g.render(gc));
        blockObjects.forEach(g -> g.render(gc));
        enemies.forEach(g -> g.render(gc));
        player.render(gc);
        if (MainController.isMultiMode()) {
            player2.render(gc);
        }

    }



    public static void addBomb(Entity b) {
        bombs.add(b);
    }

    public static void addEnemy(Enemy e) {
        enemies.add(e);
    }

    public static Entity getEntity(int x, int y) {
        int xUnit = x / Sprite.SCALED_SIZE;
        int yUnit = y / Sprite.SCALED_SIZE;
        for (Entity e : enemies) {
            if (e.getXUnit() == xUnit && e.getYUnit() == yUnit)
                return e;
        }
        for (Entity e : powerUps) {
            if (e.getXUnit() == xUnit && e.getYUnit() == yUnit)
                return e;
        }
        return null;
    }

    public static Entity getBlock(int x, int y) {
        int xUnit = x / Sprite.SCALED_SIZE;
        int yUnit = y / Sprite.SCALED_SIZE;
        for (Entity e : blockObjects) {
            if (e.getXUnit() == xUnit && e.getYUnit() == yUnit) {
                return e;
            }
        }
        return null;
    }

    public static void updateItem() {
        if (!player.checkCollisionsWithPowerUpFlame(player.getX(), player.getY())) {
            System.out.println("Touch Flame");
            if (SoundEffect.isCanPlay()) {
                SoundEffect.powerUp.play(0.25);

            }
            player.setBombRadius(player.getRadius() + 1);
        }

        if (!player.checkCollisionsWithPowerUpBomb(player.getX(), player.getY())) {
            System.out.println("Touch Bomb Item");
            if (SoundEffect.isCanPlay()) {
                SoundEffect.powerUp.play(0.25);

            }
            player.addBomb();
        }

        if (!player.checkCollisionsWithPowerUpSpeed(player.getX(), player.getY())) {
            System.out.println("Touch Speed Item");
            if (SoundEffect.isCanPlay()) {
                SoundEffect.powerUp.play(0.25);
            }
            player.setSpeed(player.getSpeed() + 1);
        }
    }

    public static void updatePortal() {
        if (!player.checkCollisionsWithPortal(player.getX(), player.getY())) {
            System.out.println("Touch Portal");
            if (Sandbox.getEnemies().isEmpty()) {
                Level.level++;
                Sandbox.init();
            } else {
                System.out.println("Kill all to pass this level");
            }
        }
    }


    /*
    Getter & Setter
     */

    public void setLayerObjects(ArrayList<Entity> layerObjects) {
        this.layerObjects = layerObjects;
    }

    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Entity> getEnemies() {
        return enemies;
    }

    public static ArrayList<Entity> getBombs() {
        return bombs;
    }

    public static ArrayList<Entity> getLayerObjects() {
        return layerObjects;
    }

    public static Scene getS() {
        return s;
    }

    public static void setS(Scene s) {
        Sandbox.s = s;
    }

    public static Group getRoot() {
        return root;
    }

    public static void setRoot(Group root) {
        Sandbox.root = root;
    }

    public static Canvas getCanvas() {
        return c;
    }

    public static void setC(Canvas c) {
        Sandbox.c = c;
    }

    public static GraphicsContext getGraphicContext() {
        return gc;
    }

    public static void setGc(GraphicsContext gc) {
        Sandbox.gc = gc;
    }
}
