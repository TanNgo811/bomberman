package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.AnimatedEntity;

public abstract class Character extends AnimatedEntity {

    protected boolean _alive = true;

    public Character(int x, int y, Image img) {
        super(x, y, img);
    }

    public abstract void kill();

    public boolean isAlive() {
        return _alive;
    }


}
