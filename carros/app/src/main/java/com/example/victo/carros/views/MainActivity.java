package com.example.victo.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.victo.carros.Constants.CarrosConstants;
import com.example.victo.carros.Data.CarMock;
import com.example.victo.carros.R;
import com.example.victo.carros.adapter.CarListAdapter;
import com.example.victo.carros.entities.Car;
import com.example.victo.carros.listener.onListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   ViewHolder mViewHolder = new ViewHolder();

   private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mContext = this;
        CarMock carMock = new CarMock(this);
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        // obter a recyclerView
        this.mViewHolder.recyclerCars = this.findViewById(R.id.recycler_cars);


        onListClickInteractionListener listener = new onListClickInteractionListener() {
            @Override
            public void onclick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);

                Intent integer = new Intent(mContext, DetailsActivity.class);
                integer.putExtras(bundle);
                startActivity(integer);
            }
        };

        //Definir adapter
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.mViewHolder.recyclerCars.setAdapter(carListAdapter);

        //Definir um layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewHolder.recyclerCars.setLayoutManager(linearLayoutManager);

    }

    private static class ViewHolder
    {
        RecyclerView recyclerCars;
    }


}
