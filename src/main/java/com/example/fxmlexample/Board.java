package com.example.fxmlexample;

import java.util.ArrayList;

public class Board {
    private ArrayList<ArrayList<Integer>> Snakes_map;
    private ArrayList<ArrayList<Integer>> Ladder_map;

    public Board() {
        Snakes_Initialize();
        Ladders_Initialize();
    }

    public void Snakes_Initialize(){//Key:Head, Value:Tail
//        int[] a = new int[]{23,32,46,51,59,66,81,92,95,98};
//        int[] b = new int[]{5,9,25,11,40,56,62,48,54,65};
        Snakes_map = new ArrayList<>();
        int[] head_row = new int[]{7,6,5,4,4,3,1,0,0,0};
        int[] head_col = new int[]{2,8,5,9,1,5,0,8,5,2};
        int[] tail_row = new int[]{9,9,7,8,6,4,3,5,4,3};
        int[] tail_col = new int[]{4,8,4,9,0,4,1,7,6,4};
        for(int i=0;i<10;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(head_row[i]);
            temp.add(head_col[i]);
            temp.add(tail_row[i]);
            temp.add(tail_col[i]);
            Snakes_map.add(temp);
        }
    }

    public void Ladders_Initialize(){//Key:tail, Value:head
//        int[] a = new int[]{2,6,8,16,24,38,63,70,73,85};
//        int[] b = new int[]{21,27,33,34,64,58,82,91,94,97};
        Ladder_map = new ArrayList<>();
        int[] tail_row = new int[]{9,9,9,8,7,6,3,3,2,1};
        int[] tail_col = new int[]{1,5,7,4,3,2,2,9,7,4};
        int[] head_row = new int[]{7,7,6,6,3,4,1,0,0,0};
        int[] head_col = new int[]{0,6,7,6,3,2,1,9,6,3};
        for(int i=0;i<10;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(tail_row[i]);
            temp.add(tail_col[i]);
            temp.add(head_row[i]);
            temp.add(head_col[i]);
            Ladder_map.add(temp);
        }
    }


//    public int tile_to_row(int tile_no){
//        int row = 0;
//        if(tile_no>=1 && tile_no<=10)
//            row = 9;
//        else if(tile_no>=11 && tile_no<=20)
//            row = 8;
//        else if(tile_no>=21 && tile_no<=30)
//            row = 7;
//        else if(tile_no>=31 && tile_no<=40)
//            row = 6;
//        else if(tile_no>=41 && tile_no<=50)
//            row = 5;
//        else if(tile_no>=51 && tile_no<=60)
//            row = 4;
//        else if(tile_no>=61 && tile_no<=70)
//            row = 3;
//        else if(tile_no>=71 && tile_no<=80)
//            row = 2;
//        else if(tile_no>=81 && tile_no<=90)
//            row = 1;
//        return row;
//    }

    public ArrayList<ArrayList<Integer>> getSnakes_map() {
        return Snakes_map;
    }
    public ArrayList<ArrayList<Integer>> getLadder_map() {
        return Ladder_map;
    }
}
