package com.example.ella.appquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;

/**
 * Created by ella on 11/01/17.
 * This class will display the result from the quiz
 */

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get text view that will display the result
        TextView t = (TextView)findViewById(R.id.textResult);
        //this will get the score and display it to the screen
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        /*switch statement will display text depending on the case
        *each case is associated with the different scores the user can get
        * text from the strings.xml file will be displayed on the screen
         */
        switch (score){
            case 0: t.setText(R.string.score0);
                break;
            case 1: t.setText(R.string.score1);
                break;
            case 2: t.setText(R.string.score2);
                break;
            case 3: t.setText(R.string.score3);
                break;
            case 4: t.setText(R.string.score4);
                break;
            case 5: t.setText(R.string.score5);
                break;
            case 6: t.setText(R.string.score6);
                break;
            case 7: t.setText(R.string.score7);
                break;
            case 8: t.setText(R.string.score8);
                break;
            case 9: t.setText(R.string.score9);
                break;
            case 10: t.setText(R.string.score10);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //inflates the menu and adds items to the action bar if present
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}
