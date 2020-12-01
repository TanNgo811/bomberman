package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.powerups.PowerUp;
import uet.oop.bomberman.entities.powerups.PowerUpBomb;
import uet.oop.bomberman.entities.powerups.PowerUpFlame;
import uet.oop.bomberman.entities.powerups.PowerUpSpeed;
import uet.oop.bomberman.entities.tiles.Portal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

import java.util.ArrayList;



public class Player extends Character {

    Direction currentDirection;
    Direction _direction;
    Sprite sprite;
    private int lives = 1;
    public int steps;

    double reduceBoundarySizePercent=0.45;
    double scale = 1;

    protected int bombCount = 1;
    protected int powerUpsCount = 0;
    protected int bombRadius = 1;
    protected int playerSpeed = 2;

    private int deathCountDown = 15;
    private int overload = 30;
    protected boolean canDropBomb = true;

    protected ArrayList<PowerUp> powerUps = new ArrayList<>();
    protected PowerUpFlame flameItem;
    protected PowerUpBomb bombItem;
    protected PowerUpSpeed speedItem;
    protected Portal portal;

    public Player(int x, int y, Image img) {
        super( x, y, img);
        this.isKilled = false;
        this.boundary = new RectBoundedBox(x, y + 6, 20, 28);
    }


    public double getScale() {
        return scale;
    }


    public void move(Direction direction) {
        move(1, direction);
    }



    public void move(int step, Direction direction) {
        if (isKilled == false) {
            if (step == 0) {
                return;
            } else {
                switch (direction) {
                    case UP:
                        if (checkCollisions(x, y - step)) {
                            this.y -= step;
                            this.img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, _animate, 60).getFxImage();
                            currentDirection = Direction.UP;
                        }
                        break;

                    case DOWN:
                        if (checkCollisions(x, y + step)) {
                            this.y += step;
                            this.img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, _animate, 60).getFxImage();
                            currentDirection = Direction.DOWN;
                        }
                        break;

                    case RIGHT:
                        if (checkCollisions(x + step, y)) {
                            this.x += step;
                            this.img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, _animate, 60).getFxImage();


                            currentDirection = Direction.RIGHT;
                        }
                        break;

                    case LEFT:
                        if (checkCollisions(x - step, y)) {
                            this.x -= step;
                            this.img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, _animate, 60).getFxImage();
                            currentDirection = Direction.LEFT;
                        }
                        break;

                    default:
                        this.img = Sprite.player_right.getFxImage();

                }
            }
        } else {
                dieImg();
        }
    }

    public void dieImg() {
        if (deathCountDown == 0) {
            this.img = null;
         } else {
            this.img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, _animate, 60).getFxImage();
            deathCountDown--;
        }
    }

    public boolean isColliding(Entity b){
        RectBoundedBox otherEntityBoundary = b.getBoundary();
        return this.boundary.checkCollision(otherEntityBoundary);
    }

    public boolean checkCollisions(int _x, int _y){
        this.boundary.setPosition(_x, _y, 0);
        for (Entity e : Sandbox.blockObjects) {
            if (e != this && isColliding(e)) {
                this.boundary.setPosition(x, y, 0);

//                Debug
//                System.out.println("Player x=" + getX() + " y="
//                        + getY() + " colliding with x=" + e.getX()
//                        + " y=" + e.getY());

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
        for (Entity e : Sandbox.bombs) {
            if (isColliding(e) && !(e instanceof Bomb) ) {
                this.boundary.setPosition(x, y, 0);
                return false;
            }
        }
        return true;
    }

    public boolean checkCollisionsWithPowerUpFlame(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.powerUps) {
            if (e instanceof PowerUpFlame) {
                if (isColliding(e)) {
                    flameItem = (PowerUpFlame) e;
                    this.boundary.setPosition(x, y, 0);
                    ((PowerUpFlame) e).setActive();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCollisionsWithPowerUpBomb(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.powerUps) {
            if (e instanceof PowerUpBomb) {
                if (isColliding(e)) {
                    bombItem = (PowerUpBomb) e;
                    this.boundary.setPosition(x, y, 0);
                    ((PowerUpBomb) e).setActive();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCollisionsWithPowerUpSpeed(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.powerUps) {
            if (e instanceof PowerUpSpeed) {
                if (isColliding(e)) {
                    speedItem = (PowerUpSpeed) e;
                    this.boundary.setPosition(x, y, 0);
                    ((PowerUpSpeed) e).setActive();
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCollisionsWithPortal(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.layerObjects) {
            if (e instanceof Portal) {
                if (isColliding(e)) {
                    portal = (Portal) e;
                    this.boundary.setPosition(x, y, 0);
                    ((Portal) e).setActive();
                    return false;
                }
            }
        }
        return true;
    }


    public boolean hasBomb() {
        return (bombCount > 0);
    }

    public boolean canDropBomb() {
        return canDropBomb;
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
        Bomb bombPlaced = new Bomb(this.getXUnit(), this.getYUnit(), Sprite.bomb.getFxImage());
        Sandbox.addBomb(bombPlaced);
        System.out.println("Drop Bomb");
        bombCount--;
        canDropBomb = false;
    }

    @Override
    public void kill() {
        isKilled = true;
    }

    @Override
    public void update() {
        animate();
        if (!checkCollisionsWithEnemy(x, y)) {
            this.kill();
        }
        if (isKilled) {
            remove();
        }
        if (!canDropBomb && !isKilled)
            if (overload > 0)
                overload--;
            else {
                canDropBomb = true;
                overload = 30;
            }
    }

    @Override
    public void render (GraphicsContext gc){
        super.render(gc);
        gc.strokeRect(this.boundary.getBoundary().getMinX(), this.boundary.getBoundary().getMinY()
                , this.boundary.getBoundary().getWidth(), this.boundary.getBoundary().getHeight());
    }

    public double getReduceBoundarySizePercent() {
        return reduceBoundarySizePercent;
    }

}
