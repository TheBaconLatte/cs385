package com.example.kerrie_ann.groupprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button); //play button
        button2 = (Button) findViewById(R.id.button2); //how to play button

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                    Intent openGame = new Intent(MainActivity.this, gamePage1.class);
                    startActivity(openGame);
                }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent instruc = new Intent(MainActivity.this, instructions.class);
                startActivity(instruc);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
