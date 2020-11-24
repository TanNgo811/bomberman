package uet.oop.bomberman.entities.characters;

import javafx.animation.Transition;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import uet.oop.bomberman.Renderer;
import uet.oop.bomberman.animations.PlayerAnimation;
import uet.oop.bomberman.animations.SpriteAnimation;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;


public class Player extends AnimatedEntity {

//    private final String walkRightPath = "file:res/sprites/player_right_";
    SpriteAnimation currentSprite;
    Direction currentDirection;
    Direction _direction;
    Sprite sprite;

    PlayerAnimation playerAnimations;

    ImageView img = new ImageView();

    RectBoundedBox playerBoundary;

    double reduceBoundarySizePercent=0.45;
    double scale = 1;

    public Player(int x, int y, Image img) {
        super( x, y, img);
//        sprite = Sprite.player_right;
//        positionX = x;
//        positionY = y;
//        _sprite = Sprite.player_right;
        playerBoundary = new RectBoundedBox(getX()+(int)(16*getReduceBoundarySizePercent()),
                getY()+(int)(16*getReduceBoundarySizePercent()),
                (int)(16* getScale())-2*+(int)(16*getReduceBoundarySizePercent()),
                (int)(16* getScale())-2*+(int)(16*getReduceBoundarySizePercent()));
    }

    public double getScale() {
        return scale;
    }


    public void move(Direction direction) {
        move(1, direction);
    }


    private void setCurrentSprite(SpriteAnimation s) {
//        if (s != null) {
            currentSprite = s;
//        } else {
//            System.out.println("Sprite missing!");
//        }
    }

//    private void setCurrentSprite(Sprite s) {
////        if (s != null) {
//        currentSprite = s;
////        } else {
////            System.out.println("Sprite missing!");
////        }
//    }


//    private void chooseSprite() {
//        switch (_direction) {
//            case UP:
//                sprite= Sprite.player_up;
////                if (_moving) {
//                sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
////                }
//                break;
//            case RIGHT:
//                sprite = Sprite.player_right;
////                if (_moving) {
//                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
////                }
//                break;
//            case DOWN:
//                sprite = Sprite.player_down;
////                if (_moving) {
//                sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, _animate, 20);
////                }
//                break;
//            case LEFT:
//                sprite = Sprite.player_left;
////                if (_moving) {
//                sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, _animate, 20);
////                }
//                break;
//            default:
//                sprite = Sprite.player_right;
////                if (_moving) {
//                sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, _animate, 20);
////                }
//                break;
//        }
//    }

    public void move(int step, Direction direction) {
        if (step == 0) {
//            _sprite = Sprite.player_right;
            return;
        } else {
            switch (direction) {
                case UP:
                    this.y -= step;
//                    _sprite = Sprite.movingSprite(Sprite.player_up_1, Sprite.player_up_2, _animate, 20);
//                    setCurrentSprite(playerAnimations.getMoveUpSprite());
                    currentDirection = Direction.UP;
                    break;

                case DOWN:
                    this.y += step;
//                    _sprite = Sprite.movingSprite(Sprite.player_down_1, Sprite.player_down_2, _animate, 20);
//                    setCurrentSprite(playerAnimations.getMoveDownSprite());
                    currentDirection = Direction.DOWN;
                    break;

                case RIGHT:
                    this.x += step;
//                    _sprite = Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, _animate, 20);

//                    List<Image> images = new ArrayList<>();
//
//                    images.add(Sprite.player_right.getFxImage());
//                    images.add(Sprite.player_right_1.getFxImage());
//                    images.add(Sprite.player_right_2.getFxImage());
//
//                    Transition animation = new Transition() {
//                        {
//                            setCycleDuration(Duration.millis(1000)); // total time for animation
//                        }
//
//                        @Override
//                        protected void interpolate(double fraction) {
//
//                            int index = (int) (fraction*(images.size()-1));
//                            img.setImage(images.get(index));
//
//                        }
//                    };
//                    animation.play();
//
//                    try {
//                        Thread.sleep(0);
//                    } catch (Exception e) {
//                        System.out.println(e);
//                    }
//                    setCurrentSprite(playerAnimations.getMoveRightSprite());
//                    setCurrentSprite(Sprite.movingSprite(Sprite.player_right_1, Sprite.player_right_2, 0, 20));

                    currentDirection = Direction.RIGHT;

                    break;

                case LEFT:
                    this.x -= step;
//                    _sprite = Sprite.movingSprite(Sprite.player_left_1, Sprite.player_left_2, _animate, 20);
//                    setCurrentSprite(playerAnimations.getMoveRightSprite());
                    currentDirection = Direction.LEFT;
                    break;

                default:
//                    _sprite = Sprite.player_right;
//                    setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            }
        }
    }

    @Override
    public void update() {
        animate();
    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
//        Renderer.playAnimation(currentSprite);

    }

    public double getReduceBoundarySizePercent() {
        return reduceBoundarySizePercent;
    }

}
