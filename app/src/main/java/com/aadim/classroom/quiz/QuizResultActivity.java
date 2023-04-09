package com.aadim.classroom.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.aadim.classroom.R;

public class QuizResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        TextView scoreTv = findViewById(R.id.tvScoreResult);
        int score = getIntent().getIntExtra("score",0);
        scoreTv.setText("Score:"+score);

    }
}