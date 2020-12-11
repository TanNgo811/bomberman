package uet.oop.bomberman.gui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.SoundEffect;
import uet.oop.bomberman.Start;
import uet.oop.bomberman.levels.Level;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SubmenuController implements Initializable {

    @FXML
    Label subMenuLbl;

//    @FXML
//    Button helpBtn;

    @FXML
    Button restartBtn;

    @FXML
    Button continueBtn;

    @FXML
    Button soundBtn;

    @FXML
    Button mainMenuBtn;

    final String HOVERED_BUTTON_STYLE = "-fx-background-color: white; -fx-text-fill: black;";
    final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";
    boolean state = false;
    static String status;

    Timeline timeline;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline = new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.play();
//        timeline.playFromStart();

        switch (status) {
            case "StageStart":
                subMenuLbl.setText("LEVEL " + Level.level);
                SoundEffect.stageStart.play(0.5);
                break;
            case "StageCompleted":
                SoundEffect.pass.play(0.5);
                subMenuLbl.setText("LEVEL COMPLETED");
                timeline = new Timeline(new KeyFrame(Duration.seconds(4)));
                timeline.setOnFinished(actionEvent -> {
                    status = "StageStart";
                    try {
                        setStage(actionEvent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                Level.level++;
                break;
            case "Paused":
                subMenuLbl.setText("PAUSED - Level " + Level.level);
                break;
            case "GameOver":
                subMenuLbl.setText("GAME OVER - Level" + Level.level);
                break;
            case "VictoryEnd":
                subMenuLbl.setText("!!! VICTORY !!!");
                break;
            default:
                subMenuLbl.setText("");
                break;
        }

        setStyleOnHover(restartBtn);
        setStyleOnHover(continueBtn);
        setStyleOnHover(soundBtn);
        setStyleOnHover(mainMenuBtn);
    }
//
//    public void handleHelp(ActionEvent actionEvent) throws IOException {
//        URL url = new File("src\\uet\\oop\\bomberman\\gui\\Help.fxml").toURI().toURL();
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        Parent editViewParent = loader.load(url);
//        Scene scene = new Scene(editViewParent);
//        stage.setScene(scene);
//    }

    public void handleSound(ActionEvent actionEvent) {
        if (!state) {
            SoundEffect.pauseSound();
            SoundEffect.setCanPlay(false);
            soundBtn.setText("SOUND: OFF");
            state = true;
        } else {
            SoundEffect.setCanPlay(true);
            setBackgroundMusic(status);
            soundBtn.setText("SOUND: ON");
            state = false;
        }
    }

    public void handleContinue(ActionEvent actionEvent) {

    }

    public void handleRestart(ActionEvent actionEvent) {
        BombermanGame game = new BombermanGame();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        game.start(stage);
    }

    public void handleMainMenu(ActionEvent actionEvent) throws Exception {
        Start start = new Start();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        start.start(stage);
    }

        public void setBackgroundMusic(String status) {
        if (SoundEffect.isCanPlay()) switch (status) {
            case "Paused":
                SoundEffect.playLoop(SoundEffect.subMenu);
                break;
            case "GameOver":
                SoundEffect.playLoop(SoundEffect.gameOver);
                break;
            case "VictoryEnd":
                SoundEffect.playLoop(SoundEffect.endingStage);
                break;
            default:
                SoundEffect.pauseSound();
                break;
        }
    }

    public static void setStatus(String stat) {
        status = stat;
    }


    public static void setStage(ActionEvent actionEvent) throws Exception{
        URL url = new File("src\\uet\\oop\\bomberman\\gui\\Submenu.fxml").toURI().toURL();
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent editViewParent = FXMLLoader.load(url);
        Scene scene = new Scene(editViewParent);
        stage.setScene(scene);
    }

    public void setStyleOnHover(Button btn){
        btn.setOnMouseEntered(e -> btn.setStyle(HOVERED_BUTTON_STYLE));
        btn.setOnMouseExited(e -> btn.setStyle(IDLE_BUTTON_STYLE));
    }
}
