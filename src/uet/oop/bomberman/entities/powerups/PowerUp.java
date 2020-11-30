package uet.oop.bomberman.entities.powerups;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class PowerUp extends Entity {

    protected boolean active = false;

    public PowerUp(int x, int y, Image img) {
        super( x, y, img);
        this.active = false;
    }

    public boolean isColliding(Entity b){
        RectBoundedBox otherEntityBoundary = b.getBoundary();
        return this.boundary.checkCollision(otherEntityBoundary);
    }


    public boolean isActive() {
        return active;
    }

    public void setActive() {
        this.active = true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }


}
