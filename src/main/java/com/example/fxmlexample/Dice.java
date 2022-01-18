package com.example.fxmlexample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

public class Dice {
    private ImageView dice_image;

    public Dice(ImageView dice_image){
        this.dice_image = dice_image;
    }

    public ImageView getDice_image() {
        return dice_image;
    }

    public int Dice_click() throws FileNotFoundException {
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                System.out.println("Thread Running");
//                try {
//                    for (int i = 0; i < 15; i++) {
//                        Random random = new Random();
//                        File file = new File("src/main/resources/com/example/fxmlexample/Dice_" + (random.nextInt(6)+1)+".png");
//                        dice_image.setImage(new Image(file.toURI().toString()));
//                        Thread.sleep(50);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();
//        Thread.sleep(1000);
        int dice_no = 0;
        while(true){
            Random random = new Random();
            dice_no = random.nextInt(7);
            if(dice_no!= 0)
                break;
        }

        System.out.print(dice_no);
        String location = "src/main/resources/com/example/fxmlexample/Dice_" + dice_no + ".png";
        File file = new File(location);
        this.getDice_image().setImage(new Image(file.toURI().toString()));
        return dice_no;
    }
}


