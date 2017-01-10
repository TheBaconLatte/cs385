package com.example.kerrie_ann.groupprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//this class will display the instructions page of the game
public class instructions extends AppCompatActivity {
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Button play = (Button) findViewById(R.id.play);

        play.setOnClickListener(new View.OnClickListener(){
            public void onClick(View z){
                Intent play = new Intent(instructions.this, gamePage1.class);
                startActivity(play);

            }
        });
    }
}
