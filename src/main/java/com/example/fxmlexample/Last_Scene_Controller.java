package com.example.fxmlexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Last_Scene_Controller implements Initializable {


    @FXML
    private Label win_label;

    @FXML
    private Label lose_label;

    @FXML
    private Button LastScene_Menu_Button;

    @FXML
    private Button LastScene_Replay_Button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int winner = Token.getWinner();
        if(winner == 1){
            win_label.setTextFill(Color.BLUE);
            lose_label.setTextFill(Color.GREEN);
        }
        else{
            win_label.setText("PlAYER2");
            win_label.setTextFill(Color.GREEN);
            lose_label.setText("PLAYER1");
            lose_label.setTextFill(Color.BLUE);
        }
    }

    public void LastScene_Menu_Click(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Start-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 330);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void LastScene_ReplayClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 375, 700);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
