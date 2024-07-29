package com.example.projetoestagioaiko.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoestagioaiko.R;
import com.example.projetoestagioaiko.models.LinhaOnibus;

import java.util.List;

public class LinhaOnibusAdapter extends RecyclerView.Adapter<LinhaOnibusAdapter.ViewHolder> {
    private List<LinhaOnibus> linhas;

    public LinhaOnibusAdapter(List<LinhaOnibus> linhas) {
        this.linhas = linhas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linha_onibus,parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LinhaOnibus linha = linhas.get(position);
        holder.numeroLinha.setText(linha.getNumero());
        holder.nomeLinha.setText(linha.getNome());
    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView numeroLinha;
        public TextView nomeLinha;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numeroLinha = itemView.findViewById(R.id.numero_linha);
            nomeLinha = itemView.findViewById(R.id.nome_linha);
        }
    }

}
