package com.example.androidmathquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Main extends AppCompatActivity {

    public static final String EXTRA_USERNAME = "extra_username";
//    public static final String EXTRA_SCORE = "extra_score";
    TextView tv_firstNum, tv_secondNum, tv_operator, tv_result, tv_score;
    Random r;
    int firstNum, secondNum;
    char operator;
    int answer,score = 0;
    String username;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getUsername();
        randNumber();
        randOperator();

//        if(isFinishing()){
//            Intent sendData = new Intent(Main.this, ViewScore.class );
////            sendData.putExtra(ViewScore.EXTRA_USERNAME, tv_currentUser.getText().toString());
////            sendData.putExtra(ViewScore.EXTRA_SCORE, tv_score.getText().toString());
////            saveHighScore();
//            startActivity(sendData);
//        }
    }

    private void getUsername(){
//        tv_currentUser = findViewById(R.id.tv_currentUser);
        username = getIntent().getStringExtra(EXTRA_USERNAME);
    }

    private void randNumber(){
        r = new Random();

        tv_firstNum = findViewById(R.id.tv_firstNum);
        tv_secondNum = findViewById(R.id.tv_secondNum);


        firstNum = r.nextInt(50);
        secondNum = r.nextInt(50);

        tv_firstNum.setText(String.valueOf(firstNum));
        tv_secondNum.setText(String.valueOf(secondNum));
    }

    private void randOperator(){
        r = new Random();
        char [] operators = "+-*".toCharArray();

        tv_operator = findViewById(R.id.tv_operator);
        operator = operators[r.nextInt(operators.length)];
        tv_operator.setText(String.valueOf(operator));
    }

    private void checkAnswer(int firstNum, int secondNum, char operator) {
        switch (operator) {
            case '+':
                answer = firstNum + secondNum;
                break;
            case '-':
                answer = firstNum - secondNum;
                break;

            case '*':
                answer = firstNum * secondNum;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }

    private void setResult(String givenValue){
        tv_result = (TextView) findViewById(R.id.tv_result);
        result = result + givenValue;
        tv_result.setText(result);
    }

    private void addScore(){
        tv_score = (TextView) findViewById(R.id.tv_score);
        score = score + 10;
        tv_score.setText(Integer.toString(score));
    }

    private void minScore(){
        tv_score = (TextView) findViewById(R.id.tv_score);
        score = score - 10;
        if(score < 0){
            score = 0;
            tv_score.setText(Integer.toString(score));
        }
        else{
            tv_score.setText(Integer.toString(score));
        }
    }

//    public int getScore(){
//        return score;
//    }

//    public boolean isFinishing (){
//
//    }

    public void OneOnClick(View view) {
        setResult("1");
    }

    public void TwoOnClick(View view) {
        setResult("2");
    }

    public void ThreeOnClick(View view) {
        setResult("3");
    }

    public void FourOnClick(View view) {
        setResult("4");
    }

    public void FiveOnClick(View view) {
        setResult("5");
    }

    public void SixOnClick(View view) {
        setResult("6");
    }

    public void SevenOnClick(View view) {
        setResult("7");
    }

    public void EightOnClick(View view) {
        setResult("8");
    }

    public void NineOnClick(View view) {
        setResult("9");
    }

    public void ZeroOnClick(View view) {
        setResult("0");
    }

    public void DeleteOnClick(View view) {
        result = "";
        tv_result.setText("");
    }

//    public void saveHighScore(){
//        SharedPreferences preferences =
//                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//        SharedPreferences.Editor editor = preferences.edit();
//
//        editor.putInt("myHighScore", Integer.parseInt(String.valueOf(tv_score)));
//        editor.commit();
//    }

    public void SubmitOnClick(View view) {

        checkAnswer(firstNum,secondNum,operator);
        if(Integer.toString(answer).equals(result)){
           addScore();
        }
        else{
            minScore();
        }
        randNumber();
        randOperator();
        DeleteOnClick(view);
      }


    public void ViewScoreOnClick(View view) {
//        saveHighScore();
        Intent i = new Intent(Main.this, ViewScore.class );
        i.putExtra(ViewScore.EXTRA_USERNAME, username);
        i.putExtra(ViewScore.EXTRA_SCORE, tv_score.getText().toString());
        startActivity(i);
    }
}
