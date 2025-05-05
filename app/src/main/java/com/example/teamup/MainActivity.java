package com.example.teamup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signInBtn = findViewById(R.id.signInBtn);
        Button crateUserBtn = findViewById(R.id.newbtn);
        EditText user = findViewById(R.id.etUsuario);
        TextView welcomeMsg = findViewById(R.id.signInText);


        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = user.getText().toString();
                welcomeMsg.setText("Bienvenido/a, " +nombre);
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }



}