package uet.oop.bomberman.entities.characters.enemy.AI.aStar;

import uet.oop.bomberman.entities.characters.enemy.Enemy;
import uet.oop.bomberman.levels.Level;

public class TileMap {

    private int height, width;
    private char[][] map = new char [height][width];;
    private Enemy enemy;

    public TileMap(Enemy enemy) {
        width = Level.width;
        height = Level.height;

        this.enemy = enemy;
    }

    /**
     * Cập nhật lại bản đồ
     */
    public void update() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // bị chặn tại (x, y)
                if (!enemy.checkCollisions(x, y)) {
                    map[y][x] = '0';
                } else {
                    map[y][x] = ' ';
                }
            }
        }
//        display();
    }

    /**
     * Hiển thị bản đồ
     */
    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
    }

    /**
     * Kiểm tra điểm (x, y) có bị chặn không
     * @param x hoành độ điểm xét
     * @param y tung độ điểm xét
     * @return true nếu bị chặn và false nếu ngược lại
     */
    public boolean blocked(int x, int y) {
        if (map[y][x] == '0') {
            return true;
        }
        else
            return false;
    }

    /**
     * Lấy chiều dài bản đồ
     * @return chiều dài bản đồ
     */
    public int getWidth() {
        return width;
    }

    /**
     * Lấy chiều rộng bản đồ
     * @return chiều rộng bản đồ
     */
    public int getHeight() {
        return height;
    }

}
