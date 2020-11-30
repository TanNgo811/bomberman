package uet.oop.bomberman.entities.characters.Enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Character;
import uet.oop.bomberman.entities.characters.Enemy.AI.AI;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Enemy extends Character {

    protected int _point;

    protected double _speed;

    protected int _steps;

    protected double MAX_STEPS;

    protected double rest;

    protected AI _ai;

    protected Direction direction;


    public Enemy(int x, int y, Image img) {
        super(x, y, img);

    }


    public boolean isColliding(Entity b){
        RectBoundedBox otherEntityBoundary = b.getBoundary();
        return this.boundary.checkCollision(otherEntityBoundary);
    }

    public boolean checkCollisions(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.blockObjects) {
            if (e != this && isColliding(e) && !e.canCollide()) {
                this.boundary.setPosition(x, y,0);

//                System.out.println("Enemy x="+getX()+" y="
//                        +getY()+" colliding with x="+e.getX()
//                        +" y="+e.getY());

                return false;
            }
        }
        return true;
    }


    public boolean moveLeft() {
//        img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60).getFxImage();
        if (checkCollisions(x - 1, y)) {
            x -= 1;
            return true;
        }
        return false;
    }

    public boolean moveRight() {
//        img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60).getFxImage();
        if (checkCollisions(x + 1, y)) {
            x += 1;
            return true;
        }
        return false;
    }

    public boolean moveUp() {
//        img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60).getFxImage();
        if (checkCollisions(x, y - 1)) {
            y -= 1;
            return true;
        }
        return false;
    }

    public boolean moveDown() {
//        img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60).getFxImage();
        if (checkCollisions(x, y + 1)) {
            y += 1;
            return true;
        }
        return false;
    }

    @Override
    public void kill() {
        img = Sprite.balloom_dead.getFxImage();
        this.isKilled = true;
        this.remove();
    }

    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public void update() {
        animate();
    }
}
