package uet.oop.bomberman.entities.characters.Enemy.AI;

public class AILow extends AI{

    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }
}
