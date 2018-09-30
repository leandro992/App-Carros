package com.example.victo.carros.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.victo.carros.R;
import com.example.victo.carros.entities.Car;
import com.example.victo.carros.listener.onListClickInteractionListener;

public class CarViewHolder  extends RecyclerView.ViewHolder{


    private TextView mTextCarModel;
    private ImageView mImageCarPicture;
    private TextView mTextViewDetails;


    public CarViewHolder(View itemView) {
        super(itemView);
        this.mTextCarModel = itemView.findViewById(R.id.text_car_model);
        this.mImageCarPicture = itemView.findViewById(R.id.img_car_row);
        this.mTextViewDetails = itemView.findViewById(R.id.text_view_details);
    }


    public void bindData(final Car car, final onListClickInteractionListener listener){
        this.mImageCarPicture.setImageDrawable(car.picture);
        this.mTextCarModel.setText(car.model);


        this.mTextViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onclick(car.id);
            }
        });
    }

}

