package com.andrewsensity.pets.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.andrewsensity.pets.R;
import com.andrewsensity.pets.Pojos.Mascota;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public PetAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pet,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.tvCounterLikes.setText(mascota.getNoLikes());

        mascotaViewHolder.btnLikeMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.addLikes();
                Toast.makeText(activity,"Diste Like a: "+mascota.getNombreMascota() + " Cuenta con "+ mascota.getNoLikes() +" Likes.",Toast.LENGTH_SHORT).show();
                mascotaViewHolder.tvCounterLikes.setText(mascota.getNoLikes());
            }
        });
    }
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascota;
        private TextView tvNombreMascota;
        private TextView tvCounterLikes;
        private ImageButton btnLikeMascota;

        public MascotaViewHolder(View itemView){
            super(itemView);

            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvCounterLikes = (TextView) itemView.findViewById(R.id.tvCounterLikes);
            btnLikeMascota = (ImageButton) itemView.findViewById(R.id.btnLikeMascota);
        }
    }
}

