package com.example.trabajopractico3moyano.ui.listar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.trabajopractico3moyano.R;
import com.example.trabajopractico3moyano.modelo.Nota;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListarNotaAdapter extends RecyclerView.Adapter<ListarNotaAdapter.ViewHolderListarNota> {
    private List<Nota> notas;
    private LayoutInflater li;

    public ListarNotaAdapter(List<Nota> notas, LayoutInflater li) {
        this.notas = notas;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderListarNota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderListarNota(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderListarNota holder, int position) {
        Nota nota = notas.get(position);
        holder.tvNombreNota.setText(nota.getTitulo());
        holder.tvContenidoNota.setText(nota.getNota());
    }

    @Override
    public int getItemCount() {
        return notas == null ? 0 : notas.size();
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
        notifyDataSetChanged();
    }
    public class ViewHolderListarNota extends RecyclerView.ViewHolder{
        TextView tvContenidoNota, tvNombreNota;

        public ViewHolderListarNota(@NonNull View itemView) {
            super(itemView);
            tvContenidoNota = itemView.findViewById(R.id.tvContenidoNota);
            tvNombreNota = itemView.findViewById(R.id.tvNombreNota);
        }
    }
}