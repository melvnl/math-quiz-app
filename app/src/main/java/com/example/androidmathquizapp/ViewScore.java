package com.example.androidmathquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewScore extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "extra_username";
    public static final String EXTRA_SCORE = "extra_score";

    private TextView tv_username,tv_score;
//    private RecyclerView rv_score;
//
//    private ArrayList<Score> scores;
//    private ScoreAdapter scoreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);

//        rv_score = findViewById(R.id.rv_score);
//        scoreAdapter = new ScoreAdapter(scores);
//        rv_score.setAdapter(scoreAdapter);
//        rv_score.setLayoutManager(new LinearLayoutManager(this));
//        initScores();
        tv_username = findViewById(R.id.tv_username);
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        tv_username.setText(username);

        tv_score = findViewById(R.id.tv_score);
        String score = getIntent().getStringExtra(EXTRA_SCORE);
        tv_score.setText(score);

    }

//    private void initScores(){
//        scores = new ArrayList<>();
//
//        Score score = new Score();
//        score.setScoreUsername("1");
//        score.setScoreValue(300);
//
//        Score score2 = new Score();
//        score2.setScoreUsername("1");
//        score2.setScoreValue(10000);
//
//        Score score3 = new Score();
//        score3.setScoreUsername("1");
//        score3.setScoreValue(500);
//
//
//        scores.add(score);
//        scores.add(score2);
//        scores.add(score3);
//    }
}