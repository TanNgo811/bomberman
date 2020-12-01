package uet.oop.bomberman.entities.powerups;

import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;

public class PowerUpFlame extends PowerUp {

    public PowerUpFlame(int x, int y, Image img) {
        super( x, y, img);
        active = false;
    }

    @Override
    public void update() {
        if (active) {
            remove();
        }
    }

    @Override
    public void setActive() {
        //TODO: them radius cho bomb
        super.setActive();
    }
}