package uet.oop.bomberman.entities.bomb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.SoundEffect;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.entities.characters.Player2;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

public class Bomb extends AnimatedEntity {

    final Player player = Level.getPlayer() ;
    final Player2 player2 = Level.getPlayer2() ;


    protected int timeDropped = 120;
    protected int timeExploded = 30;
    protected boolean isExploded;
    protected String playerDrop;

    protected FullExplosion explosions;

    public Bomb(int x, int y, Image img){
        super(x, y, img);
        this.isExploded = false;
        this.playerDrop = "";
        System.out.println(x + " " + y);
    }

    public void explode() {
        isExploded = true;
        System.out.println("Boom!");
        if (SoundEffect.isCanPlay()) {
            SoundEffect.bombExplode.play(0.5);
        }
        explosions = new FullExplosion(this.getXUnit(), this.getYUnit(), Sprite.bomb_exploded2.getFxImage(), player.getRadius());
        Sandbox.addBomb(explosions);
        for (Entity e : explosions.getExplosions()) {
            Sandbox.addBomb(e);
        }
        switch (playerDrop) {
            case "Player":
                player.addBomb();
                break;
            case "Player2":
                player2.addBomb();
                break;
            default:
                break;
        }
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

    public String getPlayerDrop() {
        return playerDrop;
    }

    public void setPlayerDrop(String playerDrop) {
        this.playerDrop = playerDrop;
    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isExploded) {
            this.img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60).getFxImage();
        } else {
            this.img = null;
        }
        super.render(gc);
    }
}
