package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        EditText txtUsuario = findViewById(R.id.txtUsuario);
        EditText txtContraseña = findViewById(R.id.txtContraseña);
        Button buttonRegister = findViewById(R.id.btnRegistroUser);

        // Manejar el clic del botón de registro
        buttonRegister.setOnClickListener(view -> {
            String email = txtUsuario.getText().toString();
            String password = txtContraseña.getText().toString();
            // Realizar el registro de usuario
            registerUser(email, password);
        });
    }

    private void registerUser(String email, String password) {
        // Implementar lógica de registro aquí
        // Por ejemplo, guardar los datos del usuario en la base de datos local
    }
}