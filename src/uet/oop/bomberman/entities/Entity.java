package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.boundedbox.RectBoundedBox;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected Image img;

    protected RectBoundedBox boundary;

    protected boolean isRemoved = false;



    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
        this.boundary = new RectBoundedBox(x, y, 32, 32);
    }

    public RectBoundedBox getBoundary() {
        return boundary;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
//        gc.strokeRect(this.boundary.getBoundary().getMinX(),this.boundary.getBoundary().getMinY()
//                ,this.boundary.getBoundary().getWidth(),this.boundary.getBoundary().getHeight());
    }
    public abstract void update();

    public int getX() {
        return x;
    }

    public int getXUnit() {
        return x / Sprite.SCALED_SIZE;
    }

    public int getY() {
        return y;
    }

    public int getYUnit() {
        return y / Sprite.SCALED_SIZE;
    }

    public void remove() {
        isRemoved = true;
    }

    public boolean isRemoved() {
        return isRemoved;
    }
}
