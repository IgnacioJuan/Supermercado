package com.juanguachi.supermercado.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import java.sql.Blob;

public class Proveedor {
    private String ruc;
    private String nombre_comercial;
    private String representante_legal;
    private String direccion;
    private String telefono;
    private String productos;
    private double credito;
    //private Blob imagen;


    //Metodos para la database
    public void agregarProveedor(Context mc){
        SqlHelper sqlHelper=new SqlHelper(mc);
        SQLiteDatabase bd=sqlHelper.getWritableDatabase();
        SQLiteStatement ps=null;
        if (bd!=null){
            ps =  bd.compileStatement("insert into Proveedor values(?,?,?,?,?,?,?)");
            ps.bindString(1, getRuc());
            ps.bindString(2, getNombre_comercial());
            ps.bindString(3, getRepresentante_legal());
            ps.bindString(4, getDireccion());
            ps.bindString(5, getTelefono());
            ps.bindString(6, getProductos());
            ps.bindDouble(7, getCredito());
            //ps.bindBlob(8, getImagen());
            ps.execute();
            ps.close();
            //bd.setTransactionSuccessful();
            Toast.makeText(mc,"Creado",Toast.LENGTH_LONG).show();
        }
    }
    public void eliminarProveedor(Context mc){
        SqlHelper sqlHelper=new SqlHelper(mc);
        SQLiteDatabase bd=sqlHelper.getWritableDatabase();
        SQLiteStatement ps=null;
        if (bd!=null){
            ps =  bd.compileStatement("delete from Proveedor where ruc = ? ");
            ps.bindString(1, getRuc());
            ps.execute();
            ps.close();
            //bd.setTransactionSuccessful();
            Toast.makeText(mc,"Eliminado",Toast.LENGTH_LONG).show();
        }
    }
    public void actualizarProveedor(Context mc){
        SqlHelper sqlHelper=new SqlHelper(mc);
        SQLiteDatabase bd=sqlHelper.getWritableDatabase();
        SQLiteStatement ps=null;
        if (bd!=null){
            ps =  bd.compileStatement("update Proveedor set " +
                    "nombre_comercial=?," +
                    "representante_legal=?," +
                    "direccion=?," +
                    "telefono=?," +
                    "productos=?," +
                    "credito=? " +
                    //"imagen=? " +
                    "where ruc=?");
            ps.bindString(7, getRuc());
            ps.bindString(1, getNombre_comercial());
            ps.bindString(2, getRepresentante_legal());
            ps.bindString(3, getDireccion());
            ps.bindString(4, getTelefono());
            ps.bindString(5, getProductos());
            ps.bindDouble(6, getCredito());
            //ps.bindBlob(8, getImagen());
            ps.execute();
            ps.close();
            //bd.setTransactionSuccessful();
            Toast.makeText(mc,"Actualizado",Toast.LENGTH_LONG).show();
        }
    }
    public static Cursor listarProveedor(Context mc){
        SqlHelper sqlHelper=new SqlHelper(mc);
        String sql="select _rowid_ as _id,* from Proveedor";
        return sqlHelper.getReadableDatabase().rawQuery(sql,null);
    }
    //Geters y seters

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public void setRepresentante_legal(String representante_legal) {
        this.representante_legal = representante_legal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    /*
    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

     */
}
