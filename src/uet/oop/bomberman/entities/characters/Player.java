package uet.oop.bomberman.entities.characters;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.GameLoop;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;


public class Player extends AnimatedEntity {


    Direction currentDirection;
    Direction _direction;
    Sprite sprite;

//    RectBoundedBox playerBoundary;

    double reduceBoundarySizePercent=0.45;
    double scale = 1;
    public Player(int x, int y, Image img) {
        super( x, y, img);

        this.boundary = new RectBoundedBox(x+6, y+6, 20, 26);
    }

//    @Override
//    public void kill() {
//
//    }

    public double getScale() {
        return scale;
    }


    public void move(Direction direction) {
        move(1, direction);
    }




    public void move(int step, Direction direction) {
        if (step == 0) {
//            _sprite = Sprite.player_right;
            return;
        } else {
            switch (direction) {
                case UP:
                    if(checkCollisions(x, y - step)) {
                        this.y -= step;
                        this.img = Sprite.movingSprite(Sprite.player_right, Sprite.player_up_1, Sprite.player_up_2, _animate, 20).getFxImage();
                        currentDirection = Direction.UP;
                    }
                    break;

                case DOWN:
                    if(checkCollisions(x, y + step)) {
                        this.y += step;
                        this.img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, _animate, 20).getFxImage();
                        currentDirection = Direction.DOWN;
                    }
                    break;

                case RIGHT:
                    if(checkCollisions(x + step, y)) {
                        this.x += step;
                        this.img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, _animate, 20).getFxImage();

//                    List<Image> images = new ArrayList<>();

                        currentDirection = Direction.RIGHT;
                    }
                    break;

                case LEFT:
                    if(checkCollisions(x - step, y)) {
                        this.x -= step;
                        this.img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, _animate, 20).getFxImage();
//                    setCurrentSprite(playerAnimations.getMoveRightSprite());
                        currentDirection = Direction.LEFT;
                    }
                    break;

                default:
                    this.img = Sprite.player_right.getFxImage();
//                    setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            }
        }
//        System.out.println("Player: x="+x+" y="+y+" bw="+this.boundary.getBoundary().getWidth()+" bh="+this.boundary.getBoundary().getHeight());
    }

    public boolean isColliding(Entity b){
        RectBoundedBox otherEntityBoundary = b.getBoundary();
        return this.boundary.checkCollision(otherEntityBoundary);
    }

    public boolean checkCollisions(int _x, int _y) {
        this.boundary.setPosition(_x, _y,0);
        for (Entity e : Sandbox.blockObjects) {
            if (e != this && isColliding(e) && !e.canCollide()) {
                this.boundary.setPosition(x, y,0);

                System.out.println("Player x="+getX()+" y="
                        +getY()+" colliding with x="+e.getX()
                        +" y="+e.getY());

                return false;
            }
        }
//        this.boundary.setPosition(x, y,0);
//        System.out.println("no colliding");
        return true;
    }


    @Override
    public void update() {
        animate();
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    public double getReduceBoundarySizePercent() {
        return reduceBoundarySizePercent;
    }

}
