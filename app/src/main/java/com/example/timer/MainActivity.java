package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnWatch, btnMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   btnMsg=findViewById(R.id.btnMsg);
   btnWatch=findViewById(R.id.btnWatch);
   btnMsg.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent= new Intent(MainActivity.this,com.example.timer.Messenger.class );
           startActivity(intent);
       }
   });
   btnWatch.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent=new Intent(MainActivity.this, com.example.timer.stopwatch.class);
           startActivity(intent);
       }
   });
    }
}