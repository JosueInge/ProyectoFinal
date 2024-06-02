package com.example.proyectofinal1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    private static final String dbname = "db_contratos";
    private static final int v =1;
    private static final String SQLdb = "CREATE TABLE contratos(idContrato integer primary key autoincrement, guia text, telefono text, personas text, destino text, tiempo text)";
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, v);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLdb);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public String administrar_contratos(String accion, String[] datos){
        try {
            SQLiteDatabase db = getWritableDatabase();
            if( accion.equals("nuevo") ){
                db.execSQL("INSERT INTO contratos(guia,telefono,personas,destino,tiempo) VALUES('"+ datos[1] +"', '"+ datos[2] +"', '"+ datos[3] +"','" + datos[4] +"','"+ datos[5] + "')");
            } else if (accion.equals("modificar")) {
                db.execSQL("UPDATE contratos SET guia='"+ datos[1] +"', telefono='"+ datos[2] +"', personas='"+ datos[3] +"', destino='" + datos[4] +"', tiempo='"+ datos[5] +"' WHERE idContrato='"+ datos[0] +"'");
            } else if (accion.equals("eliminar")) {
                db.execSQL("DELETE FROM contratos WHERE idContrato='"+ datos[0] +"'");
            }
            return "ok";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    public Cursor consultar_contratos(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM contratos ORDER BY guia", null);
        return cursor;
    }
}


