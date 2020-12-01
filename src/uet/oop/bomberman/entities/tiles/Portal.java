package uet.oop.bomberman.entities.tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uet.oop.bomberman.entities.Entity;

public class Portal extends Entity {

    private boolean active = false;

    public Portal(int x, int y, Image img) {
        super(x, y, img);
        this.active = false;
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
}
