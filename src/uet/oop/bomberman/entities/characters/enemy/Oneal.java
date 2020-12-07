package uet.oop.bomberman.entities.characters.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.entities.characters.enemy.AI.AIMedium;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

public class Oneal  extends Enemy {

    Player player = Level.getPlayer();
    public Oneal(int x, int y, Image img) {
        super( x, y, img);
        this._speed = 3;
        _ai = new AIMedium(player, this);
        direction = Direction.values()[_ai.calculateDirection()];
        this.boundary = new RectBoundedBox(x + 6, y + 6, 26, 26);
    }

    @Override
    public void kill() {
        super.kill();
        this._speed = 0;
    }


    @Override
    public boolean moveRight() {
        img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60).getFxImage();
        return super.moveRight();
    }

    @Override
    public boolean moveLeft() {
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60).getFxImage();
        return super.moveLeft();
    }

    @Override
    public boolean moveUp() {
        img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, _animate, 60).getFxImage();
        return super.moveUp();
    }

    @Override
    public boolean moveDown() {
        img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, _animate, 60).getFxImage();
        return super.moveDown();
    }

    @Override
    public void update() {
        super.update();
        if (direction == Direction.LEFT) {
            if (!moveLeft()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
            moveLeft();
        }
        if (direction == Direction.RIGHT) {
            if (!moveRight()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
            moveRight();
        }
        if (direction == Direction.UP) {
            if (!moveUp()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
            moveUp();
        }
        if (direction == Direction.DOWN) {
            if (!moveDown()) {
                direction = Direction.values()[_ai.calculateDirection()];
            }
            moveDown();
        }

        this.direction = Direction.values()[_ai.calculateDirection()];

//        DEBUG
//        System.out.println("PLayer pos " + player.getX() + " " + player.getY());



    }

    @Override
    public void render(GraphicsContext gc) {
        if (isKilled) {
            if (deathCountDown > 0) {
                this.img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, _animate, 20).getFxImage();
                deathCountDown--;
            } else {
                this.img = null;
                remove();
            }
        }
        super.render(gc);
//        gc.strokeRect(this.boundary.getBoundary().getMinX(),this.boundary.getBoundary().getMinY()
//                ,this.boundary.getBoundary().getWidth(),this.boundary.getBoundary().getHeight());

    }

}