package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Character;
import uet.oop.bomberman.entities.tiles.*;
import uet.oop.bomberman.entities.tiles.destroyable.Brick;
import uet.oop.bomberman.graphics.Sprite;

public class Explosion extends Entity {

    protected Direction direction;

    public Explosion(int x, int y, Image img, Direction direction) {
        super(x,y,img);
        this.direction = direction;
        switch (direction) {
            case UP: case DOWN:
                this.img = Sprite.explosion_vertical2.getFxImage();
                break;
            case LEFT: case RIGHT:
                this.img = Sprite.explosion_horizontal2.getFxImage();
                break;
            default:
                break;
        }
    }

    public boolean isColliding(Entity b){
        RectBoundedBox otherEntityBoundary = b.getBoundary();
        return this.boundary.checkCollision(otherEntityBoundary);
    }

    @Override
    public void update() {
        Entity mob = Sandbox.getEntity(x, y);
        Entity brick = Sandbox.getBlock(x, y);
        if (mob instanceof Character) ((Character) mob).kill();
        if (brick instanceof Brick) ((Brick) brick).destroy();
    }

    @Override
    public void render(GraphicsContext gc) {
        Entity wall = Sandbox.getBlock(x, y);
        if (wall instanceof Wall)
            this.img = null;
        super.render(gc);
    }
}
