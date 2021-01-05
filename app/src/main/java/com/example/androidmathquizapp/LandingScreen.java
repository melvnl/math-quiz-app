package com.example.androidmathquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LandingScreen extends AppCompatActivity {

    private EditText etUsername;
    private Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);

        etUsername = findViewById(R.id.et_username);
        btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    Intent i = new Intent(LandingScreen.this, Main.class );
                    i.putExtra(Main.EXTRA_USERNAME, etUsername.getText().toString());
                    startActivity(i);
                }
                else{
                    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Input Username First!!!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }

    private boolean validate(){
        if(etUsername.getText().toString().equals("")) return false;
        else return true;
    }


}