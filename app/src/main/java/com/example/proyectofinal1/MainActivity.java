package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtEmail, txtContraseña;
    private Button btnIniciarSesion, btnRegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistrarUsuario = findViewById(R.id.btnRegistrarUsuario);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtEmail.getText().toString();
                String password = txtContraseña.getText().toString();

                if (username.equals("admin") && password.equals("12345")) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Inicio de Sesion Exitoso", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username = txtEmail.getText().toString();
                String password = txtContraseña.getText().toString();
               // Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                //startActivity(intent);
                if (!username.isEmpty() && !password.isEmpty()) {
                    DatabaseHelper db = new DatabaseHelper(MainActivity.this);
                    long result = db.addUser(username, password);
                    if (result > 0){

                        Toast.makeText(MainActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

