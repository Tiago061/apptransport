package com.example.projetoestagioaiko.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoestagioaiko.R;
import com.example.projetoestagioaiko.models.Linha;
import com.example.projetoestagioaiko.viewHolders.LinhaViewHolder;

import java.util.List;

public class LinhaAdapter extends RecyclerView.Adapter<LinhaViewHolder> {
    private List<Linha> linhas;

    public LinhaAdapter(List<Linha> linhas) {
        this.linhas = linhas;
    }

    @NonNull
    @Override
    public LinhaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linha,parent, false);
        return new LinhaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinhaViewHolder holder, int position) {
        Linha linha = linhas.get(position);
        holder.tvCodigoLinha.setText(linha.getCodigo());
        holder.tvNomeLinha.setText(linha.getNome());

    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewLinha;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLinha = itemView.findViewById(R.id.textViewLinha);
        }
    }

}
