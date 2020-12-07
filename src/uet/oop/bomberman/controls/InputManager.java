package uet.oop.bomberman.controls;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.entities.characters.Player2;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level;

import java.util.List;

public class InputManager {

    public static void handlePlayerMovements(){
        List keyboardInputs = EventHandler.getInputList();
        Player player = Level.getPlayer();
        Player2 player2 = Level.getPlayer2();
//        System.err.println(""+keyboardInputs);
//        if(keyboardInputs.contains(KeyCode.UP) || keyboardInputs.contains(KeyCode.W)){
////            System.out.println("Go Up");
//            player.move(player.getSpeed(), Direction.UP);
//        }
//        if(keyboardInputs.contains(KeyCode.DOWN) || keyboardInputs.contains(KeyCode.S)){
////            System.out.println("Go Down");
//            player.move(player.getSpeed(),Direction.DOWN);
//        }
//        if(keyboardInputs.contains(KeyCode.LEFT) || keyboardInputs.contains(KeyCode.A)){
////            System.out.println("Go Left");
//            player.move(player.getSpeed(),Direction.LEFT);
//        }
//        if(keyboardInputs.contains(KeyCode.RIGHT) || keyboardInputs.contains(KeyCode.D)){
////            System.out.println("Go Right");
//            player.move(player.getSpeed(),Direction.RIGHT);
//
//        }

        /*
        Player 1 Movement
        * */
        if(keyboardInputs.contains(KeyCode.W)){
            player.move(player.getSpeed(), Direction.UP);
        }
        if(keyboardInputs.contains(KeyCode.S)){
            player.move(player.getSpeed(),Direction.DOWN);
        }
        if(keyboardInputs.contains(KeyCode.A)){
            player.move(player.getSpeed(),Direction.LEFT);
        }
        if(keyboardInputs.contains(KeyCode.D)){
            player.move(player.getSpeed(),Direction.RIGHT);

        }

        /*
        Player 2 Movement
        * */
        if(keyboardInputs.contains(KeyCode.UP)){
            player2.move(player2.getSpeed(), Direction.UP);
        }
        if(keyboardInputs.contains(KeyCode.DOWN)){
            player2.move(player2.getSpeed(),Direction.DOWN);
        }
        if(keyboardInputs.contains(KeyCode.LEFT)){
            player2.move(player2.getSpeed(),Direction.LEFT);
        }
        if(keyboardInputs.contains(KeyCode.RIGHT)){
            player2.move(player2.getSpeed(),Direction.RIGHT);

        }

        /*
        * Player 1  Drop Bomb
        * */
        if (keyboardInputs.contains(KeyCode.SPACE)){
            if(player.hasBomb() && player.canDropBomb()) {
                player.dropBomb();
            }
        }

        /*
         * Player 2  Drop Bomb
         * */
        if (keyboardInputs.contains(KeyCode.SHIFT)){
            if(player2.hasBomb() && player2.canDropBomb()) {
                player2.dropBomb();
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
            player2.move(0, Direction.DOWN);
        }
    }

}
