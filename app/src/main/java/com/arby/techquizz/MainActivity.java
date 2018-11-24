package com.arby.techquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import static com.arby.techquizz.R.id.radio1;

public class MainActivity extends AppCompatActivity {
    /**
     * The String global variables are used to point out the wrong answers.
     */
    int answers;
    String a1 = "";
    String a2 = "";
    String a3 = "";
    String a4 = "";
    String a5 = "";
    String a6 = "";
    String a7 = "";
    String a8 = "";

    /**
    * The onCreate method is also in charge with setting the logo in the Action Bar.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.title);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    /**
     * This is the method initialized when the user submits the answers. It checks the answers,
     * modify the global Strings to remember the wrong answers' number and, based on the results,
     * it shows a specific Toast message for each situation: all answers are right, only one wrong
     * answer, more than one wrong answer, no right answer. After each call, at the end,
     * the method will reinitialize the global variables.
     */
    public void submit(View view) {
        if(answer1())
            answers++;
        else {
            a1 = " 1;";
        }
        if(answer2())
            answers++;
        else {
            a2 = " 2;";
        }
        if(answer3())
            answers++;
        else {
            a3 = " 3;";
        }
        if(answer4())
            answers++;
        else {
            a4 = " 4;";
        }
        if(answer5())
            answers++;
        else {
            a5 = " 5;";
        }
        if(answer6())
            answers++;
        else {
            a6 = " 6;";
        }
        if(answer7())
            answers++;
        else {
            a7 = " 7;";
        }
        if(answer8())
            answers++;
        else {
            a8 = " 8;";
        }
        double score = answers * 12.5;
        EditText userName = (EditText) findViewById(R.id.user_name);
        String name = userName.getText().toString();
        String result = getString(R.string.result);
        String percentage = getString(R.string.percentage);
        String noOfAnswers = String.valueOf(score);
        String congrats = getString(R.string.congrats);
        String all = getString(R.string.all);
        String recheck = getString(R.string.recheck);
        if((answers > 0) && (answers <7)) {
            String message = getString(R.string.problems) + a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8;
            Toast.makeText(this, name + result + " " + noOfAnswers + percentage + "\n" + message, Toast.LENGTH_LONG).show();
        } else if(answers == 8){
            Toast.makeText(this, congrats + " " + name + result + " " + noOfAnswers + percentage + "\n" + all, Toast.LENGTH_SHORT).show();
        } else if(answers == 7) {
            String message1 = getString(R.string.problems1) + a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8;
            Toast.makeText(this, name + result + " " + noOfAnswers + percentage + "\n" + message1, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, name + result + " " + noOfAnswers + percentage + "\n" + recheck, Toast.LENGTH_SHORT).show();
        }
        answers = 0;
        a1 = "";
        a2 = "";
        a3 = "";
        a4 = "";
        a5 = "";
        a6 = "";
        a7 = "";
        a8 = "";
    }

    /**
     * These are the methods which check each RadioGroup.
     */
    public boolean answer1() {
        RadioGroup radio = (RadioGroup) findViewById(radio1);
        int checkedRadioButtonId = radio.getCheckedRadioButtonId();
        int correctRadioButtonId = R.id.q1a3;
        return (checkedRadioButtonId == correctRadioButtonId);
    }

    public boolean answer2() {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radio2);
        int checkedRadioButtonId = radio.getCheckedRadioButtonId();
        int correctRadioButtonId = R.id.q2a2;
        return (checkedRadioButtonId == correctRadioButtonId);
    }

    public boolean answer3() {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radio3);
        int checkedRadioButtonId = radio.getCheckedRadioButtonId();
        int correctRadioButtonId = R.id.q3a3;
        return (checkedRadioButtonId == correctRadioButtonId);
    }

    public boolean answer5() {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radio5);
        int checkedRadioButtonId = radio.getCheckedRadioButtonId();
        int correctRadioButtonId = R.id.q5a2;
        return (checkedRadioButtonId == correctRadioButtonId);
    }

    /**
     * These are the methods which check each multiple answer question.
     */
    public boolean answer4() {
        CheckBox answerq4a1 = (CheckBox) findViewById(R.id.q4a1);
        CheckBox answerq4a2 = (CheckBox) findViewById(R.id.q4a2);
        CheckBox answerq4a3 = (CheckBox) findViewById(R.id.q4a3);
        CheckBox answerq4a4 = (CheckBox) findViewById(R.id.q4a4);
        boolean q4a1 = answerq4a1.isChecked();
        boolean q4a2 = answerq4a2.isChecked();
        boolean q4a3 = answerq4a3.isChecked();
        boolean q4a4 = answerq4a4.isChecked();
        if((q4a1 && q4a3)&&(!(q4a2 || q4a4)))
            return true;
        else return false;
    }

    public boolean answer6() {
        CheckBox answerq6a1 = (CheckBox) findViewById(R.id.q6a1);
        CheckBox answerq6a2 = (CheckBox) findViewById(R.id.q6a2);
        CheckBox answerq6a3 = (CheckBox) findViewById(R.id.q6a3);
        CheckBox answerq6a4 = (CheckBox) findViewById(R.id.q6a4);
        boolean q6a1 = answerq6a1.isChecked();
        boolean q6a2 = answerq6a2.isChecked();
        boolean q6a3 = answerq6a3.isChecked();
        boolean q6a4 = answerq6a4.isChecked();
        if((q6a2 && q6a3)&&(!(q6a1 || q6a4)))
            return true;
        else return false;
    }

    public boolean answer7() {
        CheckBox answerq7a1 = (CheckBox) findViewById(R.id.q7a1);
        CheckBox answerq7a2 = (CheckBox) findViewById(R.id.q7a2);
        CheckBox answerq7a3 = (CheckBox) findViewById(R.id.q7a3);
        CheckBox answerq7a4 = (CheckBox) findViewById(R.id.q7a4);
        boolean q7a1 = answerq7a1.isChecked();
        boolean q7a2 = answerq7a2.isChecked();
        boolean q7a3 = answerq7a3.isChecked();
        boolean q7a4 = answerq7a4.isChecked();
        if((q7a1 && q7a2)&&(!(q7a3 || q7a4)))
            return true;
        else return false;
    }

    /**
     * This is the method which checks the answer for the eighth question. The input from the user
     * has to be the same as the right answer. Thankfully, the XML already capitalize each word
     * of the answer, so there is no need to check the capitalization.
     */
    public boolean answer8() {
        EditText answer8 = (EditText) findViewById(R.id.q8a1);
        String q8a1 = answer8.getText().toString();
        return "World Wide Web".equalsIgnoreCase(q8a1);
    }

}
