package com.example.proyectofinal1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class lista_contrato extends AppCompatActivity {
        Bundle parametros = new Bundle();
        FloatingActionButton btn;
        ListView lts;
        Cursor cContratos;
        DB dbContratos;
        Contratos misContratos;
        final ArrayList<Contratos> alContratos=new ArrayList<Contratos>();
        final ArrayList<Contratos> alContratosCopy=new ArrayList<Contratos>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lista_contrato);

            btn = findViewById(R.id.btnAbrirContratos);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    parametros.putString("accion", "nuevo");
                    abrirActividad(parametros);
                }
            });
            obtenerAmigos();
            buscarAmigos();
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.mimenu, menu);

            AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)menuInfo;
            cContratos.moveToPosition(info.position);
            menu.setHeaderTitle(cContratos.getString(1));//1 es el nombre del amigo
        }
        @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {
            try {
                switch (item.getItemId()){
                    case R.id.mnxAgregar:
                        parametros.putString("accion", "nuevo");
                        abrirActividad(parametros);
                        break;
                    case R.id.mnxModificar:
                        String amigos[] = {
                                cContratos.getString(0), //idAmigo
                                cContratos.getString(1), //nombre
                                cContratos.getString(2), //direccion
                                cContratos.getString(3), //tel
                                cContratos.getString(4), //email
                                cContratos.getString(5), //dui
                                cContratos.getString(6)  //foto
                        };
                        parametros.putString("accion","modificar");
                        parametros.putStringArray("amigos", amigos);
                        abrirActividad(parametros);
                        break;
                    case R.id.mnxEliminar:
                        eliminarAmigos();
                        break;
                }
                return true;
            }catch (Exception e){
                mostrarMsg("Error en menu: "+ e.getMessage());
                return super.onContextItemSelected(item);
            }
        }
        private void eliminarAmigos(){
            try {
                AlertDialog.Builder confirmacion = new AlertDialog.Builder(lista_contrato.this);
                confirmacion.setTitle("Esta seguro de Eliminar a: ");
                confirmacion.setMessage(cContratos.getString(1));
                confirmacion.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String respuesta = dbContratos.administrar_contratos("eliminar", new String[]{cContratos.getString(0)});
                        if (respuesta.equals("ok")) {
                            mostrarMsg("Amigo eliminado con exito.");
                            obtenerAmigos();
                        } else {
                            mostrarMsg("Error al eliminar amigo: " + respuesta);
                        }
                    }
                });
                confirmacion.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                confirmacion.create().show();
            }catch (Exception e){
                mostrarMsg("Error al eliminar: "+ e.getMessage());
            }
        }
        private void abrirActividad(Bundle parametros){
            Intent abriVentana = new Intent(getApplicationContext(), MainActivity.class);
            abriVentana.putExtras(parametros);
            startActivity(abriVentana);
        }
        private void obtenerAmigos(){
            try{
                alContratos.clear();
                alContratosCopy.clear();

                dbContratos = new DB(lista_contrato.this, "", null, 1);
                cContratos = dbContratos.consultar_contratos();

                if ( cContratos.moveToFirst() ){
                    lts = findViewById(R.id.ltsAmigos);
                    do{
                        misContratos = new Contratos(
                                cContratos.getString(0),//idAmigo
                                cContratos.getString(1),//nombre
                                cContratos.getString(2),//direccion
                                cContratos.getString(3),//tel
                                cContratos.getString(4),//email
                                cContratos.getString(5),//dui
                                cContratos.getString(6) //foto
                        );
                        alContratos.add(misContratos);
                    }while(cContratos.moveToNext());
                    alContratosCopy.addAll(alContratos);

                    adaptadorImagenes adImagenes = new adaptadorImagenes(getApplicationContext(), alContratos);
                    lts.setAdapter(adImagenes);

                    registerForContextMenu(lts);
                }else{
                    mostrarMsg("No hay amigos que mostrar");
                }
            }catch (Exception e){
                mostrarMsg("Error al obtener amigos: "+ e.getMessage());
            }
        }
        private void mostrarMsg(String msg){
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        private void buscarAmigos(){
            TextView tempVal;
            tempVal = findViewById(R.id.txtBuscarAmigos);
            tempVal.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    try {
                        alContratos.clear();
                        String valor = tempVal.getText().toString().trim().toLowerCase();
                        if( valor.length()<=0 ){
                            alContratos.addAll(alContratosCopy);
                        }else{
                            for( Contratos Contrato : alContratosCopy ){
                                String guia = Contrato.getGuia();
                                String telefono = Contrato.getTelefono();
                                String personas = Contrato.getPersonas();
                                String destino = Contrato.getDestino();
                                if( guia.toLowerCase().trim().contains(valor) ||
                                        telefono.toLowerCase().trim().contains(valor) ||
                                        personas.trim().contains(valor) ||
                                        destino.trim().toLowerCase().contains(valor) ){
                                    alContratos.add(Contrato);
                                }
                            }
                            adaptadorImagenes adImagenes = new adaptadorImagenes(getApplicationContext(), alContratos);
                            lts.setAdapter(adImagenes);
                        }
                    }catch (Exception e){
                        mostrarMsg("Error al buscar: "+e.getMessage() );
                    }
                }
                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }