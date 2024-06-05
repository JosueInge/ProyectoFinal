package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TirolinasActivity extends AppCompatActivity {
    FloatingActionButton Volvertirolinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tirolinas);

        ImageButton CafeAlbania = findViewById(R.id.imgAlbania);
        ImageButton PicnicBoqueron = findViewById(R.id.imgPicnic);

        CafeAlbania.setOnClickListener(v -> {
            Intent intent = new Intent(TirolinasActivity.this, CafealbaniaActivity.class);
            startActivity(intent);
        });
        PicnicBoqueron.setOnClickListener(v -> {
            Intent intent = new Intent(TirolinasActivity.this, ElboqueronActivity.class);
            startActivity(intent);
        });
        Volvertirolinas = findViewById(R.id.Volvertirolinas);
        Volvertirolinas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VolverHomeRuinas();
            }
        });
    }

    public void VolverHomeRuinas() {
        Intent abrirVentana = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(abrirVentana);
    }
}