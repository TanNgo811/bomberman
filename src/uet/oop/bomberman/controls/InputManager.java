package uet.oop.bomberman.controls;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.entities.characters.Player2;
import uet.oop.bomberman.gui.MainController;
import uet.oop.bomberman.levels.Level;

import java.util.List;

public class InputManager {

    public static void handlePlayerMovements(){
        List keyboardInputs = EventHandler.getInputList();
        Player player = Level.getPlayer();
        Player2 player2 = Level.getPlayer2();
        if (!MainController.isMultiMode()) {
//            System.err.println(""+keyboardInputs);
            if(keyboardInputs.contains(KeyCode.UP) || keyboardInputs.contains(KeyCode.W)){
    //            System.out.println("Go Up");
                player.move(player.getSpeed(), Direction.UP);
            }
            if(keyboardInputs.contains(KeyCode.DOWN) || keyboardInputs.contains(KeyCode.S)){
    //            System.out.println("Go Down");
                player.move(player.getSpeed(),Direction.DOWN);
            }
            if(keyboardInputs.contains(KeyCode.LEFT) || keyboardInputs.contains(KeyCode.A)){
    //            System.out.println("Go Left");
                player.move(player.getSpeed(),Direction.LEFT);
            }
            if(keyboardInputs.contains(KeyCode.RIGHT) || keyboardInputs.contains(KeyCode.D)){
    //            System.out.println("Go Right");
                player.move(player.getSpeed(),Direction.RIGHT);
            }
            if (keyboardInputs.contains(KeyCode.SPACE)){
                if(player.hasBomb() && player.canDropBomb()) {
                    player.dropBomb();
                }
            }
        } else {
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
            if(keyboardInputs.contains(KeyCode.D)) {
                player.move(player.getSpeed(), Direction.RIGHT);
            }
            if (keyboardInputs.contains(KeyCode.SPACE)) {
                if (player.hasBomb() && player.canDropBomb()) {
                    player.dropBomb();
                }
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
            if(keyboardInputs.contains(KeyCode.RIGHT)) {
                player2.move(player2.getSpeed(), Direction.RIGHT);
            }
            if (keyboardInputs.contains(KeyCode.SHIFT)){
                if(player2.hasBomb() && player2.canDropBomb()) {
                    player2.dropBomb();
                }
            }
        }
    }

}
