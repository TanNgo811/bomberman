package uet.oop.bomberman.boundedbox;

import javafx.geometry.Rectangle2D;

public class RectBoundedBox {

    int x;
    int y;
    int width;
    int height;
    Rectangle2D boundary;

    public RectBoundedBox(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        width=w;
        height=h;
        boundary = new Rectangle2D(x, y, width, height);
    }

    public Rectangle2D getBoundary() {
        return boundary;
    }

    public void setBoundary(Rectangle2D boundaryRect){
        boundary = boundaryRect;
    }

    public boolean checkCollision(RectBoundedBox b) {
        return b.getBoundary().intersects(getBoundary());
    }

    public void setPosition(int x, int y, double reductionPercent) {
        this.x = x+(int)(16 * reductionPercent);
        this.y = y+(int)(16 * reductionPercent);
        boundary = new Rectangle2D(this.x, this.y, width, height);
    }


}
