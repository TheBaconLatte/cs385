package com.example.ella.appquiz;

/**
 * Created by ella on 11/01/17.
 * This class makes it possible to refer to a question by referring to an object
 * instead of a set of strings
 */

public class Question {
    // variable that stores unique IDs, qs, answer options and answers
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String ANSWER;

    //this function stores default values to the variables
    public Question(){
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        ANSWER = "";
    }

    /* this function takes in 5 strings that will store the question, options and answer
    * these are then mapped onto the variables declared at the start*/
    public Question(String qUESTION, String oPTA, String oPTB, String oPTC, String aNSWER){
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        ANSWER = aNSWER;
    }

    //this function returns the ID
    public int getID()
    {
        return ID;
    }

    //this function returns the question
    public String getQUESTION() {
        return QUESTION;
    }

    //this function returns optiona
    public String getOPTA() {
        return OPTA;
    }

    //this function returns optionb
    public String getOPTB() {
        return OPTB;
    }

    //this function returns optionc
    public String getOPTC() {
        return OPTC;
    }

    //this function returns answer
    public String getANSWER() {
        return ANSWER;
    }

    //this function sets id
    public void setID(int id)
    {
        ID=id;
    }

    //this function sets the question
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }

    //this function sets optiona
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }

    //this function sets optionb
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }

    //this function sets optionc
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }

    //this function sets answer
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }

}
