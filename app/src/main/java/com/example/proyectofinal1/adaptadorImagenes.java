package com.example.proyectofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adaptadorImagenes extends BaseAdapter {

    Context context;
    ArrayList<Contratos> datosContratosArrayList;
    Contratos misContratos;
    LayoutInflater layoutInflater;

    public adaptadorImagenes(Context context, ArrayList<Contratos> datosContratosArrayList) {
        this.context = context;
        this.datosContratosArrayList = datosContratosArrayList;
    }
    @Override
    public int getCount() {
        return datosContratosArrayList.size();
    }
    @Override
    public Object getItem(int i) {
        return datosContratosArrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return Long.parseLong(datosContratosArrayList.get(i).getIdContrato());
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.activity_adaptador_imagenes, viewGroup, false);
        try{
            misContratos = datosContratosArrayList.get(i);

            TextView tempVal = itemView.findViewById(R.id.lblGuia);
            tempVal.setText(misContratos.getGuia());

            tempVal = itemView.findViewById(R.id.lblTelefono);
            tempVal.setText(misContratos.getGuia());

            tempVal = itemView.findViewById(R.id.lblPersonas);
            tempVal.setText(misContratos.getTelefono());

        }catch (Exception e){
            Toast.makeText(context, "Error al mostrar datos: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return itemView;
    }
}