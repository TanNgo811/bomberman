package uet.oop.bomberman.entities.powerups;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class PowerUp extends Entity {

    public PowerUp(int x, int y, Image img) {
        super( x, y, img);
    }

    protected boolean active = false;

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
