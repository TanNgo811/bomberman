package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;

public abstract class Character extends AnimatedEntity {

    protected boolean isKilled = false;

    public Character(int x, int y, Image img) {
        super(x, y, img);
    }

    public boolean isColliding(Entity b){
        RectBoundedBox otherEntityBoundary = b.getBoundary();
        return this.boundary.checkCollision(otherEntityBoundary);
    }

    @Override
    public void update() {

    }

    public abstract void kill();

    public boolean isKilled() {
        return isKilled;
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}
