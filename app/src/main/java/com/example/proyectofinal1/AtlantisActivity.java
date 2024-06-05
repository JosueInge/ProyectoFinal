package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AtlantisActivity extends AppCompatActivity {
FloatingActionButton VolverHomeAtlantis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atlantis);

        VolverHomeAtlantis = findViewById(R.id.VolverHomeAtlantis);
        VolverHomeAtlantis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHome(); }

        });
    }
    public void VolverHome(){
        Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(abrirVentana);
    }
    }
