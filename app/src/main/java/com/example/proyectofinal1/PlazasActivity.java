package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlazasActivity extends AppCompatActivity {
FloatingActionButton VolverPlazas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plazas);

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