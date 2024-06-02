package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BalneariosActivity extends AppCompatActivity {

    FloatingActionButton VolverBalnearios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balnearios);

        ImageButton chorros = findViewById(R.id.chorros);
        ImageButton atlantis = findViewById(R.id.atlantis);
        ImageButton termos = findViewById(R.id.termos);
        ImageButton termales = findViewById(R.id.imgTermalesSt);

        chorros.setOnClickListener(v -> {
            Intent intent = new Intent(BalneariosActivity.this, LoschorrosActivity.class);
            startActivity(intent);
        });
        atlantis.setOnClickListener(v -> {
            Intent intent = new Intent(BalneariosActivity.this, AtlantisActivity.class);
            startActivity(intent);
        });
        termos.setOnClickListener(v -> {
            Intent intent = new Intent(BalneariosActivity.this, TermosdrActivity.class);
            startActivity(intent);
        });
        termales.setOnClickListener(v -> {
            Intent intent = new Intent(BalneariosActivity.this, TermalesActivity.class);
            startActivity(intent);
        });
        VolverBalnearios = findViewById(R.id.VolverBalnearios);
        VolverBalnearios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHomeBal();}
        });
    }
public void VolverHomeBal(){
        Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(abrirVentana);
    }
}