package uet.oop.bomberman.entities.characters.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.characters.Character;
import uet.oop.bomberman.entities.characters.enemy.AI.AI;

public abstract class Enemy extends Character {

    protected int _point;
    protected int _speed;
    protected int _steps;
    protected double MAX_STEPS;
    protected double rest;
    protected AI _ai;
    protected Direction direction;

    protected int deathCountDown = 75;

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
            if (isColliding(e)) {
                this.boundary.setPosition(x, y,0);
                return false;
            }
        }
        for (Entity e : Sandbox.bombs) {
            if (e instanceof Bomb && isColliding(e)) {
                this.boundary.setPosition(x, y,0);
                return false;
            }
        }
        return true;
    }

    public boolean moveLeft() {
        if (checkCollisions(x - _speed, y)) {
            x -= _speed;
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (checkCollisions(x + _speed, y)) {
            x += _speed;
            return true;
        }
        return false;
    }

    public boolean moveUp() {
        if (checkCollisions(x, y - _speed)) {
            y -= _speed;
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        if (checkCollisions(x, y + _speed)) {
            y += _speed;
            return true;
        }
        return false;
    }

    @Override
    public void kill() {
        this.isKilled = true;
    }

    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public void update() {
        animate();
    }
}
