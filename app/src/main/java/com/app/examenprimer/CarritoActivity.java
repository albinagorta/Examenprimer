package com.app.examenprimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CarritoActivity extends AppCompatActivity {
    ListView lstcar;
    ArrayList<Carrito> datacar=null;
    double total=0;
    TextView txtmostrartotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        lstcar=findViewById(R.id.lstcar);
        txtmostrartotal=findViewById(R.id.txtmostrartotal);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        if(b!=null){
            datacar=(ArrayList<Carrito>)b.getSerializable("datacarrito");
        }else{
            datacar=new ArrayList<>();
        }

        List<String> dataNom=new ArrayList<>();
        for(Carrito c:datacar){
            dataNom.add("Prenda: "+c.getNombre()+"\n Talla:"+c.getTalla()+"\n Precio:"+c.getPrecio());
            total+=c.getPrecio();
        }

        txtmostrartotal.setText(total+"");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,dataNom);
        lstcar.setAdapter(adapter);
    }

    public  void RealizarPedidos(View v){
        datacar.clear();
        Toast.makeText(this, "REALIZADO CON EXITO", Toast.LENGTH_SHORT).show();
    }

}