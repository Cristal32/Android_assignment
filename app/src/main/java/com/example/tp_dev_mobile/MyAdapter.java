package com.example.tp_dev_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Etablissement> etablissements;
    private Context context;
    public MyAdapter(Context context, ArrayList<Etablissement> etablissements) {
        this.context = context;
        this.etablissements = etablissements;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new ViewHolder(listItem);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Etablissement currentEtablissement = etablissements.get(position);
        holder.image.setImageResource(currentEtablissement.getImg());
        holder.label.setText(currentEtablissement.getLabel());
        holder.name.setText(currentEtablissement.getName());
    }
    @Override
    public int getItemCount() {
        return etablissements.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView label;
        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.img);
            this.label = itemView.findViewById(R.id.text_label);
            this.name = itemView.findViewById(R.id.text_name);
        }
    }

}
