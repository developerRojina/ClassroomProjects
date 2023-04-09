package com.aadim.classroom.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aadim.classroom.R;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    ArrayList<Quiz> quizes = new ArrayList<Quiz>();


    TextView tvQn, tvScore;
    Button option1, option2, option3, option4;


    int currentIndex = 0;
    int score = 0;



    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizes.add(new Quiz("Where should you add permissions in Android project", "Manifest", "EditText", "Linear Layout", "Relative Layout", "Manifest"));
        quizes.add(new Quiz("Which view is used to display text in Android", "TextView", "Relative layout", "Linear Layout", "FrameLayout", "TextView"));
        quizes.add(new Quiz("Which view is used to take user input", "TextView", "EditText", "Manifest", "styles", "EditText"));


        tvQn = findViewById(R.id.tvQuestion);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        tvScore = findViewById(R.id.tvScore);


        updateScore();
        setUpQuizView(currentIndex);


        //add click listeners
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrectAnswer(option1.getText().toString());

            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrectAnswer(option2.getText().toString());
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrectAnswer(option3.getText().toString());
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrectAnswer(option4.getText().toString());
            }
        });
    }


    private void setUpQuizView(int index) {
        tvQn.setText(quizes.get(index).question);
        option1.setText(quizes.get(index).option1);
        option2.setText(quizes.get(index).option2);
        option3.setText(quizes.get(index).option3);
        option4.setText(quizes.get(index).option4);


    }


    private void checkCorrectAnswer(String pressedAnswer) {

        if (pressedAnswer.equalsIgnoreCase(quizes.get(currentIndex).getAnswer())) {
            score = score + 5;
        } else {
            score = score - 5;
        }
        updateScore();

        if (currentIndex != quizes.size() - 1) {
            currentIndex = currentIndex + 1;
            setUpQuizView(currentIndex);
        } else {
            Intent intent = new Intent(this, QuizResultActivity.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }

    private void updateScore() {
        tvScore.setText("" + score);
    }


}