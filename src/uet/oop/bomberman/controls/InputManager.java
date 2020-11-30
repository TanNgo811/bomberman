package uet.oop.bomberman.controls;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

import java.util.List;

public class InputManager {

    public static void handlePlayerMovements(){
        List keyboardInputs = EventHandler.getInputList();
        Player player = Level.getPlayer();
//        System.err.println(""+keyboardInputs);
        if(keyboardInputs.contains(KeyCode.UP) || keyboardInputs.contains(KeyCode.W)){
            System.out.println("Go Up");
            player.move(player.getSpeed(), Direction.UP);
        }
        if(keyboardInputs.contains(KeyCode.DOWN) || keyboardInputs.contains(KeyCode.S)){
            System.out.println("Go Down");
            player.move(player.getSpeed(),Direction.DOWN);
        }
        if(keyboardInputs.contains(KeyCode.LEFT) || keyboardInputs.contains(KeyCode.A)){
            System.out.println("Go Left");
            player.move(player.getSpeed(),Direction.LEFT);
        }
        if(keyboardInputs.contains(KeyCode.RIGHT) || keyboardInputs.contains(KeyCode.D)){
            System.out.println("Go Right");
            player.move(player.getSpeed(),Direction.RIGHT);

        }
        if (keyboardInputs.contains(KeyCode.SPACE)){
            if(player.hasBomb()) {
                player.dropBomb();
            }
        }
        if (!keyboardInputs.contains(KeyCode.LEFT) &&
                !keyboardInputs.contains(KeyCode.RIGHT) &&
                !keyboardInputs.contains(KeyCode.UP) &&
                !keyboardInputs.contains(KeyCode.DOWN) &&
                !keyboardInputs.contains(KeyCode.W) &&
                !keyboardInputs.contains(KeyCode.A) &&
                !keyboardInputs.contains(KeyCode.S) &&
                !keyboardInputs.contains(KeyCode.D)
        )
        {
            player.move(0, Direction.DOWN);
        }
    }

}
