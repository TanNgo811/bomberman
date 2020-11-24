package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.*;
import uet.oop.bomberman.entities.tiles.Grass;
import uet.oop.bomberman.entities.tiles.Portal;
import uet.oop.bomberman.entities.tiles.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

    public static ArrayList<Entity> entities = new ArrayList<>();
    public static ArrayList<Entity> stillObjects = new ArrayList<>();
    public static Player player;


    public static void createMap() {

        try {
            File level = new File(".\\res\\levels\\Level1.txt");
            Scanner sc = new Scanner(level);
            int _LEVEL = sc.nextInt(); // System.out.println(_LEVEL);
            int _HEIGHT = sc.nextInt(); // System.out.println(_HEIGHT);
            int _WIDTH = sc.nextInt(); // System.out.println(_WIDTH);
            Entity object;
            while (!sc.nextLine().contains(";")) {
                for (int j = 0; j < _HEIGHT; j++) {
                    String line = sc.nextLine();
                    System.out.println(line);
                    for (int i = 0; i < _WIDTH; i++) {
                        switch (line.charAt(i)) {
                            case '#':
                                object = new Wall(i, j, Sprite.wall.getFxImage());
                                stillObjects.add(object);
                                break;
                            case 'p':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new Player(i, j, Sprite.player_right.getFxImage());
                                player = (Player) object;
                                entities.add(object);
                                break;
                            case '*':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new Brick(i, j, Sprite.brick.getFxImage());
                                entities.add(object);
                                break;
                            case 'x':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new Portal(i, j, Sprite.portal.getFxImage());
                                stillObjects.add(object);
                                break;
                            case '1':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new Balloon(i, j, Sprite.balloom_right1.getFxImage());
                                entities.add(object);
                                break;
                            case '2':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new Oneal(i, j, Sprite.oneal_right1.getFxImage());
                                entities.add(object);
                                break;
                            case 'b':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new PowerUpBomb(i, j, Sprite.powerup_bombs.getFxImage());
                                entities.add(object);
                                break;
                            case 'f':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new PowerUpFlame(i, j, Sprite.powerup_flames.getFxImage());
                                entities.add(object);
                                break;
                            case 's':
                                stillObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new PowerUpSpeed(i, j, Sprite.powerup_speed.getFxImage());
                                entities.add(object);
                                break;
                            default:
                                object = new Grass(i, j, Sprite.grass.getFxImage());
                                stillObjects.add(object);
                                break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException fe) {
            System.out.println("Not found");
        }

    }

    /*
    Getter & Setter
     */

    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public static ArrayList<Entity> getStillObjects() {
        return stillObjects;
    }

    public void setStillObjects(ArrayList<Entity> stillObjects) {
        this.stillObjects = stillObjects;
    }
}
