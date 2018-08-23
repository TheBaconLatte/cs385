package com.example.CS385.MultimediaSquad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class house extends AppCompatActivity {
    private static int attendance; //keeps track of how many days student attended class
    private static int day; //keeps track of days
    Button stay, school;

    public void setDay(int m){
        this.day = m; //sets current value of day
    }
    public int getDay(){
        return this.day; //returns value of current day
    }

    public void setAttendance(int l) {this.attendance = l;}
    public int getAttendance() {return this.attendance;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        Button stay = (Button) findViewById(R.id.stay);
        Button school = (Button) findViewById(R.id.school);
        Button notes = (Button) findViewById(R.id.notes);
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
                        Intent day4 = new Intent(house.this, house.class);
                        startActivity(day4); //restarts the class for next day
                    } else if (day == 4) {
                        setDay(5);
                        Intent day5 = new Intent(house.this, house.class);
                        startActivity(day5);
                    } else if (day == 5){
                       Toast.makeText(getApplicationContext(), "Skip the last day and miss the test? I can't do that or I'll never get my reference!", Toast.LENGTH_LONG).show();
                    }

                }
            });

            school.setOnClickListener(new View.OnClickListener() {
                public void onClick(View n) {
                    setAttendance(attendance+1);

                    if (day == 2) {
                        Intent day2 = new Intent(house.this, gamePage2.class); //sends user to day 2
                        startActivity(day2);
                    } else if (day == 3) {
                        Intent day3 = new Intent(house.this, gamePage3.class); //sends user to day 3
                        startActivity(day3);
                    } else if (day == 4) {
                        Intent day4 = new Intent(house.this, gamePage4.class); //sends user to day 4
                        startActivity(day4);
                    } else if (day == 5) {
                        Intent day5 = new Intent(house.this, gamePage5.class); //sends user to day 3
                        startActivity(day5);
                    }
                }
            });

            notes.setOnClickListener(new View.OnClickListener(){
                public void onClick(View o){
                    Intent checkNotes = new Intent(house.this, notes.class);
                    startActivity(checkNotes);
                }
            });
        }

}
