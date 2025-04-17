package com.example.teamup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newBtn = findViewById(R.id.newbtn);
        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView newMsg = findViewById(R.id.signInText);
                newMsg.setText("Crear cuenta");
            }
        });
    }

    public void updateMsg(View view){
        Log.i("testMessage", "Update Msg");
        //R.id.signInText
        TextView signInText = findViewById(R.id.signInText);
        signInText.setText(R.string.newMesg);
    }


}