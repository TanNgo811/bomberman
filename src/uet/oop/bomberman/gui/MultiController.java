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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MultiController implements Initializable {
    final String HOVERED_BUTTON_STYLE = "-fx-background-color: white; -fx-text-fill: black;";
    final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;";

    @FXML
    Button backBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStyleOnHover(backBtn);
    }

    public void setStyleOnHover(Button btn){
        btn.setOnMouseEntered(e -> {btn.setStyle(HOVERED_BUTTON_STYLE);});
        btn.setOnMouseExited(e -> {btn.setStyle(IDLE_BUTTON_STYLE);});
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        URL url = new File("src\\uet\\oop\\bomberman\\gui\\Main.fxml").toURI().toURL();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent editViewParent = loader.load(url);
        Scene scene = new Scene(editViewParent);
        stage.setScene(scene);
    }
}
