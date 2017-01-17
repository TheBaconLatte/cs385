package com.example.kerrie_ann.groupprojecttest;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gamePage4 extends AppCompatActivity {
    Button next;
    String dialogue[];
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page4);

        final TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setBackgroundColor(Color.parseColor("#80585858")); //text box with transparency
        next = (Button) findViewById(R.id.next);
        loadDialogue(); //calling method that loads the dialogue
        textView.setText(dialogue[counter]); //begins on the first element of array
        counter++;

        next.setOnClickListener(new View.OnClickListener(){ //button to proceed through dialogue
            public void onClick(View l){

                if(counter < dialogue.length){
                    textView.setText(dialogue[counter]); //sets current dialogue
                    counter++; //proceeds through dialogue array
                }
                else{
                    house d = new house(); //creates instance of main class
                    d.setDay(5); //sets day to 5 once dialogue is finished
                    Intent home = new Intent(gamePage4.this, house.class); //when dialogue is finished, button brings user to next page
                    startActivity(home);
                }
            }

        });
    }

    public void loadDialogue(){
        Resources res = getResources();
        dialogue = res.getStringArray(R.array.page4); //loads dialogue from xml file to string array in java
    }
}
