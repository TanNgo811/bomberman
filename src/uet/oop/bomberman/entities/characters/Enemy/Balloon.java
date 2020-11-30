package uet.oop.bomberman.entities.characters.Enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Enemy.AI.AILow;
import uet.oop.bomberman.graphics.Sprite;


public class Balloon  extends Enemy {



    public Balloon(int x, int y, Image img) {
        super( x, y, img);
        this._point = 100;
        this._speed = 1.5;

        _ai = new AILow();
        direction = Direction.values()[_ai.calculateDirection()];
    }

    @Override
    public void kill() {

    }

    @Override
    public boolean moveRight() {
        img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, _animate, 60).getFxImage();
        return super.moveRight();
    }

    @Override
    public boolean moveLeft() {
        img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, _animate, 60).getFxImage();
        return super.moveLeft();
    }

    @Override
    public void update() {
        super.update();
        if (direction == Direction.LEFT) {
            if (!moveLeft()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
        }
        if (direction == Direction.RIGHT) {
            if (!moveRight()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
        }
        if (direction == Direction.UP) {
            if (!moveUp()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
        }
        if (direction == Direction.DOWN) {
            if (!moveDown()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);

    }
}