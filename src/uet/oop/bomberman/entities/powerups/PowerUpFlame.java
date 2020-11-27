package uet.oop.bomberman.entities.powerups;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;

public class PowerUpFlame extends PowerUp {

    public PowerUpFlame(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }

    @Override
    public void setActive() {
        //TODO: them radius cho bomb
        super.setActive();
    }
}