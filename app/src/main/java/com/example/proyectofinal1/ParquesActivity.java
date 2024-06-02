package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ParquesActivity extends AppCompatActivity {
FloatingActionButton VolverParques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parques);

        VolverParques = findViewById(R.id.VolverParques);
        VolverParques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHomeParques();

            }
        });
    }
    public void VolverHomeParques(){
        Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(abrirVentana);
    }
}