package uet.oop.bomberman.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.SoundEffect;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    Button helpBtn;

    @FXML
    Button singleBtn;

    @FXML
    Button multiBtn;

    @FXML
    Button soundBtn;

    final String HOVERED_BUTTON_STYLE = "-fx-background-color: white; -fx-text-fill: black;";
    final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
    boolean state = false;

    public static boolean multiMode = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        setStyleOnHover(helpBtn);
        setStyleOnHover(singleBtn);
        setStyleOnHover(multiBtn);
        setStyleOnHover(soundBtn);
    }

    public void setStyleOnHover(Button btn){
        btn.setOnMouseEntered(e -> {btn.setStyle(HOVERED_BUTTON_STYLE);});
        btn.setOnMouseExited(e -> {btn.setStyle(IDLE_BUTTON_STYLE);});
    }

    public void handleSingle(ActionEvent actionEvent){
        BombermanGame game = new BombermanGame();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        game.start(stage);
    }

    public void handleHelp(ActionEvent actionEvent) throws IOException {
        URL url = new File("src\\uet\\oop\\bomberman\\gui\\Help.fxml").toURI().toURL();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent editViewParent = loader.load(url);
        Scene scene = new Scene(editViewParent);
        stage.setScene(scene);
    }

    public void handleMulti(ActionEvent actionEvent) throws IOException {
        URL url = new File("src\\uet\\oop\\bomberman\\gui\\Multi.fxml").toURI().toURL();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent editViewParent = loader.load(url);
        Scene scene = new Scene(editViewParent);
        stage.setScene(scene);
        setMultiMode(true);
    }

    public void handleSound(ActionEvent actionEvent) {

        if (!state) {
            SoundEffect.pauseSound();
            SoundEffect.setCanPlay(false);
            soundBtn.setText("SOUND: OFF");
            state = true;
        } else {
            SoundEffect.playLoop(SoundEffect.mainMenu);
            SoundEffect.setCanPlay(true);
            soundBtn.setText("SOUND: ON");
            state = false;
        }

    }

    public static boolean isMultiMode() {
        return multiMode;
    }

    public void setMultiMode(boolean multiMode) {
        this.multiMode = multiMode;
    }
}
