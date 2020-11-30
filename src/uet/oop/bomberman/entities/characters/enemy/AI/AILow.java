package uet.oop.bomberman.entities.characters.enemy.AI;

public class AILow extends AI{

    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }
}
