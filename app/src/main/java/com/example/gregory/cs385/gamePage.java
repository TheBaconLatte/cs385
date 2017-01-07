package com.example.gregory.cs385;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by gregory on 06/01/2017.
 */

public class gamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);

        // change menu colour
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FFB6C1"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

//        TextView textView = (TextView) findViewById(R.id.textView3);
//        textView.setBackgroundColor(Color.parseColor("#80585858")); //text box
    }
}
