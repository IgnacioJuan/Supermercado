package com.juanguachi.supermercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    Button crud,lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);


        findid();
    }
    public void findid (){
        crud=findViewById(R.id.btn_crud);
        lista=findViewById(R.id.btn_verproveedores);
        //eventos
        crud.setOnClickListener(iniciarMain);
        lista.setOnClickListener(iniciarLista);

    }
    View.OnClickListener iniciarMain=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener iniciarLista=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), ListaProveedores.class);
            startActivity(intent);
        }
    };
}