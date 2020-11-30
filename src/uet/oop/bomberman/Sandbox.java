package uet.oop.bomberman;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import uet.oop.bomberman.controls.EventHandler;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

import java.util.ArrayList;

import static uet.oop.bomberman.BombermanGame.HEIGHT;
import static uet.oop.bomberman.BombermanGame.WIDTH;

public class Sandbox {

    public static ArrayList<Entity> entities = new ArrayList<>();
    public static ArrayList<Entity> stillObjects = new ArrayList<>();
    public static ArrayList<Entity> blockObjects = new ArrayList<>();
    public static ArrayList<Entity> enemies = new ArrayList<>();

    Level level;

    static Scene s;
    static Group root;
    static Canvas c;
    static GraphicsContext gc;

    private static void init() {
        root = new Group();
        s = new Scene(root);
        c = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        root.getChildren().add(c);
        gc = c.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);
//        Renderer.init();
        GameLoop.start(gc);

        Level.createMap();

        entities = Level.getEntities();
        stillObjects = Level.getStillObjects();
        blockObjects = Level.getBlockObjects();
        enemies = Level.getEnemies();

        EventHandler.attachEventHandlers(s);

    }

    public static void setupScene(){
        init();
    }
    public static Scene getScene() {
        return s;
    }


    /*
    Getter & Setter
     */

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void setStillObjects(ArrayList<Entity> stillObjects) {
        this.stillObjects = stillObjects;
    }

    public ArrayList<Entity> getEntities() {
        return (ArrayList<Entity>) entities;
    }

    public ArrayList<Entity> getStillObjects() {
        return stillObjects;
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
