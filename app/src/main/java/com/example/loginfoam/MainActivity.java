package com.example.loginfoam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button blogin;
    EditText etemail,etpassword;
    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etemail=(EditText)findViewById(R.id.etemail);
        etpassword=(EditText)findViewById(R.id.etpassword);
        blogin=(Button)findViewById(R.id.blogin);

        blogin.setOnClickListener(this);

        progressBar =(ProgressBar)findViewById(R.id.ProgressBar);
        progressBar.setVisibility(View.VISIBLE);

        handler =new Handler();
        runnable =new Runnable() {
            @Override
            public void run() {
          timer.cancel();
          progressBar.setVisibility(View.GONE);
            }
        };
        timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
         handler.post(runnable);
            }
        },8000,1000);



    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blogin:
          startActivity(new Intent(this, Nav_drawer.class));

                break;

            }
    }
}
