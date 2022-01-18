package com.example.fxmlexample;

import javafx.scene.effect.BlurType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Token {
    private int cur_row;
    private int cur_col;
    private ImageView Token_Image;
    private boolean start;
    private boolean turn;

    static private int winner = 0;

    public Token(ImageView Token_Image,boolean turn){
        start = false;
        this.turn = turn;
        this.Token_Image = Token_Image;
    }

    public static int getWinner() {
        return winner;
    }
    public static void setWinner(int winner) {
        Token.winner = winner;
    }

    public boolean isStart() {
        return start;
    }
    public void setStart(boolean start) {
        this.start = start;
    }


    public boolean isTurn() {
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getCur_row(){
        return cur_row;
    }
    public void setCur_row(int cur_row){
        this.cur_row = cur_row;
    }

    public int getCur_col(){
        return cur_col;
    }
    public void setCur_col(int cur_col){
        this.cur_col = cur_col;
    }

    public ImageView getToken_Image() {
        return Token_Image;
    }

    public void first_move(GridPane BoardGrid,Token cur,ImageView token_Image){
        BoardGrid.getChildren().add(token_Image);
        GridPane.setConstraints(token_Image,0,9);
        cur.setStart(true);
        cur.setCur_col(0);
        cur.setCur_row(9);
        cur.setTurn(false);
    }

    public int move(GridPane BoardGrid,Token cur,ImageView token_Image,int dice_no,Board b) throws InterruptedException {
        int row = getCur_row();
        int col = getCur_col();

        if(row == 0 && col <=5){ //CONDITION WHEN Cur_Tile+dice>100
            if(dice_no > col)
                return 2;
        }

        for(int i=0;i<dice_no;i++){
            if(row%2 != 0){
                if(col<9)
                    col++;
                else
                    row--;
            }
            else if(row%2==0){
                if(col>0)
                    col--;
                else
                    row--;
            }

            GridPane.setConstraints(token_Image,col,row);
        }

        ArrayList<ArrayList<Integer>> lst_snakes = b.getSnakes_map();
        ArrayList<ArrayList<Integer>> lst_ladder = b.getLadder_map();
        int flag_snakes = 0;
        int flag_ladder = 0;
        int j = 0;
        for(int i=0;i<lst_snakes.size();i++){
            int snake_row = lst_snakes.get(i).get(0);//head_row
            int snake_col = lst_snakes.get(i).get(1);//head_col
            if(row == snake_row && col == snake_col){
                flag_snakes = 1;
                j = i;
                break;
            }
            int ladder_row = lst_ladder.get(i).get(0);//tail_row
            int ladder_col = lst_ladder.get(i).get(1);//tail_col
            if(row == ladder_row && col == ladder_col){
                flag_ladder = 1;
                j = i;
                break;
            }
        }

        if(flag_snakes == 1){
            row = lst_snakes.get(j).get(2);//tail_row
            col = lst_snakes.get(j).get(3);//tail_col
            GridPane.setConstraints(token_Image,col,row);
        }
        if(flag_ladder == 1){
            row = lst_ladder.get(j).get(2);//head_row
            col = lst_ladder.get(j).get(3);//head_col
            GridPane.setConstraints(token_Image,col,row);
        }

        cur.setCur_col(col);
        cur.setCur_row(row);
        cur.setTurn(false);
        if(row == 0 && col == 0)
            return 1;
        return 0;
    }
}
