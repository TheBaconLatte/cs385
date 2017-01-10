package com.example.kerrie_ann.groupprojecttest;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//this file will display the first page of the game
public class gamePage1 extends AppCompatActivity {
    Button next;
    int counter = 0;
    String dialogue[];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page1);
        final TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setBackgroundColor(Color.parseColor("#80585858")); //text box with transparency
        next = (Button) findViewById(R.id.next);
        loadDialogue(); //calling method that loads the dialogue
        textView.setText(dialogue[counter]);
        counter++;

        next.setOnClickListener(new View.OnClickListener(){ //button to proceed through dialogue
            public void onClick(View l){

                textView.setText(dialogue[counter]); //sets current dialogue

                if(counter < dialogue.length -1){
                    counter++; //proceeds through dialogue array
                }
                else{
                    counter=0; //resets dialogue
                }
            }

        });
    }

    public void loadDialogue(){
        Resources res = getResources();
        dialogue = res.getStringArray(R.array.page1); //loads dialogue from xml file to string array in java
    }
}
