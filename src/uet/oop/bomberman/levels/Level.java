package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.*;
import uet.oop.bomberman.entities.characters.enemy.Balloon;
import uet.oop.bomberman.entities.tiles.destroyable.Brick;
import uet.oop.bomberman.entities.characters.enemy.Oneal;
import uet.oop.bomberman.entities.powerups.*;
import uet.oop.bomberman.entities.tiles.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

    public static ArrayList<Entity> layerObjects = new ArrayList<>();
    public static ArrayList<Entity> block = new ArrayList<>();
    public static ArrayList<Entity> enemies = new ArrayList<>();
    public static ArrayList<Entity> powerUps = new ArrayList<>();

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
                                layerObjects.add(object);
                                block.add(object);
                                break;
                            case 'p':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                player = new Player(i, j, Sprite.player_right.getFxImage());
                                break;
                            case '*':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                object = new Brick(i, j, Sprite.brick.getFxImage());
                                layerObjects.add(object);
                                block.add(object);
                                break;
                            case 'x':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                block.add(new Brick(i,j,Sprite.brick.getFxImage()));
                                layerObjects.add(new Portal(i, j, Sprite.portal.getFxImage()));
                                break;
                            case '1':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                enemies.add(new Balloon(i, j, Sprite.balloom_right1.getFxImage()));
                                break;
                            case '2':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                enemies.add(new Oneal(i, j, Sprite.oneal_right1.getFxImage()));
                                break;
                            case 'b':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                powerUps.add(new PowerUpBomb(i, j, Sprite.powerup_bombs.getFxImage()));
                                block.add(new Brick(i,j,Sprite.brick.getFxImage()));
                                break;
                            case 'f':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                powerUps.add(new PowerUpFlame(i, j, Sprite.powerup_flames.getFxImage()));
                                block.add(new Brick(i,j,Sprite.brick.getFxImage()));
                                break;
                            case 's':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                powerUps.add(new PowerUpSpeed(i, j, Sprite.powerup_speed.getFxImage()));
                                block.add(new Brick(i,j,Sprite.brick.getFxImage()));
                                break;
                            default:
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
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

    public static ArrayList<Entity> getBlock() {
        return block;
    }

    public static ArrayList<Entity> getLayerObjects() {
        return layerObjects;
    }

    public static ArrayList<Entity> getPowerUps() {
        return powerUps;
    }

    public static ArrayList<Entity> getBlockObjects() {
        return block;
    }

    public static ArrayList<Entity> getEnemies() {
        return enemies;
    }

    public static void setBlock(ArrayList<Entity> block) {
        Level.block = block;
    }

    public static void setEnemies(ArrayList<Entity> enemies) {
        Level.enemies = enemies;
    }

    public static void setLayerObjects(ArrayList<Entity> layerObjects) {
        Level.layerObjects = layerObjects;
    }

    public static void setPlayer(Player player) {
        Level.player = player;
    }

    public static void setPowerUps(ArrayList<Entity> powerUps) {
        Level.powerUps = powerUps;
    }
}
