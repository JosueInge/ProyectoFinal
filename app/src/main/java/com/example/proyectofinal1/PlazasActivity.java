package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlazasActivity extends AppCompatActivity {
FloatingActionButton VolverPlazas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plazas);

        ImageButton PlazaSalvador = findViewById(R.id.salvador);

        PlazaSalvador.setOnClickListener(v -> {
            Intent intent = new Intent(PlazasActivity.this, HomeActivity.class);
            startActivity(intent);
        });
        VolverPlazas = findViewById(R.id.VolverPlazas);
        VolverPlazas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHomePlazas();

            }
        });
    }
    public void VolverHomePlazas(){
        Intent abrirventana = new Intent(getApplicationContext(), HotelesActivity.class);
        startActivity(abrirventana);
    }
}