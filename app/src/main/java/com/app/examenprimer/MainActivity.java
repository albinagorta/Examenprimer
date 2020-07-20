package com.app.examenprimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  IComonucacion{
    Act_listar fgtLista;
    ActDetalle fgtDetalle;
    ArrayList<Prendas> data=null;
    ArrayList<Carrito> datacarrito=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datacarrito=(ArrayList<Carrito>)getIntent().getExtras().getSerializable("datacarrito");
        asignarReferencias();
        data=(ArrayList<Prendas>)getIntent().getExtras().getSerializable("data");
    }
    private void asignarReferencias() {
        fgtLista= (Act_listar) getSupportFragmentManager().findFragmentById(R.id.fgtLis);
        fgtDetalle= (ActDetalle) getSupportFragmentManager().findFragmentById(R.id.fgtDet);
    }


    @Override
    public void seleccionarPrendas(Prendas prendas) {
        fgtDetalle.mostrarDatos(prendas);
    }

    @Override
    public ArrayList<Prendas> seleccionarmostrar() {
        data=(ArrayList<Prendas>)getIntent().getExtras().getSerializable("data");
        return data;
    }

    @Override
    public ArrayList<Carrito> seleccionarCar() {
        datacarrito=(ArrayList<Carrito>)getIntent().getExtras().getSerializable("datacarrito");
        return datacarrito;
    }

    public  void  regresar_de_listar(View v){
        Intent i=new Intent(this,MenuActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("data",data);
        b.putSerializable("datacarrito",datacarrito);
        i.putExtras(b);
        startActivity(i);
    }

}