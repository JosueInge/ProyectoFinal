package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RuinasActivity extends AppCompatActivity {
FloatingActionButton VolverRuinas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruinas);

        VolverRuinas = findViewById(R.id.VolverRuinas);
        VolverRuinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHomeRuinas();

            }
        });
    }
    public void VolverHomeRuinas(){
        Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(abrirVentana);
    }
}