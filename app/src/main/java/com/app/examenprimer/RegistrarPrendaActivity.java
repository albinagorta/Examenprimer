package com.app.examenprimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegistrarPrendaActivity extends AppCompatActivity {
    EditText edtnom,edtid,edtstock,edtprecio,edtcantida;
    ArrayList<Prendas> listaprendas=null;
    ArrayList<Carrito> listcar=null;
    Spinner sptalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_prenda);
        inicializarListra();
        AsignarReferencias();
    }

    private void AsignarReferencias() {
        edtnom=findViewById(R.id.txtnom_r);
        edtid=findViewById(R.id.txtcod_r);
        edtstock=findViewById(R.id.txtstock_r);
        edtprecio=findViewById(R.id.txtprecio_r);
        edtcantida=findViewById(R.id.txtcant_r);
        sptalla=findViewById(R.id.spinnertalla);
    }

    private void inicializarListra() {
        Bundle b=getIntent().getExtras();
        listaprendas=(ArrayList<Prendas>)b.getSerializable("data");
        listcar=(ArrayList<Carrito>)b.getSerializable("datacarrito");
    }

    public void Registrar(View v){
        String nombre,talla;
        double precio;
        int stock,id,cantidad;
        id=Integer.parseInt(edtid.getText().toString());
        nombre=edtnom.getText().toString();
        cantidad=Integer.parseInt(edtcantida.getText().toString());
        stock=Integer.parseInt(edtstock.getText().toString());
        precio=Double.parseDouble(edtprecio.getText().toString());
        talla=(sptalla.getSelectedItem().toString());

        listaprendas.add(new Prendas(id,nombre,talla,precio,cantidad,stock));
        edtnom.setText("");
        edtid.setText("");
        edtstock.setText("");
        edtprecio.setText("");
        edtcantida.setText("");
        sptalla.setSelection(0);
        edtid.requestFocus();
    }

    public  void  regresar_de_registrar(View v){
        Intent i=new Intent(this,MenuActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("data",listaprendas);
        b.putSerializable("datacarrito",listcar);
        i.putExtras(b);
        startActivity(i);
    }


}