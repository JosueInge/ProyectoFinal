package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernameEditText = findViewById(R.id.txtUsuario);
        final EditText passwordEditText = findViewById(R.id.txtContraseña);

        Button loginButton = findViewById(R.id.btnIniciarSesion);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsuario = usernameEditText.getText().toString();
                String txtContraseña = passwordEditText.getText().toString();

                if (txtUsuario.equals("admin") && txtContraseña.equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this, "Credenciales ingresadas con exito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Usuario o Contraseña invalidos", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}