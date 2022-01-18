package com.example.fxmlexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Start_Scene_Controller {

    @FXML
    private Button Start_Scene_Exit;

    @FXML
    private Button Start_Scene_Play;


    public void Start_to_Main(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 375, 700);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void Start_Scene_Exit(ActionEvent actionEvent) {
        System.out.println("EXIT!");
        System.exit(0);
    }
}
