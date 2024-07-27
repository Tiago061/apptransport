package com.example.projetoestagioaiko.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoestagioaiko.R;
import com.example.projetoestagioaiko.models.Parada;
import com.example.projetoestagioaiko.viewHolders.ParadaViewHolder;

import java.util.List;

public class ParadaAdapter extends RecyclerView.Adapter<ParadaViewHolder> {
    private List<Parada> paradas;

    public ParadaAdapter(List<Parada> paradas) {
        this.paradas = paradas;
    }

    @NonNull
    @Override
    public ParadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parada,parent, false);
        return new ParadaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParadaViewHolder holder, int position) {
        Parada parada = paradas.get(position);
        holder.tvCodigoParada.setText(String.valueOf(parada.getCodigo()));
        holder.tvNomeParada.setText(parada.getNome());

    }

    @Override
    public int getItemCount() {
        return paradas.size();
    }

}
