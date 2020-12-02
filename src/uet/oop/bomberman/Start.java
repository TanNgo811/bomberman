package uet.oop.bomberman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Start extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        window = primaryStage;
        URL url = new File("src\\uet\\oop\\bomberman\\gui\\Main.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Test");
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(new Scene(root, 992, 416));
        primaryStage.show();

        SoundEffect.playLoop(SoundEffect.mainMenu);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
