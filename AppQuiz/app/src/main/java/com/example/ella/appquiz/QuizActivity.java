package com.example.ella.appquiz;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ella on 11/01/17.
 * This class takes the questions from the database and displays them
 */

public class QuizActivity extends AppCompatActivity {
    List<Question> quesList;
    //variables that store score and counter for questions
    int score = 0;
    int qid = 0;
    //refers to Question class
    Question currentQ;
    //stores question in a textview, options in radiobuttons and next button
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button nextQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        DbHelper db = new DbHelper(this);
        //calls getAllQuestions function
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        //maps question to textview, options to radio buttons
        txtQuestion = (TextView)findViewById(R.id.textView1);
        rda = (RadioButton)findViewById(R.id.radio0);
        rdb = (RadioButton)findViewById(R.id.radio1);
        rdc = (RadioButton)findViewById(R.id.radio2);
        nextQ = (Button)findViewById(R.id.button1);
        //Calls function that sets the questions and options to above variables
        setQuestionView();

        /*once the next button is clicked, the player's score is noted
        *score is incremented if you get the correct answer
        *Intent is used to communicate between QuizActivity and ResultActivity
        *If all questions have been answered, ResultActivity will display results
         */
        nextQ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("youranswer ", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().equals(answer.getText())){
                    score++;
                    Log.d("score ", "Your score " + score);
                } if (qid < 10){
                    currentQ = quesList.get(qid);
                    setQuestionView();
                }else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score);
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //this inflates the menu and adds items to the action bar if present
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

    /*sets the questions and options to appear on screen
    *qid increments so that the next question is displayed
    */
    private void setQuestionView(){
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
}
