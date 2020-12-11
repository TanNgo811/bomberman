package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.*;
import uet.oop.bomberman.entities.characters.enemy.*;
import uet.oop.bomberman.entities.tiles.destroyable.Brick;
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
    public static ArrayList<Entity> wallOnly = new ArrayList<>();
    public static ArrayList<Entity> enemies = new ArrayList<>();
    public static ArrayList<Entity> powerUps = new ArrayList<>();

    public static int height, width;

    public static Player player;
    public static Player2 player2;
    public static int level = 1;

    public static void createMap() {

        try {
            layerObjects.removeAll(layerObjects);
            block.removeAll(block);
            enemies.removeAll(enemies);
            powerUps.removeAll(powerUps);

            File levelFile = new File(".\\res\\levels\\Level" + level + ".txt");
            Scanner sc = new Scanner(levelFile);
            level = sc.nextInt(); // System.out.println(_LEVEL);
            int _HEIGHT = sc.nextInt(); // System.out.println(_HEIGHT);
            int _WIDTH = sc.nextInt(); // System.out.println(_WIDTH);

            height = _HEIGHT;
            width = _WIDTH;

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
                                wallOnly.add(object);
                                break;
                            case 'p':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                player = new Player(i, j, Sprite.player_right.getFxImage());
                                break;
                            case 'z':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                player2 = new Player2(i, j, Sprite.player2_right.getFxImage());
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
                            case '3':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                enemies.add(new Doll(i, j, Sprite.doll_right1.getFxImage()));
                                break;
                            case '4':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                enemies.add(new Kondoria(i, j, Sprite.kondoria_right1.getFxImage()));
                                break;
                            case '5':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                enemies.add(new Minvo(i, j, Sprite.minvo_right1.getFxImage()));
                                break;
                            case '6':
                                layerObjects.add(new Grass(i, j, Sprite.grass.getFxImage()));
                                enemies.add(new Ghost(i, j, Sprite.ghost_right1.getFxImage()));
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

    public static void createMultiplayerMap() {
        level = 0;
        createMap();
    }

    /*
    Getter & Setter
     */

    public static Player getPlayer() {
        return player;
    }

    public static Player2 getPlayer2() {
        return player2;
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

    public static ArrayList<Entity> getWallOnly() {
        return wallOnly;
    }

    public static void setWallOnly(ArrayList<Entity> wallOnly) {
        Level.wallOnly = wallOnly;
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

    public static void setPlayer2(Player2 player2) {
        Level.player2 = player2;
    }

    public static void setPowerUps(ArrayList<Entity> powerUps) {
        Level.powerUps = powerUps;
    }
}
