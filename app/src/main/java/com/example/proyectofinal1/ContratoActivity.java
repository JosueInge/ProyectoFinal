package com.example.proyectofinal1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContratoActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    FloatingActionButton btnVolverLista;
    String accion="nuevo", id="", urlCompletaImg="";
    Intent tomarFotoIntent;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrato);

        img = findViewById(R.id.imgCont);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFotoAmigo();
            }
        });
        btnVolverLista = findViewById(R.id.btnVolverLista);
        btnVolverLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volverListaContratos();
            }
        });
        btn = findViewById(R.id.btnGuardarCont);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempVal = findViewById(R.id.txtGuia);
                String guia = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtTelefono);
                String telefono = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtPersonas);
                String personas = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtDestino);
                String destino = tempVal.getText().toString();

                tempVal = findViewById(R.id.txtTiempo);
                String tiempo = tempVal.getText().toString();

                DB db = new DB(getApplicationContext(),"", null, 1);
                String[] datos = new String[]{id,guia,telefono,personas,destino,tiempo, urlCompletaImg};
                String respuesta = db.administrar_contratos(accion, datos);
                if( respuesta.equals("ok") ){
                    Toast.makeText(getApplicationContext(), "El contrato se registro con exito.", Toast.LENGTH_SHORT).show();
                    volverListaContratos();
                }else{
                    Toast.makeText(getApplicationContext(), "Error: "+ respuesta, Toast.LENGTH_LONG).show();
                }
            }
        });
        mostrarDatosContratos();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if( requestCode==1 && resultCode==RESULT_OK ){
                Bitmap imagenBitmap = BitmapFactory.decodeFile(urlCompletaImg);
                img.setImageBitmap(imagenBitmap);
            }else{
                mostrarMsg("Se cancelo la toma de la foto");
            }
        }catch (Exception e){
            mostrarMsg("Error al mostrar la camara: "+ e.getMessage());
        }
    }
    private void tomarFotoAmigo(){
        tomarFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if( tomarFotoIntent.resolveActivity(getPackageManager())!=null ){
        File fotoAmigo = null;
        try{
            fotoAmigo = crearImagenAmigo();
            if( fotoAmigo!=null ){
                Uri uriFotoAmigo = FileProvider.getUriForFile(ContratoActivity.this, "com.ugb.controlesbasicos.fileprovider", fotoAmigo);
                tomarFotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriFotoAmigo);
                startActivityForResult(tomarFotoIntent, 1);
            }else{
                mostrarMsg("NO pude tomar la foto");
            }
        }catch (Exception e){
            mostrarMsg("Error al tomar la foto: "+ e.getMessage());
        }
        /*}else{
            mostrarMsg("No se selecciono una foto...");
        }*/
    }
    private File crearImagenAmigo() throws Exception{
        String fechaHoraMs = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "imagen_"+ fechaHoraMs +"_";
        File dirAlmacenamiento = getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if( !dirAlmacenamiento.exists() ){
            dirAlmacenamiento.mkdirs();
        }
        File image = File.createTempFile(fileName, ".jpg", dirAlmacenamiento);
        urlCompletaImg = image.getAbsolutePath();
        return image;
    }
    private void mostrarMsg(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
    private void volverListaContratos(){
        Intent abrirVentana = new Intent(getApplicationContext(), lista_contrato.class);
        startActivity(abrirVentana);
    }
    private void mostrarDatosContratos(){
        try {
            Bundle parametros = getIntent().getExtras();
            accion = parametros.getString("accion");
            if( accion.equals("modificar") ){
                String[] datos = parametros.getStringArray("Contratos");
                id = datos[0];

                tempVal = findViewById(R.id.txtGuia);
                tempVal.setText(datos[1]);

                tempVal = findViewById(R.id.txtTelefono);
                tempVal.setText(datos[2]);

                tempVal = findViewById(R.id.txtPersonas);
                tempVal.setText(datos[3]);

                tempVal = findViewById(R.id.txtDestino);
                tempVal.setText(datos[4]);

                tempVal = findViewById(R.id.txtTiempo);
                tempVal.setText(datos[5]);

                urlCompletaImg = datos[6];
                Bitmap bitmap = BitmapFactory.decodeFile(urlCompletaImg);
                img.setImageBitmap(bitmap);
            }
        }catch (Exception e){
            mostrarMsg("Error al mostrar los datos: "+ e.getMessage());
        }
    }
}