package com.example.fxmlexample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class HelloController {

    @FXML
    private Button MainBoard_Back;

    @FXML
    private ImageView Player1_img;
    @FXML
    private ImageView Player2_img;

    @FXML
    private ImageView Blue_Token_img;
    @FXML
    private ImageView Green_Token_img;

    @FXML
    private GridPane BoardGrid;

    @FXML
    private Button dice_button;

    @FXML
    private ImageView dice_img;

    Board b = new Board();
    Dice  d;
    Token Blue = new Token(Blue_Token_img,true);
    Token Green = new Token(Green_Token_img,false);
    Token cur;
    int flag_win = 0;
    int flag_mov = 0;



    public void Dice_Click(ActionEvent actionEvent) throws IOException, InterruptedException {
        d = new Dice(dice_img);
        int dice_no = d.Dice_click();

        if(Blue.isTurn()) {
            System.out.println("Blue");
            cur = Blue;
            Green.setTurn(true);
        }
        else {
            System.out.println("Green");
            cur = Green;
            Blue.setTurn(true);
        }

        if(flag_mov == 1 && flag_win !=2){
            flag_mov = 0;
            Green_Token_img.setTranslateX((Green_Token_img.getTranslateX() -15));
        }

        if(!cur.isStart() && dice_no == 1){
            if(cur == Blue)
                cur.first_move(BoardGrid,cur,Blue_Token_img);
            else
                cur.first_move(BoardGrid,cur,Green_Token_img);
            if(Blue.getCur_row() == Green.getCur_row() && Blue.getCur_col() == Green.getCur_col()){
                Green_Token_img.setTranslateX((Green_Token_img.getTranslateX() + 15));
                flag_mov = 1;
            }
        }

        else if(cur.isStart()){
            if(cur == Blue)
                flag_win = cur.move(BoardGrid,cur,Blue_Token_img,dice_no,b);
            else
                flag_win = cur.move(BoardGrid,cur,Green_Token_img,dice_no,b);
            if(Blue.getCur_row() == Green.getCur_row() && Blue.getCur_col() == Green.getCur_col()){
                Green_Token_img.setTranslateX((Green_Token_img.getTranslateX() + 15));
                flag_mov = 1;
            }
        }
        cur.setTurn(false);
        if(cur == Blue){
            Player1_img.setOpacity(0.5);
            Player2_img.setOpacity(1);
        }
        else{
            Player1_img.setOpacity(1);
            Player2_img.setOpacity(0.5);
        }
        if(flag_win == 1){
            if(cur == Blue) {
                System.out.println("BLUE HAS WON THE GAME!");
                Token.setWinner(1);
            }
            else {
                System.out.println("GREEN HAS WON THE GAME!");
                Token.setWinner(2);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Last_Scene.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 360, 300);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void MainBoard_Back_Click(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Start-Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 330);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}

