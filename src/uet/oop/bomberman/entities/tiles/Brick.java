package uet.oop.bomberman.entities.tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
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
            remove();
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        if (isDestroyed()) {
            this.img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, 0, 20).getFxImage();
        }
        super.render(gc);
    }
}