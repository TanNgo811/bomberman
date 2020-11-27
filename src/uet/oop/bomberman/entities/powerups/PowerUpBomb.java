package uet.oop.bomberman.entities.powerups;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;

public class PowerUpBomb extends PowerUp {

    public PowerUpBomb(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }

    @Override
    public void setActive() {
        //TODO: Khi setActive thi +1 vao bombRate (dat nhieu hon 1 qua)
        super.setActive();
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }
}