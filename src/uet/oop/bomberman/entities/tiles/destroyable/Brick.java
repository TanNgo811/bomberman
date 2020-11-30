package uet.oop.bomberman.entities.tiles.destroyable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends AnimatedEntity {

    protected boolean destroyed = false;
    private int deathCountDown = 30;

    public Brick(int x, int y, Image img) {
        super( x, y, img);
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public void collapsingImg() {
        if (deathCountDown > 0) {
            this.img = Sprite.movingSprite(Sprite.brick_exploded2, Sprite.brick_exploded1, Sprite.brick_exploded, _animate, 120).getFxImage();
            deathCountDown--;
        } else {
            this.img = null;
            remove();
        }
    }


    @Override
    public void update() {
        if (isDestroyed()) {
            collapsingImg();
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}