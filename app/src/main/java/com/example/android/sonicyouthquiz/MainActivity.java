package com.example.android.sonicyouthquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Display the total score in a Toast with a personalized message
     *
     * @param score          of the quizz
     */

    public void printScore(int score) {

        String scoreMessage = "";

        if (score == 6) {
            scoreMessage += "Wooow you are a real fan, " + score + " points!!";
        } else if (score == 0) {
            scoreMessage += "You know nothing about sonic youth, " + score + " points";
        } else {
            scoreMessage += "Your score is: ";
            scoreMessage += Integer.toString(score);
        }

        Toast toast = Toast.makeText(this, scoreMessage, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * This method is called when the score button is clicked,
     * looks for the components in the layout and compare the user's answers to calculate the score
     */

    public void calculateScore(View v) {

        int score = 0;

        CheckBox question1Option1 = findViewById(R.id.question_1_option_1);
        CheckBox question1Option2 = findViewById(R.id.question_1_option_2);
        CheckBox question1Option3 = findViewById(R.id.question_1_option_3);

        RadioButton question2Option1 = findViewById(R.id.question_2_option_1);

        EditText question3Answer = findViewById(R.id.question_3_option_1);
        String question3 = question3Answer.getText().toString().trim().toUpperCase();
        String question3RealAnswer = getString(R.string.question3_real_answer);

        RadioButton question4Option3 = findViewById(R.id.question_4_option_3);

        CheckBox question5Option1 = findViewById(R.id.question_5_option_1);
        CheckBox question5Option2 = findViewById(R.id.question_5_option_2);
        CheckBox question5Option3 = findViewById(R.id.question_5_option_3);

        EditText question6Answer = findViewById(R.id.question_6_option_1);
        String question6 = question6Answer.getText().toString().toUpperCase();
        String question6RealAnswer = getString(R.string.question6_real_answer);


        if (question1Option1.isChecked() && question1Option3.isChecked() && !(question1Option2.isChecked()))
            score++;

        if (question2Option1.isChecked())
            score++;

        if (question3.equals(question3RealAnswer))
            score++;

        if (question4Option3.isChecked())
            score++;

        if (question5Option1.isChecked() && question5Option2.isChecked() && !(question5Option3.isChecked()))
            score++;

        if (question6.equals(question6RealAnswer))
            score++;

        printScore(score);

    }
}
