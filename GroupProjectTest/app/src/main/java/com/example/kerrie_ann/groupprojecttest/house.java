package com.example.kerrie_ann.groupprojecttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class house extends AppCompatActivity {
    int attendance=1; //keeps track of how many days student attended class
    Button stay, school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        Button stay = (Button) findViewById(R.id.stay);
        Button school = (Button) findViewById(R.id.school);

        stay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View m){
                //insert code here to redirect user to next day
            }
        });

        school.setOnClickListener(new View.OnClickListener(){
            public void onClick(View n){
                attendance++;
                //insert code here to redirect to next day
            }
        });
    }
}
