package com.example.kerrie_ann.groupprojecttest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    //set database name, table name
    private static final String DATABASE_NAME = "classQuiz";
    private static final String TABLE_QUEST = "table1";
    //set column names for table
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "oa";
    private static final String KEY_OPTB = "ob";
    private static final String KEY_OPTC = "oc";
    private SQLiteDatabase dbase;

    /*super constructor - stores the parameters into member variables
    *and checks that the version is at least 1*/
    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Method for creating the database
    @Override
    public void onCreate(SQLiteDatabase db){
        dbase = db;
        /*Create table if it doesn't already exist
        *with the table name, id, questions, answers and options
         */
        String sql = "CREATE TABLE " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        //executes String sql
        db.execSQL(sql);
        //calls function to add questions to table
        addQuestions();
    }

    /*Method for adding questions
    *stores questions, opta, optb, optc and answer
     */
    private void addQuestions(){
        Question q1=new Question("Which of these is an" +
                " incorrect array declaration?","int arr[] = new int[5]", "int arr[] = int[5]", "int[] arr = new int[5]", "int arr[] = int[5]");
        this.addQuestion(q1);
        Question q2=new Question("What will this code print? int arr[] = new int[5];" +
                "System.out.print(arr);", "Garbage value", "0", "value stored in arr[0]", "Garbage value");
        this.addQuestion(q2);
        Question q3=new Question("Which symbol represents" +
                " the modulus operator?","&", "%","+","%");
        this.addQuestion(q3);
        Question q4=new Question("Which of these assignment operators" +
                " have highest precedence?",	"*", "++", "()","()");
        this.addQuestion(q4);
        Question q5=new Question("Which of these keywords" +
                " is used to make a class?","class","struct","None of the above","class");
        this.addQuestion(q5);
        Question q6=new Question("What is stored in the object obj in the following line of code?" +
                " box obj;","Garbage", "Any arbitrary pointer", "NULL", "NULL");
        this.addQuestion(q6);
        Question q7=new Question("Which of the following is a valid declaration of an" +
                " object of class Box?", "Box obj = new Box;", "Box obj = new Box();", "new Box obj;", "Box obj = new Box();");
        this.addQuestion(q7);
        Question q8=new Question("Which of these method of String class is used to obtain character" +
                " at specified index?","char()", "charAt()","charat()","charAt()");
        this.addQuestion(q8);
        Question q9=new Question("Which of these cannot be used for" +
                " a variable name in Java?", "keyword", "identifier", "None of the above","keyword");
        this.addQuestion(q9);
        Question q10=new Question("Which symbol represents the" +
                " multiplication operator?","x","&","*","*");
        this.addQuestion(q10);
    }

    //Function is called during an upgrade of the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        onCreate(db);
    }

    //Function for adding questions to table
    private void addQuestion(Question quest){
        //inserts values into database table
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        //inserts row
        dbase.insert(TABLE_QUEST, null, values);
    }


    public List<Question> getAllQuestions(){
        //creates a list
        List<Question> quesList = new ArrayList<Question>();
        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        //opens the database
        dbase = this.getReadableDatabase();
        //runs the selectQuery and returns a cursor object
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        //looping through the rows and adding to the list
        if (cursor.moveToFirst()){
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        //returns list
        return quesList;
    }

    public int rowcount(){
        int row = 0;
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }

}
