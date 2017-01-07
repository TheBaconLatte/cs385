package com.example.gregory.cs385;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper myDb;
    Button btn_1, btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup database
        myDb = new DatabaseHelper(this);

        // change menu colour
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FFB6C1"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        // initialise buttons
        btn_1 = (Button) findViewById(R.id.btn_1); //play button
        btn_2 = (Button) findViewById(R.id.btn_2); //how to play button

        btn_1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent openGame = new Intent(MainActivity.this, gamePage.class);
                startActivity(openGame);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }




}
