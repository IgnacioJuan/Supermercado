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
    Button btnagregar, btnactualizar, btneliminar;

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
        //Imagen

        //eventos
        btnagregar.setOnClickListener(guardarListener);
        btnactualizar.setOnClickListener(actualizarListener);
        btneliminar.setOnClickListener(eliminarListener);

    }


    //Listeners
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
            Proveedor proveedor = new Proveedor();
            proveedor.setCredito(Double.parseDouble(txtcredito.getText().toString()));
            proveedor.setDireccion(txtdireccion.getText().toString());
            proveedor.setProductos(txtproductos.getText().toString());
            proveedor.setNombre_comercial(txtnombre.getText().toString());
            proveedor.setRepresentante_legal(txtrepresentante.getText().toString());
            proveedor.setRuc(txtruc.getText().toString());
            proveedor.setTelefono(txttelefono.getText().toString());

            proveedor.actualizarProveedor(getApplicationContext());
        }
    };
    View.OnClickListener eliminarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Proveedor proveedor = new Proveedor();
            proveedor.setRuc(txtruc.getText().toString());
            proveedor.eliminarProveedor(getApplicationContext());
        }
    };
}