package com.example.gregory.cs385;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHelper db;

    Button btn_1, btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        // questions
        db.insertData("What memory size is the largest?", "100 bytes", "1 kilobyte", "1 terabyte", "1 terabyte");
        db.insertData("What does CPU stand for?", "Central Processing Unit", "Core Processor Unit", "Centre Power Utility", "Central Processing Unit");
        db.insertData("Which is a programming language?", "Black Mamba", "Anaconda", "Python", "Python");
        db.insertData("Which is the most popular OS?", "Windows", "Mac OSX", "Linux", "Windows");
        db.insertData("What does a Control Panel do?", "Controls your computer", "For fun", "Change settings", "Controls your computer");
        db.insertData("Which is the most popular search engine?", "Bing", "Google", "Yahoo", "Google");
        db.insertData("What do you use to click things?", "Mouse", "Keyboard", "RAM", "Mouse");
        db.insertData("What do you use to go online?", "Modem", "Mouse", "USB cable", "Modem");
        db.insertData("DNS refers to?", "Domain Name Server", "Disk Numbering System", "Digital Network Service", "Domain Name Server");
        db.insertData("What does WWW stand for?", "World Wide Web", "Weird Weather Warning", "Web Wide World", "World Wide Web");

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
