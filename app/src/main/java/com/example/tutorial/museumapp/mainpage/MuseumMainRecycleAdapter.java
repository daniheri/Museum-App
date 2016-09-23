package com.example.tutorial.museumapp.mainpage;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tutorial.museumapp.R;
import com.example.tutorial.museumapp.databinding.ItemProvinsiBinding;
import com.example.tutorial.museumapp.response.ProvinsiResponse;

import java.util.ArrayList;
import java.util.List;

public class MuseumMainRecycleAdapter extends RecyclerView.Adapter<MuseumMainRecycleAdapter.ViewHolder> {

    private ArrayList<ProvinsiResponse.Datum> serviceArrayList;
    private OnItemClickListener itemClickListener;

    public MuseumMainRecycleAdapter(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        serviceArrayList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemProvinsiBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_provinsi,parent,false);
        return new ViewHolder(binding,itemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setViewModel(new MuseumRecylerViewModel(serviceArrayList.get(position)));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return serviceArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemProvinsiBinding binding;
        private OnItemClickListener listener;

        public ViewHolder(ItemProvinsiBinding binding, OnItemClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public ArrayList<ProvinsiResponse.Datum> getData() {
        return serviceArrayList;
    }

    public void add(List<ProvinsiResponse.Datum> data) {
        serviceArrayList.clear();
        serviceArrayList.addAll(data);
        notifyDataSetChanged();
    }
}
