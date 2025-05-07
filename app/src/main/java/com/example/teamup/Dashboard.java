/*
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

        TextView welcomeMsg = findViewById(R.id.welcome);
        welcomeMsg.setText("Bienvenido");
    }
}
*/

package com.example.teamup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    private LinearLayout eventContainer;
    private Button msgBtn, rutinasBtn;
    private LinearLayout dynamicContentContainer;
    private boolean isMsgViewVisible = false;
    private boolean isRoutineViewVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Inicializo vistas
        TextView welcomeMsg = findViewById(R.id.welcome);
        welcomeMsg.setText("Dashboard");

        msgBtn = findViewById(R.id.msgBtn);
        rutinasBtn = findViewById(R.id.rutinasBtn);
        dynamicContentContainer = findViewById(R.id.dynamicContentContainer); // Asegúrate de tener este LinearLayout en tu XML

        // listeners de los botones
        msgBtn.setOnClickListener(v -> toggleMessageInput());
        rutinasBtn.setOnClickListener(v -> toggleRoutineCard());
    }

    private void toggleMessageInput() {
        if (isMsgViewVisible) {
            // Si ya está visible, lo borro
            removeMessageInput();
        } else {
            // Si no está visible, lo muestro
            addMessageInput();
            // Boorrar rutina
            if (isRoutineViewVisible) {
                removeRoutineCard();
            }
        }
        isMsgViewVisible = !isMsgViewVisible;
    }

    private void addMessageInput() {
        // contenedor para el mensaje
        LinearLayout messageLayout = new LinearLayout(this);
        messageLayout.setOrientation(LinearLayout.VERTICAL);
        messageLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        messageLayout.setPadding(32, 32, 32, 32);

        // TextView para el título
        TextView title = new TextView(this);
        title.setText("Ingresa tu mensaje:");
        title.setTextSize(18);
        title.setTextColor(getResources().getColor(android.R.color.black));
        messageLayout.addView(title);

        // EditText para el mensaje
        EditText messageInput = new EditText(this);
        messageInput.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        messageInput.setHint("Escribe aquí tu mensaje...");
        messageLayout.addView(messageInput);

        // botón para enviar
        Button sendBtn = new Button(this);
        sendBtn.setText("Enviar");
        sendBtn.setOnClickListener(v -> {
            String message = messageInput.getText().toString();
            Toast.makeText(this, "Mensaje enviado: " + message, Toast.LENGTH_SHORT).show();
            removeMessageInput();
            isMsgViewVisible = false;
        });
        messageLayout.addView(sendBtn);

        // Agregar al contenedor principal
        dynamicContentContainer.addView(messageLayout);
        dynamicContentContainer.setTag("messageView"); // Para identificarlo luego
    }

    // Borrar msg
    private void removeMessageInput() {
        View messageView = dynamicContentContainer.findViewWithTag("messageView");
        if (messageView != null) {
            dynamicContentContainer.removeView(messageView);
        }
    }

    private void toggleRoutineCard() {
        if (isRoutineViewVisible) {
            // borrar rutina
            removeRoutineCard();
        } else {
            // mostrar rutina
            addRoutineCard();
            // borar msj
            if (isMsgViewVisible) {
                removeMessageInput();
            }
        }
        isRoutineViewVisible = !isRoutineViewVisible;
    }

    private void addRoutineCard() {
        //  CardView
        CardView routineCard = new CardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(16, 16, 16, 16);
        routineCard.setLayoutParams(cardParams);
        routineCard.setCardElevation(8);
        routineCard.setRadius(16);
        routineCard.setContentPadding(32, 32, 32, 32);

        //  contenido de la tarjeta
        LinearLayout cardContent = new LinearLayout(this);
        cardContent.setOrientation(LinearLayout.VERTICAL);
        cardContent.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        //  título
        TextView title = new TextView(this);
        title.setText("Rutina de Fuerza");
        title.setTextSize(20);
        title.setTextColor(getResources().getColor(android.R.color.black));
        title.setPadding(0, 0, 0, 16);
        cardContent.addView(title);

        //  descripción de la rutina
        TextView routineDesc = new TextView(this);
        routineDesc.setText("1. Press de banca - 4x8\n2. Sentadillas - 4x10\n3. Peso muerto - 3x6\n4. Dominadas - 3xMAX");
        routineDesc.setTextSize(16);
        cardContent.addView(routineDesc);

        //  boton cerrar rutina
        Button closeBtn = new Button(this);
        closeBtn.setText("Cerrar");
        closeBtn.setOnClickListener(v -> {
            removeRoutineCard();
            isRoutineViewVisible = true;
        });
        cardContent.addView(closeBtn);

        // Añadir contenido a la tarjeta
        routineCard.addView(cardContent);

        // Agregar al contenedor principal
        dynamicContentContainer.addView(routineCard);
        dynamicContentContainer.setTag("routineView"); // Para identificarlo luego
    }

    //borrar rutina
    private void removeRoutineCard() {
        View routineView = dynamicContentContainer.findViewWithTag("routineView");
        if (routineView != null) {
            dynamicContentContainer.removeView(routineView);
        }
    }
}
