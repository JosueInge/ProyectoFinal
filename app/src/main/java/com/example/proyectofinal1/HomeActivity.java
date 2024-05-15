package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnMiradores = findViewById(R.id.btnmiradores);
        Button btnPlayas = findViewById(R.id.btnPlayas);
        Button btnBalnearios = findViewById(R.id.btnBalnearios);
        Button btnPlazas = findViewById(R.id.btnPlazas);
        Button btnCaminatas = findViewById(R.id.btnCaminatas);
        Button btnParques = findViewById(R.id.btnParques);
        Button btnCines = findViewById(R.id.btnCines);
        Button btnArqueologos = findViewById(R.id.btnArqueologos);
        Button btnHoteles = findViewById(R.id.btnHoteles);
        Button btnRestaurant = findViewById(R.id.btnRestaurant);
        Button btnTransporte = findViewById(R.id.btnTransporte);
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
            Intent intent = new Intent(HomeActivity.this, PlayasActivity.class);
            startActivity(intent);
        });
        btnCaminatas.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CaminatasActivity.class);
            startActivity(intent);
        });
        btnParques.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ParquesActivity.class);
            startActivity(intent);
        });
        btnCines.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CinesActivity.class);
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
        btnRestaurant.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, RestaurantesActivity.class);
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