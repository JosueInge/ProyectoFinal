package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HotelesActivity extends AppCompatActivity {
FloatingActionButton VolverCines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);

        ImageButton Hoteldecameron = findViewById(R.id.HotelDecameron);
        ImageButton HotelSevilla = findViewById(R.id.hotelsevilla);

        Hoteldecameron.setOnClickListener(v -> {
            Intent intent = new Intent(HotelesActivity.this, HoteldecamActivity.class);
            startActivity(intent);
        });

        VolverCines = findViewById(R.id.VolverHoteles);
        VolverCines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {VolverHomeCines();
            }
        });
    }
    public void VolverHomeCines(){
        Intent abrirVentana = new Intent(getApplicationContext(), HotelesActivity.class);
        startActivity(abrirVentana);
    }
}