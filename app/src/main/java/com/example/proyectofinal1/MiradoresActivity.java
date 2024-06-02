package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MiradoresActivity extends AppCompatActivity {

    FloatingActionButton VolverMiradores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miradores);

        ImageButton fincarauda = findViewById(R.id.fincarauda);
        ImageButton imgPuerta = findViewById(R.id.imgPuerta);
        ImageButton imgMiradorMano = findViewById(R.id.imgMiradorMano);

        fincarauda.setOnClickListener(v -> {
            Intent intent = new Intent(MiradoresActivity.this, FincaraudActivity.class);
            startActivity(intent);
        });
        imgPuerta.setOnClickListener(v -> {
            Intent intent = new Intent(MiradoresActivity.this, PuertaActivity.class);
            startActivity(intent);
        });
        imgMiradorMano.setOnClickListener(v -> {
            Intent intent = new Intent(MiradoresActivity.this, MiradormanoActivity.class);
            startActivity(intent);
        });

        VolverMiradores = findViewById(R.id.VolverMiradores);
        VolverMiradores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {regresarHome(); }

        });
    }
    public void regresarHome(){
Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
startActivity(abrirVentana);
    }

}
