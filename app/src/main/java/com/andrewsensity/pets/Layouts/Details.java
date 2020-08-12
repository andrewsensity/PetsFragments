package com.andrewsensity.pets.Layouts;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andrewsensity.pets.R;
import com.andrewsensity.pets.Adapters.PetAdapter;
import com.andrewsensity.pets.Pojos.Mascota;

import java.util.ArrayList;

public class Details extends AppCompatActivity{
    private RecyclerView listMascotas;
    ArrayList<Mascota> mascotas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_titulo);
        toolbar_title.setText(R.string.txtFavoritos);

        Button btnShowCollection = (Button) findViewById(R.id.btnShowCollection);
        btnShowCollection.setVisibility(View.GONE);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        listMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listMascotas.setLayoutManager(llm);

        initMascotas();
        inicilizarAdaptador();
    }
    private void inicilizarAdaptador(){
        PetAdapter adaptador = new PetAdapter(mascotas,this);
        listMascotas.setAdapter(adaptador);
    }

    public void initMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(1, "Ginebra", R.drawable.horse, "2"));
        mascotas.add(new Mascota(1, "Mike", R.drawable.dolphin,"5"));
        mascotas.add(new Mascota(1, "Billy", R.drawable.grampus, "1"));
        mascotas.add(new Mascota(1, "Smeagol", R.drawable.eagle, "8"));
        mascotas.add(new Mascota(1, "Arthur", R.drawable.bear, "6"));
        /*
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1,"Daysi",R.drawable.pez,"4"));
        mascotas.add(new Mascota(1,"Coto",R.drawable.loro,"6"));
        mascotas.add(new Mascota(1,"Perry",R.drawable.perro,"8"));
        mascotas.add(new Mascota(1,"Gonza",R.drawable.leon,"5"));
        mascotas.add(new Mascota(1,"Pingu",R.drawable.pinguino,"1"));
         */

    }
}
