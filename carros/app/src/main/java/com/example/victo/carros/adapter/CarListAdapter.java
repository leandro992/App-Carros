package com.example.victo.carros.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import com.example.victo.carros.R;
import com.example.victo.carros.entities.Car;
import com.example.victo.carros.listener.onListClickInteractionListener;
import com.example.victo.carros.viewHolder.CarViewHolder;

import java.util.List;

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder>{

    private List<Car> mlistCars;

    private onListClickInteractionListener monListClickInteractionListener;

    public CarListAdapter(List<Car> cars, onListClickInteractionListener listener){
        this.mlistCars = cars;
        this.monListClickInteractionListener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

       View carView = inflater.inflate(R.layout.row_car_list, parent, false);
        return new CarViewHolder(carView);

    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        Car car = this.mlistCars.get(position);
        holder.bindData(car, this.monListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
       return this.mlistCars.size();
    }
}
