package com.example.kerrie_ann.groupprojecttest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button, button2;
    MediaPlayer my_mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button); //play button
        button2 = (Button) findViewById(R.id.button2); //how to play button

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                    Intent openGame = new Intent(MainActivity.this, gamePage1.class);
                    startActivity(openGame); //opens the first page of the game
                }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent instruc = new Intent(MainActivity.this, instructions.class);
                startActivity(instruc); //opens instructions page
            }
        });

        my_mediaPlayer = MediaPlayer.create(this, R.raw.nms_theme);
        my_mediaPlayer.start();

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(10200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        my_mediaPlayer.release();
        finish();
    }
    @Override
    public void onClick(View view) {

    }
}
