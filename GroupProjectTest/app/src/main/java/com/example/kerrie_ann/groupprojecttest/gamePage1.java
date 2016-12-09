package com.example.kerrie_ann.groupprojecttest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

//this file will display the first page of the game
public class gamePage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page1);
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setBackgroundColor(Color.parseColor("#80585858")); //text box
    }
}
