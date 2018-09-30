package com.example.victo.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.victo.carros.Constants.CarrosConstants;
import com.example.victo.carros.Data.CarMock;
import com.example.victo.carros.R;
import com.example.victo.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {


    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mcarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mcarMock = new CarMock(this);
        this.mViewHolder.imgCarPicture =  this.findViewById(R.id.img_car_pic);
        this.mViewHolder.texManufacturer = this.findViewById(R.id.fabricante);
        this.mViewHolder.textModel = this.findViewById(R.id.text_modelo);
        this.mViewHolder.textHorsePower = this.findViewById(R.id.text_host_power);
        this.mViewHolder.textPrice =  this.findViewById(R.id.text_price);

        this.getDataFromActivity();

        this.setData();
    }

    private void setData(){
        this.mViewHolder.imgCarPicture.setImageDrawable(this.mCar.picture);
        this.mViewHolder.texManufacturer.setText(this.mCar.manufacturer);
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText("R$ " + String.valueOf(this.mCar.price));
    }


    private void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null){
         this.mCar = this.mcarMock.get(extras.getInt(CarrosConstants.CARRO_ID));
        }
    }

    private static class ViewHolder{
        ImageView imgCarPicture;
        TextView texManufacturer;
        TextView textModel;
        TextView textHorsePower;
        TextView textPrice;

    }


}
