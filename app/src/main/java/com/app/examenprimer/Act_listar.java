package com.app.examenprimer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Act_listar  extends Fragment {
    ListView lstPre;
    ArrayList<Prendas> data=null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.act_listar,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstPre=getView().findViewById(R.id.lstpre);
        data=((IComonucacion)getActivity()).seleccionarmostrar();

        List<String> dataNom=new ArrayList<>();

        for(Prendas p:data){
            dataNom.add("prenda: "+p.getNombre()+"\n Precio:"+p.getPrecios());
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,dataNom);
        lstPre.setAdapter(adapter);
        lstPre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((IComonucacion)getActivity()).seleccionarPrendas(data.get(position));
            }
        });
    }

}
