package com.example.timer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class stopwatch extends AppCompatActivity {
private int sec=0;
private boolean running, wasRunning;
Button btnStart, btnStop, btnReset;
TextView tvTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);
        btnReset=findViewById(R.id.btnReset);
        tvTimer=findViewById(R.id.tvTimer);
        if (savedInstanceState!=null){
            savedInstanceState.putInt("seconds", sec);
            savedInstanceState.putBoolean("running", running);
            savedInstanceState.putBoolean("wasRunning", wasRunning);
        }
        runTimer();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=true;
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running=false;
                sec=0;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning=running;
        running= false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning)
        {
            running=true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", sec);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    private void runTimer(){
Handler handler= new Handler();
handler.post(new Runnable() {
    @Override
    public void run() {
        int hours = sec/3600;
        int minutes = (sec%3600)/60;
        int secs = sec%60;
        String timer= String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
        tvTimer.setText(timer);
        if (running){
            sec++;
        }
        handler.postDelayed(this, 1000);
    }
});
    }
}