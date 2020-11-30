package uet.oop.bomberman.entities.powerups;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;

public class PowerUpBomb extends PowerUp {

    private Player player = Sandbox.player;

    public PowerUpBomb(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {
        if (active) {
            remove();
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}