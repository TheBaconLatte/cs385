package com.example.CS385.MultimediaSquad;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//this class allows access to notes taken so far - accessible through home at end of day
public class notes extends AppCompatActivity {

    house d = new house(); //creates instance of house class
    int day = d.getDay();
    int counter = 0;
    String notes[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Button back = (Button) findViewById(R.id.back);
        Button prev = (Button) findViewById(R.id.prev);
        Button next = (Button) findViewById(R.id.next);
        final TextView textView2 = (TextView) findViewById(R.id.textView2);
        loadNotes();
        textView2.setText(notes[counter]);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter>0) {
                    counter--;
                    textView2.setText(notes[counter]);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(day) {
                    case 2: { //up to pos5 - first 6 slots are notes from day1
                        if(counter<5) {
                            counter++;
                            textView2.setText(notes[counter]);
                        }
                        break;
                    }
                    case 3: { //up to pos11 - display notes from day1 and day2
                        if(counter<11) {
                            counter++;
                            textView2.setText(notes[counter]);
                        }
                        break;
                    }
                    case 4: { //up to pos17
                        if(counter<17) {
                            counter++;
                            textView2.setText(notes[counter]);
                        }
                        break;
                    }
                    case 5: { //all notes displayed
                        if(counter<notes.length-1) {
                            counter++;
                            textView2.setText(notes[counter]);
                        }
                        break;
                    }
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(notes.this, house.class);
                startActivity(back);
            }
        });
    }

    public void loadNotes() {
        Resources res = getResources();
        notes = res.getStringArray(R.array.notes);
    }
}