package com.app.examenprimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    ArrayList<Prendas> listaprenda=null;
    ArrayList<Carrito> listacarrito=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        if(b!=null){
            listaprenda=(ArrayList<Prendas>)b.getSerializable("data");
            listacarrito=(ArrayList<Carrito>)b.getSerializable("datacarrito");

        }else{
            listaprenda=new ArrayList<>();
            listacarrito=new ArrayList<>();
        }
    }

    public void Ir_a_Registrar(View v){
        Intent i=new Intent(this,RegistrarPrendaActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("data",listaprenda);
        b.putSerializable("datacarrito",listacarrito);
        i.putExtras(b);
        startActivity(i);
    }

    public  void Ir_a_Listar(View v){
        Intent i=new Intent(this,MainActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("data",listaprenda);
        b.putSerializable("datacarrito",listacarrito);
        i.putExtras(b);
        startActivity(i);
    }

    public  void Ir_a_Listar_carrito(View v){
        Intent i=new Intent(this,CarritoActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("datacarrito",listacarrito);
        i.putExtras(b);
        startActivity(i);
    }

}