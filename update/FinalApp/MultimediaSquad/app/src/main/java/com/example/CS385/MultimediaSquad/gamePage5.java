package com.example.CS385.MultimediaSquad;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gamePage5 extends AppCompatActivity {
    Button next;
    String dialogue[];
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page5);

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
                else{ //LEADS TO QUIZ
                    Intent startQuiz = new Intent(gamePage5.this, QuizActivity.class); //when dialogue is finished, button brings user to next page
                    startActivity(startQuiz);
                }
            }

        });
    }

    public void loadDialogue(){
        Resources res = getResources();
        dialogue = res.getStringArray(R.array.page5); //loads dialogue from xml file to string array in java
    }
}
