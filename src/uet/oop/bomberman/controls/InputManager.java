package uet.oop.bomberman.controls;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.Sandbox;
import uet.oop.bomberman.entities.Direction;
import uet.oop.bomberman.entities.characters.Player;
import uet.oop.bomberman.levels.Level;

import java.util.List;

public class InputManager {

    public static void handlePlayerMovements(){
        List keyboardInputs = EventHandler.getInputList();
        Player player = Level.getPlayer();
//        System.err.println(""+keyboardInputs);
        if(keyboardInputs.contains(KeyCode.UP) || keyboardInputs.contains(KeyCode.W)){
            System.out.println("Go Up");
            player.move(5, Direction.UP);
        }
        if(keyboardInputs.contains(KeyCode.DOWN) || keyboardInputs.contains(KeyCode.S)){
            System.out.println("Go Down");
            player.move(5,Direction.DOWN);
        }
        if(keyboardInputs.contains(KeyCode.LEFT) || keyboardInputs.contains(KeyCode.A)){
            System.out.println("Go Left");
            player.move(5,Direction.LEFT);
        }
        if(keyboardInputs.contains(KeyCode.RIGHT) || keyboardInputs.contains(KeyCode.D)){
            System.out.println("Go Right");
            player.move(5,Direction.RIGHT);
        }
        if( !keyboardInputs.contains(KeyCode.LEFT) &&
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

        //Drop bomb
//        if(keyboardInputs.contains(KeyCode.SPACE)){
//            if(player.hasMoreBombs()) {
//                Sandbox.addEntityToGame(new BlackBomb(player.getPositionX()+ GlobalConstants.PLAYER_WIDTH/2, player.getPositionY()+GlobalConstants.PLAYER_HEIGHT/2));
//                player.decrementBombCount();
//            }
//        }
    }

}
