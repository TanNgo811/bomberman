package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;

public class FullExplosion extends AnimatedEntity {

    protected int radius;
    protected ArrayList<Explosion> explosions = new ArrayList<>();

    public FullExplosion(int x, int y, Image img, int radius) {
        super(x, y, img);
        this.radius = radius;

        for (int i = 1; i <= radius; i++) {
            Explosion ex = new Explosion(x, y - i, Sprite.explosion_vertical2.getFxImage(), Direction.UP);
            explosions.add(ex);
            if (ex.checkCollisions(ex.getX(), ex.getY())) break;
        }
        for (int i = 1; i <= radius; i++) {
            Explosion ex = new Explosion(x, y + i, Sprite.explosion_vertical2.getFxImage(), Direction.DOWN);
            explosions.add(ex);
            if (ex.checkCollisions(ex.getX(), ex.getY())) break;
        }
        for (int i = 1; i <= radius; i++) {
            Explosion ex = new Explosion(x - i, y, Sprite.explosion_vertical2.getFxImage(), Direction.LEFT);
            explosions.add(ex);
            if (ex.checkCollisions(ex.getX(), ex.getY())) break;
        }
        for (int i = 1; i <= radius; i++) {
            Explosion ex = new Explosion(x + i, y, Sprite.explosion_vertical2.getFxImage(), Direction.RIGHT);
            explosions.add(ex);
            if (ex.checkCollisions(ex.getX(), ex.getY())) break;
        }
    }


    public ArrayList<Explosion> getExplosions() {
        return explosions;
    }

    @Override
    public void remove() {
        this.isRemoved = true;
        explosions.forEach(Entity::remove);
    }

    @Override
    public void update() {
        if (Sandbox.player.getXUnit() == this.getXUnit() && Sandbox.player.getYUnit() == this.getYUnit())
            Sandbox.player.kill();
        for (Entity e : Sandbox.enemies) {
            if (e.getXUnit() == this.getXUnit() && e.getYUnit() == this.getYUnit())
                ((Enemy) e).kill();
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        this.img = Sprite.movingSprite(Sprite.bomb_exploded2, Sprite.bomb_exploded1, Sprite.bomb_exploded, _animate, 30).getFxImage();
        super.render(gc);
    }
}
