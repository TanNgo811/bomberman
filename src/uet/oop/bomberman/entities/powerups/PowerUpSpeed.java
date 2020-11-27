package uet.oop.bomberman.entities.powerups;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;

public class PowerUpSpeed extends PowerUp {

    public PowerUpSpeed(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }

    @Override
    public void setActive() {
        //TODO: thay toc do cua Player
        super.setActive();
    }
}
