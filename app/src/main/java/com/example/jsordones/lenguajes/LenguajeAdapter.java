package com.example.jsordones.lenguajes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class LenguajeAdapter extends RecyclerView.Adapter<LenguajeAdapter.LenguajeViewholder> {

    List<Lenguaje> dataset;
    Context context;
    onLenguajeSelectedListener onLenguajeSelectedListener;

    public interface onLenguajeSelectedListener{
        void onLenguajeSelected(Lenguaje lenguaje);
    }

    public LenguajeAdapter(Context context, onLenguajeSelectedListener onLenguajeSelectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onLenguajeSelectedListener = onLenguajeSelectedListener;
    }

    @Override
    public LenguajeViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lenguaje,parent,false);
        return new LenguajeViewholder(view);
    }

    @Override
    public void onBindViewHolder(LenguajeViewholder holder, int position) {
        Lenguaje lenguaje = dataset.get(position);
        holder.nombre.setText(lenguaje.getNombre());
        holder.imagen.setImageResource(lenguaje.getImagen());

        holder.setOnLenguajeSelectedListener(lenguaje, onLenguajeSelectedListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class LenguajeViewholder extends RecyclerView.ViewHolder {

        View cardView;
        ImageView imagen;
        TextView nombre;

        public LenguajeViewholder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.texto_item);
        }

        public void setOnLenguajeSelectedListener(final Lenguaje equipo, final onLenguajeSelectedListener onEquipoSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEquipoSelectedListener.onLenguajeSelected(equipo);
                }
            });
        }
    }

    public void setDataset(List<Lenguaje> lenguaje) {
        if (lenguaje == null){
            dataset = new ArrayList<>();
        }
        else{
            dataset = lenguaje;
        }
        notifyDataSetChanged();
    }
}
