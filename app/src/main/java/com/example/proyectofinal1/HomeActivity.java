package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageButton btnMiradores = findViewById(R.id.btnMiradores);
        ImageButton btnPlayas = findViewById(R.id.btnPlayas);
        ImageButton btnBalnearios = findViewById(R.id.btnBalnearios);
        ImageButton btnPlazas = findViewById(R.id.btnPlazas);
        ImageButton btnSenderismo = findViewById(R.id.btnSenderismo);
        ImageButton btnHoteles = findViewById(R.id.btnHoteles);
        ImageButton btnTirolinas = findViewById(R.id.btnTirolinas);
        ImageButton btnParquess = findViewById(R.id.btnParquess);
        ImageButton btnArqueologos = findViewById(R.id.btnArqueologos);
        ImageButton btnTransporte = findViewById(R.id.btnTransporte);
        FloatingActionButton btnCerraSesion = findViewById(R.id.btnCerrarSesion);

        btnMiradores.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MiradoresActivity.class);
            startActivity(intent);
        });
        btnPlayas.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PlayasActivity.class);
            startActivity(intent);
        });
        btnBalnearios.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, BalneariosActivity.class);
            startActivity(intent);
        });
        btnPlazas.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PlazasActivity.class);
            startActivity(intent);
        });
        btnSenderismo.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CaminatasActivity.class);
            startActivity(intent);
        });
        btnTirolinas.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, TirolinasActivity.class);
            startActivity(intent);
        });
        btnParquess.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ParquesActivity.class);
            startActivity(intent);
        });
        btnArqueologos.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, RuinasActivity.class);
            startActivity(intent);
        });
        btnHoteles.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, HotelesActivity.class);
            startActivity(intent);
        });

        btnTransporte.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ContratoActivity.class);
            startActivity(intent);
        });
        btnCerraSesion.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}