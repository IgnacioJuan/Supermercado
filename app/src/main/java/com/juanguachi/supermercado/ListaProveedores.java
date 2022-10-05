package com.juanguachi.supermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.juanguachi.supermercado.model.Proveedor;

public class ListaProveedores extends AppCompatActivity implements SearchView.OnQueryTextListener{


    Button refrescar;
    SearchView txt_buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_proveedores);

        findid();
        ListarProveedores();
    }

    public void findid(){
        refrescar=findViewById(R.id.btn_refrescar);
        txt_buscar=findViewById(R.id.sv_busqueda);

        //
        refrescar.setOnClickListener(listarproveedores);
        txt_buscar.setOnQueryTextListener(this);
    }

    View.OnClickListener listarproveedores=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ListarProveedores();
        }
    };

    private void ListarProveedores(){

        ListView listView = (ListView) findViewById(R.id.Listaproveedor);
        Cursor cursor = Proveedor.listarProveedor(ListaProveedores.this);
        String[] desde = new String[]{
                "ruc",
                "nombre_comercial",
                "representante_legal",
                "direccion",
                "telefono",
                "productos",
                "credito"
        };
        int[] hasta = new int[]{
                R.id.txtRUC,
                R.id.txtNOMBRE,
                R.id.txtREPRESENTANTE,
                R.id.txtDIRECCION,
                R.id.txtTELEFONO,
                R.id.txtPRODUCTOS,
                R.id.txtCREDITO
        };

        CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                ListaProveedores.this,
                R.layout.detalleproveedores,
                cursor,
                desde,
                hasta, 0
        );

        listView.setAdapter(cursorAdapter);
    }

    private void BuscarProveedores(String param){

        ListView listView = (ListView) findViewById(R.id.Listaproveedor);
        Cursor cursor = Proveedor.buscarProveedor(ListaProveedores.this,param);
        String[] desde = new String[]{
                "ruc",
                "nombre_comercial",
                "representante_legal",
                "direccion",
                "telefono",
                "productos",
                "credito"
        };
        int[] hasta = new int[]{
                R.id.txtRUC,
                R.id.txtNOMBRE,
                R.id.txtREPRESENTANTE,
                R.id.txtDIRECCION,
                R.id.txtTELEFONO,
                R.id.txtPRODUCTOS,
                R.id.txtCREDITO
        };

        CursorAdapter cursorAdapter = new SimpleCursorAdapter(
                ListaProveedores.this,
                R.layout.detalleproveedores,
                cursor,
                desde,
                hasta, 0
        );

        listView.setAdapter(cursorAdapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        BuscarProveedores(newText);
        return false;
    }
}