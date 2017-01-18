package com.example.CS385.MultimediaSquad;

import android.content.Intent;
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
        textView.setText(dialogue[counter]); //begins on the first element of array
        counter++;
        house d = new house(); //creates instance of house class
        d.setDay(2); //sets day to 2

        next.setOnClickListener(new View.OnClickListener(){ //button to proceed through dialogue
            public void onClick(View l){

                if(counter < dialogue.length){
                    textView.setText(dialogue[counter]); //sets current dialogue
                    counter++; //proceeds through dialogue array
                }
                else{
                    Intent home = new Intent(gamePage1.this, house.class); //when dialogue is finished, button brings user to next page
                    startActivity(home);
                }
            }

        });

    }

    public void loadDialogue(){
        Resources res = getResources();
        dialogue = res.getStringArray(R.array.page1); //loads dialogue from xml file to string array in java
    }
}
