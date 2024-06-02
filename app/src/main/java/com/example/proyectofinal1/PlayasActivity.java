package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PlayasActivity extends AppCompatActivity {

    FloatingActionButton VolverPlayas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playas);

        VolverPlayas = findViewById(R.id.VolverPlayas);
        VolverPlayas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHomePlayas();}
        });
    }
    public void VolverHomePlayas(){
        Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(abrirVentana);
    }
}