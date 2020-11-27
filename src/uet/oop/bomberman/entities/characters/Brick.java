package uet.oop.bomberman.entities.characters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {

    protected boolean destroyed = false;

    public Brick(int x, int y, Image img) {
        super( x, y, img);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {

        this.destroyed = true;
    }

    @Override
    public void update() {
        if (isDestroyed()) {
            Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, 0,30);
            remove();
        }
    }
}