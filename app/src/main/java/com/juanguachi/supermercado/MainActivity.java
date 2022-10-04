package com.juanguachi.supermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.juanguachi.supermercado.model.Proveedor;

public class MainActivity extends AppCompatActivity {

    //
    EditText txtruc, txtnombre, txtrepresentante, txtdireccion, txttelefono, txtproductos, txtcredito;
    Button btnagregar, btnlistar, btnactualizar, btneliminar;

    //ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findid();

    }

    private void findid() {
        //txt
        txtdireccion = (EditText) findViewById(R.id.txt_direccion);
        txtcredito = (EditText) findViewById(R.id.txt_credito);
        txtnombre = (EditText) findViewById(R.id.txt_nombrecomercial);
        txtproductos = (EditText) findViewById(R.id.txt_productos);
        txtrepresentante = (EditText) findViewById(R.id.txt_representantelegal);
        txtruc = (EditText) findViewById(R.id.txt_ruc);
        txttelefono = (EditText) findViewById(R.id.txt_telefono);
        //Button
        btnagregar = (Button) findViewById(R.id.btn_agregar);
        btnactualizar = (Button) findViewById(R.id.btn_editar);
        btneliminar = (Button) findViewById(R.id.btn_eliminar);
        btnlistar = (Button) findViewById(R.id.btn_listar);
        //Imagen

        //eventos
        btnagregar.setOnClickListener(guardarListener);
        btnactualizar.setOnClickListener(actualizarListener);
        btneliminar.setOnClickListener(eliminarListener);
        btnlistar.setOnClickListener(listarListener);

    }


    //Listeners
    View.OnClickListener listarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ListView listView = (ListView) findViewById(R.id.listproveedores);
            Cursor cursor = Proveedor.listarProveedor(getApplicationContext());
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
                    getApplicationContext(),
                    R.layout.detalleproveedores,
                    cursor,
                    desde,
                    hasta, 0
            );
            listView.setAdapter(cursorAdapter);
        }
    };
    View.OnClickListener guardarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Proveedor proveedor = new Proveedor();
            proveedor.setCredito(Double.parseDouble(txtcredito.getText().toString()));
            proveedor.setDireccion(txtdireccion.getText().toString());
            proveedor.setProductos(txtproductos.getText().toString());
            proveedor.setNombre_comercial(txtnombre.getText().toString());
            proveedor.setRepresentante_legal(txtrepresentante.getText().toString());
            proveedor.setRuc(txtruc.getText().toString());
            proveedor.setTelefono(txttelefono.getText().toString());

            proveedor.agregarProveedor(getApplicationContext());
        }
    };
    View.OnClickListener actualizarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener eliminarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}