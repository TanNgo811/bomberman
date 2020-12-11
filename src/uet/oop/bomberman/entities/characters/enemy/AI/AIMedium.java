package uet.oop.bomberman.entities.characters.enemy.AI;

import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.characters.enemy.AI.aStar.AStarPathFinder;
import uet.oop.bomberman.entities.characters.enemy.AI.aStar.TileMap;
import uet.oop.bomberman.entities.characters.enemy.Enemy;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.entities.characters.enemy.Oneal;
import uet.oop.bomberman.levels.Level;

public class AIMedium extends AI{

    Player _player;
    Enemy _enemy;


    public AIMedium(Player player, Enemy enemy) {
        _player = player;
        _enemy = enemy;
    }



    @Override
    public int calculateDirection() {
        if(_player == null)
            return random.nextInt(4);

        int vertical = random.nextInt(2);

        if(vertical == 1) {
            int v = calculateRowDirection();
            if(v != -1) {
//                System.out.println(Direction.values()[v]);
                return v;
            }
            else {
//                System.out.println(Direction.values()[calculateColDirection()]);
                return calculateColDirection();
            }

        } else {
            int h = calculateColDirection();

            if(h != -1) {
//                System.out.println(Direction.values()[h]);
                return h;
            }
            else {
//                System.out.println(Direction.values()[calculateRowDirection()]);
                return calculateRowDirection();
            }

        }
    }

    protected int calculateColDirection() {
        if(_player.getX() < _enemy.getX())
            return 3;
        else if(_player.getX() > _enemy.getX())
            return 1;

        return -1;
    }

    protected int calculateRowDirection() {
        if(_player.getY() < _enemy.getY())
            return 0;
        else if(_player.getY() > _enemy.getY())
            return 2;
        return -1;
    }

}
