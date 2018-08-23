package com.example.kerrie_ann.groupprojecttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        house d = new house(); //creates instance of house class
        int attendance = d.getAttendance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get text view that will display the result
        TextView t1 = (TextView)findViewById(R.id.textResult);
        TextView t2 = (TextView)findViewById(R.id.textAttendance);
        TextView t3 = (TextView)findViewById(R.id.textReference);
        //this will get the score and display it to the screen
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        /*switch statement will display text depending on the case
        *each case is associated with the different scores the user can get
        * text from the strings.xml file will be displayed on the screen
         */

        switch (attendance) {
            case 0:
                t2.setText("error");
                break;
            case 1:
                t2.setText(R.string.attend1);
                break;
            case 2:
                t2.setText(R.string.attend2);
                break;
            case 3:
                t2.setText(R.string.attend3);
                break;
            case 4:
                t2.setText(R.string.attend4);
                break;
            case 5:
                t2.setText("error");
        }

        switch (score) {
            case 0: t1.setText(R.string.score0);
                break;
            case 1: t1.setText(R.string.score1);
                break;
            case 2: t1.setText(R.string.score2);
                break;
            case 3: t1.setText(R.string.score3);
                break;
            case 4: t1.setText(R.string.score4);
                break;
            case 5: t1.setText(R.string.score5);
                break;
            case 6: t1.setText(R.string.score6);
                break;
            case 7: t1.setText(R.string.score7);
                break;
            case 8: t1.setText(R.string.score8);
                break;
            case 9: t1.setText(R.string.score9);
                break;
            case 10: t1.setText(R.string.score10);
        }

        //calculate reference using score and attendance - hooo boy, this'll be fun :(
        if(score<4){ //if failed
            if(attendance<4)
                t3.setText(R.string.ref1);
            else
                t3.setText(R.string.ref2);
        }
        else if(score<7) {
            if(attendance<4)
                t3.setText(R.string.ref3);
            else
                t3.setText(R.string.ref6);
        }
        else if(score<10) {
            if(attendance<4)
                t3.setText(R.string.ref4);
            else
                t3.setText(R.string.ref7);
        }
        else {
            if (attendance < 4)
                t3.setText(R.string.ref5);
            else
                t3.setText(R.string.ref7);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflates the menu and adds items to the action bar if present
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}
