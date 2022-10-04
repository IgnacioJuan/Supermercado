package com.juanguachi.supermercado.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    public static final String DBNAME="supermercado.bd";
    public static final String  TABLENAME="Proveedor";
    public static final int VER=1;

    public SqlHelper(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="Create TABLE "+TABLENAME+" (" +
                "ruc text primary key, " +
                "nombre_comercial text, " +
                "representante_legal text, " +
                "direccion text, " +
                "telefono text, " +
                "productos text, " +
                "credito numeric" +
                ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "drop table if exists "+TABLENAME;
        db.execSQL(query);
    }
}
