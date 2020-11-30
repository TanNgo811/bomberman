package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.powerups.PowerUp;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

import java.util.ArrayList;

import static uet.oop.bomberman.Sandbox.getBlock;

public class Player extends Character {

    Direction currentDirection;
    Direction _direction;
    Sprite sprite;
    private int lives = 1;
    public int steps;
    public boolean _alive = false;

    double reduceBoundarySizePercent=0.45;
    double scale = 1;

    protected int bombCount = 1;
    protected int powerUpsCount = 0;
    protected int bombRadius = 2;
    protected int playerSpeed = 2;
    protected ArrayList<PowerUp> powerUps = new ArrayList<>();

    public Player(int x, int y, Image img) {
        super( x, y, img);
        this._alive = true;
        this.boundary = new RectBoundedBox(x+6, y+6, 20, 26);
    }


    public double getScale() {
        return scale;
    }


    public void move(Direction direction) {
        move(1, direction);
    }



    public void move(int step, Direction direction) {
//        if (_alive == true) {
            if (step == 0) {
                return;
            } else {
                switch (direction) {
                    case UP:
                        if (checkCollisions(x, y - step)) {
                            this.y -= step;
                            this.img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, _animate, 20).getFxImage();
                            currentDirection = Direction.UP;
                        }
                        break;

                    case DOWN:
                        if (checkCollisions(x, y + step)) {
                            this.y += step;
                            this.img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, _animate, 20).getFxImage();
                            currentDirection = Direction.DOWN;
                        }
                        break;

                    case RIGHT:
                        if (checkCollisions(x + step, y)) {
                            this.x += step;
                            this.img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, _animate, 20).getFxImage();

//                    List<Image> images = new ArrayList<>();

                            currentDirection = Direction.RIGHT;
                        }
                        break;

                    case LEFT:
                        if (checkCollisions(x - step, y)) {
                            this.x -= step;
                            this.img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, _animate, 20).getFxImage();
                            currentDirection = Direction.LEFT;
                        }
                        break;

                    default:
                        this.img = Sprite.player_right.getFxImage();

                }
//            } else{
//            dieImg();
            }
//
    }
//
//
//
//    public void dieImg() {
//
//        this.img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, _animate, 80).getFxImage();
//
//
////        for (Entity i : Sandbox.entities) {
////            if (i instanceof Player) {
////                Sandbox.entities.remove(i);
////            }
////        }
//
//        }

        public boolean isColliding(Entity b){
            RectBoundedBox otherEntityBoundary = b.getBoundary();
            return this.boundary.checkCollision(otherEntityBoundary);
        }

        public boolean checkCollisions(int _x, int _y){
            this.boundary.setPosition(_x, _y, 0);
            for (Entity e : Sandbox.blockObjects) {
                if (e != this && isColliding(e) && !e.canCollide()) {
                    this.boundary.setPosition(x, y, 0);

                    System.out.println("Player x=" + getX() + " y="
                            + getY() + " colliding with x=" + e.getX()
                            + " y=" + e.getY());

                    return false;
                }
            }
            return true;
        }

    public boolean checkCollisionsWithEnemy(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.enemies) {
            if (e != this && isColliding(e)) {
                this.boundary.setPosition(x, y, 0);
                return false;
            }
        }
        return true;
    }


        public boolean hasBomb() {
            return (bombCount > 0);
        }

        public void addBomb() {
            bombCount++;
        }
        public void setSpeed(int playerSpeed){
            this.playerSpeed = playerSpeed;
        }

        public int getSpeed() {
            return playerSpeed;
        }

        public void setBombRadius(int bombRadius){
            this.bombRadius = bombRadius;
        }

        public int getRadius() {
            return bombRadius;
        }

        public void dropBomb() {
            Entity bombPlaced = new Bomb(this.getXUnit(), this.getYUnit(), Sprite.bomb.getFxImage());
            Sandbox.addEntity(bombPlaced);
            System.out.println("Drop Bomb");
            bombCount--;
        }

        @Override
        public void kill() {
            isKilled = true;
            System.out.println("killed");
            remove();
        }

        @Override
        public void update() {
            animate();
            if (!checkCollisionsWithEnemy(x, y)) {
                this._alive = false;
            }

        }

        @Override
        public void render (GraphicsContext gc){
            if (isKilled)
                this.img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, _animate, 60).getFxImage();
            super.render(gc);
            gc.strokeRect(this.boundary.getBoundary().getMinX(), this.boundary.getBoundary().getMinY()
                    , this.boundary.getBoundary().getWidth(), this.boundary.getBoundary().getHeight());
        }

        public double getReduceBoundarySizePercent() {
            return reduceBoundarySizePercent;
        }

    }
