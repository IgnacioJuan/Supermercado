package com.juanguachi.supermercado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.juanguachi.supermercado.model.Proveedor;

public class MainActivity extends AppCompatActivity {

    //
    EditText txtruc, txtnombre, txtrepresentante, txtdireccion, txttelefono, txtproductos, txtcredito;
    Button btnagregar, btnactualizar, btneliminar, btnSeleccionar;

    ImageView imagen;
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
        btnSeleccionar= (Button) findViewById(R.id.btn_SeleccionarImagen);
        //Imagen
        imagen = (ImageView) findViewById(R.id.iv_imagen);
        //eventos
        btnagregar.setOnClickListener(guardarListener);
        btnactualizar.setOnClickListener(actualizarListener);
        btneliminar.setOnClickListener(eliminarListener);
        btnSeleccionar.setOnClickListener(Seleccionarimagen);
    }


    //Listeners

    View.OnClickListener Seleccionarimagen= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cargarImagen();
        }
    };

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }

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