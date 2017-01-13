package com.example.gregory.cs385;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by gregory on 06/01/2017.
 */

public class gamePage extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);
        db = new DatabaseHelper(this);

        Button choice_1 = (Button)findViewById(R.id.choice_1);

        Cursor res = db.getAllData();

        StringBuffer buffer  = new StringBuffer();
        while (res.moveToNext()) {
            choice_1.setText(res.getString(0));
        }


        // change menu colour
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FFB6C1"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


    }

    public void onClickChoice_1(View view) {
        Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show();
    }

    public void onClickChoice_2(View view) {
        Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show();
    }

    public void onClickChoice_3(View view) {
        Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
    }
}
