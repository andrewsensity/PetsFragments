package com.andrewsensity.pets.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewsensity.pets.R;
import com.andrewsensity.pets.Pojos.Mascota;
import com.andrewsensity.pets.Adapters.PetAdapter;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> miMascota;
    private RecyclerView fotosMiMascota;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        fotosMiMascota = (RecyclerView) view.findViewById(R.id.recyclerFragmentMiMascota);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        fotosMiMascota.setLayoutManager(gridLayoutManager);

        inicializarListaMiMascota();
        inicializarAdaptador();

        return view;
    }

    public void inicializarListaMiMascota(){

        miMascota = new ArrayList<Mascota>();

        miMascota.add(new Mascota(R.drawable.horse1, "5"));
        miMascota.add(new Mascota(R.drawable.horse2, "3"));
        miMascota.add(new Mascota(R.drawable.horse3, "9"));
        miMascota.add(new Mascota(R.drawable.horse4, "1"));
        miMascota.add(new Mascota(R.drawable.horse5, "8"));
        miMascota.add(new Mascota(R.drawable.horse6, "6"));

        /*
        miMascota = new ArrayList<Mascota>();
        miMascota.add(new Mascota(R.drawable.gato1, "5"));
        miMascota.add(new Mascota(R.drawable.gato2, "3"));
        miMascota.add(new Mascota(R.drawable.gato3, "9"));
        miMascota.add(new Mascota(R.drawable.gato4, "1"));
        miMascota.add(new Mascota(R.drawable.gato5, "8"));
        miMascota.add(new Mascota(R.drawable.gato6, "6"));
         */
    }


    public void inicializarAdaptador(){

        PetAdapter adaptador = new PetAdapter(miMascota, getActivity());
        fotosMiMascota.setAdapter(adaptador);

    }

}
