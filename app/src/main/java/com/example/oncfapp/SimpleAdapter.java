package com.example.oncfapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {


    ArrayList<SimpleViewModel> SimpleViewModels;
    Context context;

    public SimpleAdapter(Context context, ArrayList<SimpleViewModel> ViewModel) {
        this.SimpleViewModels = ViewModel;
        this.context = context;
    }

    // Method that creates a view from a layout ressource xml
    public SimpleViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(context).inflate(viewType, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override


    public void onBindViewHolder(SimpleViewHolder holder, int position) {

        holder.date.setText(SimpleViewModels.get(position).getDate());
        holder.Details.setText(SimpleViewModels.get(position).getDetails());
        holder.Voiture.setText(SimpleViewModels.get(position).getVoiture());
        holder.equipement.setText(SimpleViewModels.get(position).getEquipement());

    }


    public int getItemCount() {
        return this.SimpleViewModels.size();
    }

    public int getItemViewType(final int position) {
        return R.layout.list_items;
    }

    public class SimpleViewHolder extends RecyclerView.ViewHolder {
        private TextView date;
        private TextView Details;
        private TextView Voiture;
        private TextView equipement;


        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            Details = itemView.findViewById(R.id.details);
            date = itemView.findViewById(R.id.date);
            Voiture = itemView.findViewById(R.id.voiture);
            equipement = itemView.findViewById(R.id.equipement);
        }
    }

}








