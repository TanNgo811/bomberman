package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.enemy.Enemy;
import uet.oop.bomberman.entities.tiles.destroyable.Brick;
import uet.oop.bomberman.graphics.Sprite;

public class Explosion extends AnimatedEntity {

    protected Direction direction;

    public Explosion(int x, int y, Image img, Direction direction) {
        super(x,y,img);
        this.direction = direction;
    }

    public boolean isColliding(Entity b){
        if (b != null) {
            RectBoundedBox otherEntityBoundary = b.getBoundary();
            return this.boundary.checkCollision(otherEntityBoundary);
        }
        return false;
    }

    public boolean checkCollisions(int _x, int _y){
        this.boundary.setPosition(_x, _y, 0);
        for (Entity e : Sandbox.blockObjects) {
            if (isColliding(e)) {
                this.boundary.setPosition(x, y, 0);
                return true;
            }
        }
        return false;
    }


    @Override
    public void update() {
        if (Sandbox.player.getXUnit() == this.getXUnit() && Sandbox.player.getYUnit() == this.getYUnit())
            Sandbox.player.kill();
        for (Entity e : Sandbox.enemies) {
            if (e.getXUnit() == this.getXUnit() && e.getYUnit() == this.getYUnit())
                ((Enemy) e).kill();
        }
        for (Entity e : Sandbox.blockObjects) {
            if (e.getXUnit() == this.getXUnit() && e.getYUnit() == this.getYUnit() && e instanceof Brick)
                ((Brick) e).destroy();
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        switch (direction) {
            case UP: case DOWN:
                this.img = Sprite.movingSprite(Sprite.explosion_vertical2, Sprite.explosion_vertical1, Sprite.explosion_vertical, _animate, 30).getFxImage();
//                this.img = Sprite.explosion_vertical2.getFxImage();
                break;
            case LEFT: case RIGHT:
                this.img = Sprite.movingSprite(Sprite.explosion_horizontal2, Sprite.explosion_horizontal1, Sprite.explosion_horizontal, _animate, 30).getFxImage();
//                this.img = Sprite.explosion_horizontal2.getFxImage();
                break;
            default:
                break;
        }
        super.render(gc);
    }
}
