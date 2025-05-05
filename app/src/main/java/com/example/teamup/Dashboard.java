package com.example.teamup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Dashboard extends AppCompatActivity {

    LinearLayout eventContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        eventContainer = findViewById(R.id.eventContainer);

        // Cargar eventos dinámicos
        for (int i = 1; i <= 5; i++) {
            TextView welcomeMsg = findViewById(R.id.welcome);
            welcomeMsg.setText("Bienvenido");
            TextView event = new TextView(this);
            event.setText("Evento");
            event.setPadding(16, 16, 16, 16);
            event.setBackgroundColor(Color.LTGRAY);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            params.setMargins(16, 0, 0, 0);
            event.setLayoutParams(params);
            eventContainer.addView(event);
        }

    }
}
