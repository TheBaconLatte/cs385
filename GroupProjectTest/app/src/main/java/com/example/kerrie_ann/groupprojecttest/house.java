package com.example.kerrie_ann.groupprojecttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class house extends AppCompatActivity {
    int attendance = 1; //keeps track of how many days student attended class
    private static int day; //keeps track of days
    Button stay, school;

    public void setDay(int m){
        this.day = m; //sets current value of day
    }

    public int getDay(){
        return this.day; //returns value of current day
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        Button stay = (Button) findViewById(R.id.stay);
        Button school = (Button) findViewById(R.id.school);
        day = getDay(); //calls the getter method to get current day
        Toast.makeText(this, "Day " + day, Toast.LENGTH_SHORT).show();

            stay.setOnClickListener(new View.OnClickListener() {
                public void onClick(View m) {
                   if (day == 2) {
                        setDay(3);
                        Intent day3 = new Intent(house.this, house.class); //restarts the class with update
                        startActivity(day3);
                    } else if (day == 3) {
                        setDay(4);
                        Intent day4 = new Intent(house.this, house.class); //restarts the class for next day
                    } else if (day == 4) {
                        setDay(5);
                        //insert code to redirect to day 5. User must attend day 5 to take test
                    }

                }
            });

            school.setOnClickListener(new View.OnClickListener() {
                public void onClick(View n) {
                    attendance++;

                    if (day == 2) {
                        Intent day2 = new Intent(house.this, gamePage2.class); //sends user to day 2
                        startActivity(day2);
                    } else if (day == 3) {
                        //insert code to lead to day 3
                    } else if (day == 4) {
                        //insert code to lead to day 4
                    }
                }
            });
        }

}
