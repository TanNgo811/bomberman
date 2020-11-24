package uet.oop.bomberman.animations;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import uet.oop.bomberman.Renderer;
import uet.oop.bomberman.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class PlayerAnimation {

    SpriteAnimation moveRight;
    SpriteAnimation moveLeft;
    SpriteAnimation moveUp;
    SpriteAnimation moveDown;
    SpriteAnimation idle;
    SpriteAnimation die;
    double playSpeed;
    public PlayerAnimation(Entity e, int scale) {
        Image img = Renderer.getSpiteSheet();
        playSpeed=0.1;
        moveDown  = new SpriteAnimation(e, 30, 0.1, 0,  0, 3, 16, 16, scale, false);
        moveLeft  = new SpriteAnimation(e, 30, 0.1, 30, 0, 3, 16, 16, scale, false);
        moveUp    = new SpriteAnimation(e, 30, 0.1, 60, 0, 3, 16, 16, scale, false);
        moveRight = new SpriteAnimation(e, 30, 0.1, 90, 0, 3, 16, 16, scale, false);
        idle      = new SpriteAnimation(e, 30, 0.1,118, 0, 1, 16, 16, scale, false);

        List<Rectangle> specs=new ArrayList<>();
        specs.add(new Rectangle(149, 0,20,21));
        specs.add(new Rectangle(179, 1,19,20));
        specs.add(new Rectangle(118, 30,21,21));
        specs.add(new Rectangle(149, 30,20,21));
        specs.add(new Rectangle(179, 30,19,21));
        specs.add(new Rectangle(118, 60,21,21));
        specs.add(new Rectangle(147, 60,23,22));
        die = new SpriteAnimation(e,30,playSpeed,img, specs,16, 16, scale, false);
    }

    public SpriteAnimation getMoveRightSprite() {
        return moveRight;
    }

    public SpriteAnimation getMoveLeftSprite() {
        return moveLeft;
    }

    public SpriteAnimation getMoveUpSprite() {
        return moveUp;
    }

    public SpriteAnimation getMoveDownSprite() {
        return moveDown;
    }
    public SpriteAnimation getPlayerIdleSprite(){
        return idle;
    }
    public SpriteAnimation getPlayerDying(){
        return die;
    }

}
