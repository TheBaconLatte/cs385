package com.example.CS385.MultimediaSquad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    //set database name, table name
    private static final String DATABASE_NAME = "Quiz";
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
        Question q1=new Question("Which is not" +
                " a primitive data type?","int", "char", "array", "array");
        this.addQuestion(q1);
        Question q2=new Question("Which is a suitable" +
                " variable name?", "myDouble", "double", "my double", "myDouble");
        this.addQuestion(q2);
        Question q3=new Question("If x=5 and y=8," +
                " which is correct?","x==y", "x!=y","x>=y","x!=y");
        this.addQuestion(q3);
        Question q4=new Question("Which of these is the" +
                " modulus operator?",	"*", ":", "%","%");
        this.addQuestion(q4);
        Question q5=new Question("What is the correct way to print true if" +
                " var equals 10?","if(var=10) System.out.print(true);","if(var==10) System.out.print(true);", "if var==10; System.out.print(true);", "if(var==10) System.out.print(true);");
        this.addQuestion(q5);
        Question q6=new Question("How many x's will print in the following code?" +
                " \nfor(i=0; i<10; i++)","9", "10", "11", "10");
        this.addQuestion(q6);
        Question q7=new Question("Which of these is the" +
                " assignment operator?", "=", "==", "!=", "=");
        this.addQuestion(q7);
        Question q8=new Question("Which of these does NOT" +
                " represent a decimal?","double", "boolean","float","boolean");
        this.addQuestion(q8);
        Question q9=new Question("What does OOP stand" +
                " for?", "Object Organised Programs", "Object Oriented Programming", "Object Ordered Programming","Object Oriented Programming");
        this.addQuestion(q9);
        Question q10=new Question("What does every command in" +
                " Java end with?",";",":","{",";");
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
