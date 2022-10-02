package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Messenger extends AppCompatActivity {
EditText etMsg;
Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
    etMsg=findViewById(R.id.etMsg);
    btnSend=findViewById(R.id.btnSend);
    btnSend.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (etMsg.getText().toString().isEmpty()){
                Toast.makeText(Messenger.this, "The Field Is Empty, Please Enter A Message", Toast.LENGTH_SHORT).show();
            }
            else{
                String message= etMsg.getText().toString().trim();
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                String chooseIntent= getString(R.string.choose);
                Intent chosenIntent= Intent.createChooser(intent, chooseIntent);
                startActivity(chosenIntent);
            }
        }
    });
    }
}