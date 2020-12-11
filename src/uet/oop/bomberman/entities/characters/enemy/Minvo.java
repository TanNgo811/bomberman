package uet.oop.bomberman.entities.characters.enemy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.characters.enemy.AI.AILow;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class Minvo extends Enemy{
    public Minvo(int x, int y, Image img) {
        super(x, y, img);

        this._speed = 1;
        _ai = new AILow();
        direction = Direction.values()[_ai.calculateDirection()];

    }

    public boolean changemob = false;
    public int changedmodcountdown = 50;
    public int generateCreepsCountDown = 200;
    Random e = new Random();

    @Override
    public void kill() {
        super.kill();
        this._speed = 0;
    }

    @Override
    public boolean moveRight() {
        img = Sprite.movingSprite(Sprite.minvo_right1, Sprite.minvo_right2, Sprite.minvo_right3, _animate, 60).getFxImage();
        return super.moveRight();
    }

    @Override
    public boolean moveLeft() {
        img = Sprite.movingSprite(Sprite.minvo_left1, Sprite.minvo_left2, Sprite.minvo_left3, _animate, 60).getFxImage();
        return super.moveLeft();
    }

    public void generateCreeps() {
        int type = e.nextInt(5);
        System.out.println(type);
        switch (type) {
            case 1:
                Kondoria k = new Kondoria(this.getXUnit(), this.getYUnit(), Sprite.kondoria_left1.getFxImage());
                Sandbox.enemies.add(k);
                break;
            case 2:
                Oneal o = new Oneal(this.getXUnit(), this.getYUnit(), Sprite.oneal_left1.getFxImage());
                Sandbox.enemies.add(o);
                break;
            case 3:
                Doll d = new Doll(this.getXUnit(), this.getYUnit(), Sprite.doll_left1.getFxImage());
                Sandbox.enemies.add(d);
                break;
            case 4:
                Balloon b = new Balloon(this.getXUnit(), this.getYUnit(), Sprite.balloom_right1.getFxImage());
                Sandbox.enemies.add(b);
                break;
            case 0:
                Ghost g = new Ghost(this.getXUnit(), this.getYUnit(), Sprite.ghost_left1.getFxImage());
                Sandbox.enemies.add(g);
            default:
                break;
        }
    }

    @Override
    public void update() {
        super.update();
        if (direction == Direction.LEFT) {
            if (!moveLeft()) {
//                generateCreeps();
                direction = Direction.values()[_ai.calculateDirection()];
            }
//            moveLeft();
        }
        if (direction == Direction.RIGHT) {
            if (!moveRight()) {
//                generateCreeps();
                direction = Direction.values()[_ai.calculateDirection()];
            }
//            moveRight();
        }
        if (direction == Direction.UP) {
            if (!moveUp()) {
//                generateCreeps();
                direction = Direction.values()[_ai.calculateDirection()];
            }
//            moveUp();
        }
        if (direction == Direction.DOWN) {
            if (!moveDown()) {
//                generateCreeps();
                direction = Direction.values()[_ai.calculateDirection()];
            }
//            moveDown();
        }
        if (generateCreepsCountDown > 0) generateCreepsCountDown--;
        else {
            generateCreeps();
            generateCreepsCountDown = 200;
        }

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
    }
}
