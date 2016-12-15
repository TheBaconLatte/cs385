package ie.nuim.cs.u170619.myquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by u170619 on 15/12/2016.
 */
public class ResultActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = (TextView)findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");

        textResult.setText("Your score is " + " " + score + ". Thanks for playing my game.");

    }

    public void playagain(View o){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

}
