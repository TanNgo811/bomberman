package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

public class Bomb extends AnimatedEntity {

    final Player player = Level.getPlayer() ;

    protected int timeDropped = 120;
    protected int timeExploded = 30;
    protected boolean isExploded;

    protected FullExplosion explosions;

    public Bomb(int x, int y, Image img){
        super(x, y, img);
        this.canCollide = false;
        this.isExploded = false;
        System.out.println(x + " " + y);
    }

    public void explode() {
        isExploded = true;
        System.out.println("Boom!");
        explosions = new FullExplosion(this.getXUnit(), this.getYUnit(), Sprite.bomb_exploded2.getFxImage(), player.getRadius());
        for (Entity e : explosions.getExplosions()) {
            Sandbox.addEntity(e);
        }
        player.addBomb();
    }

    @Override
    public void update() {
        if (timeDropped > 0) {
            timeDropped--;
        }
        else if (!isExploded) explode();
        else {
            explosions.update();

            if (timeExploded > 0)
                timeExploded--;
            else {
                remove();
                explosions.remove();
            }
        }

        animate();
    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isExploded) {
            this.img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 120).getFxImage();
        } else {
            this.img = Sprite.bomb_exploded2.getFxImage();
        }
        super.render(gc);
    }
}
