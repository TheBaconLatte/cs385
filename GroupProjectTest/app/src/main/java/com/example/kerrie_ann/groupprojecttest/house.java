package com.example.kerrie_ann.groupprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*Note for the poor soul who reads this next:
I originally had the choose() method separate, but it made the app crash, so I moved it within onCreate and commented it out.
The app no longer crashes when accessing house.java, but the value day isn't updating so I have a feeling something is going wrong with the getters and setters.
The getters and setters were originally in Main Activity, but I moved them here to see if it would make a difference.
Spoiler alert: It doesn't.
The day variable is first updated using setDay in gamePage1 btw when the dialogue is finished.
Because the days aren't updating, the user can't get to day two, so the buttons are useless.
Also I wanted to put choose() outside onCreate so I could recursively call it for the user to choose what to do again the next day.
 */

public class house extends AppCompatActivity {
    int attendance = 1; //keeps track of how many days student attended class
    private int day; //keeps track of days
    Button stay, school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        Button stay = (Button) findViewById(R.id.stay);
        Button school = (Button) findViewById(R.id.school);
        day = getDay(); //calls the getter method to get current day
        Toast.makeText(this, "Day " + day, Toast.LENGTH_SHORT).show();
        //choose(day);

        //private void choose() {
            /*x = day;
            final MainActivity y = new MainActivity();*/

            stay.setOnClickListener(new View.OnClickListener() {
                public void onClick(View m) {
                   /* if (x == 2) {
                        y.setDay(3);
                        x = y.getDay();
                        choose(x);
                    } else if (x == 3) {
                        y.setDay(4);
                        x = y.getDay();
                        choose(x);
                    } else if (x == 4) {
                        y.setDay(5);
                        //insert code to redirect to day 5. User must attend day 5 to take test
                    }*/

                }
            });

            school.setOnClickListener(new View.OnClickListener() {
                public void onClick(View n) {
                    attendance++;
                    if (day == 2) {
                        Intent day2 = new Intent(house.this, gamePage2.class);
                        startActivity(day2);
                    } else if (day == 3) {
                        //insert code to lead to day 3
                    } else if (day == 4) {
                        //insert code to lead to day 4
                    }
                }
            });
        }
   // }


    public int getDay(){
        return this.day; //returns value of current day
    }

    public void setDay(int m){
        this.day = m; //sets current value of day
    }


}
