package ie.nuim.cs.u170619.myquiz;

import android.app.Activity;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.Menu;

import java.security.PublicKey;

/**
 * Created by u170619 on 13/12/2016.
 */
public class Question extends Activity {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;

    private String ANSWER;

    public Question(){
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";

        ANSWER = "";
    }

    public Question(String question, String opta, String optb, String optc, String answer){
            QUESTION = question;
            OPTA = opta;
            OPTB = optb;
            OPTC = optc;

            ANSWER = answer;
    }

    public int getID(){
        return ID;
    }

    public String getQUESTION(){
        return QUESTION;
    }

    public String getOPTA(){
        return OPTA;
    }

    public String getOPTB(){
        return OPTB;
    }

    public String getOPTC(){
        return OPTC;
    }

    public String getANSWER(){
        return ANSWER;
    }

    public void setID(int id){
        ID = id;
    }

    public void setQUESTION(String question){
        QUESTION = question;
    }

    public void setOPTA(String opta){
        OPTA = opta;
    }

    public void setOPTB(String optb){
        OPTB = optb;
    }

    public void setOPTC(String optc){
        OPTC = optc;
    }

    public void setANSWER(String answer){
        ANSWER = answer;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
