package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.tiles.Brick;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;

public class FullExplosion extends Entity {

    protected int radius = 1;
    protected ArrayList<Explosion> explosions = new ArrayList<>();

    public FullExplosion(int x, int y, Image img, int radius) {
        super(x,y,img);
        this.radius = radius;
        for (int i = 1; i <= radius; i++) {
            explosions.add(new Explosion(x, y - i, Sprite.explosion_vertical2.getFxImage(), Direction.UP));
            explosions.add(new Explosion(x, y + i, Sprite.explosion_vertical2.getFxImage(), Direction.DOWN));
            explosions.add(new Explosion(x - i, y, Sprite.explosion_horizontal2.getFxImage(), Direction.LEFT));
            explosions.add(new Explosion(x + i, y, Sprite.explosion_horizontal2.getFxImage(), Direction.RIGHT));
        }
    }

    public ArrayList<Explosion> getExplosions() {
        return explosions;
    }

    @Override
    public void remove() {
        explosions.forEach(Entity::remove);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}
