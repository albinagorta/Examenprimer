package com.app.examenprimer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ActDetalle extends Fragment {
    TextView txvNom,txvcantida,txvprecio,txvtalla;
    Button btnagreagr_car;

    ArrayList<Carrito> listcar=null;
    String nombreprenda;
    String tallarenda;
    double precioprend;
    Carrito ca;
    //ImageView imgFoto;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.act_detalle,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listcar=new ArrayList<>();
        listcar=((IComonucacion)getActivity()).seleccionarCar();
        txvNom=getView().findViewById(R.id.txtNom_d);
        txvcantida=getView().findViewById(R.id.txtstock_d);
        txvprecio=getView().findViewById(R.id.txtprecio_d);
        txvtalla=getView().findViewById(R.id.txttalla_d);
        btnagreagr_car=getView().findViewById(R.id.btnagreagr_car);



        btnagreagr_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreprenda=txvNom.getText().toString();
                precioprend=Double.parseDouble(txvprecio.getText().toString());
                tallarenda=(txvtalla.getText().toString());
                ca= new Carrito();
                ca.setNombre(nombreprenda);
                ca.setTalla(tallarenda);
                ca.setPrecio(precioprend);
                Toast.makeText(getActivity(), "Se Agrego al Carrito", Toast.LENGTH_SHORT).show();
                listcar.add(ca);

            }
        });
    }

    public  void mostrarDatos(Prendas p){
        txvNom.setText(p.getNombre());
        txvcantida.setText(p.getCantidad()+"");
        txvprecio.setText(p.getPrecios()+"");
        txvtalla.setText(p.getTalla());
       // imgFoto.setImageResource(p.getImagen());
    }
}
