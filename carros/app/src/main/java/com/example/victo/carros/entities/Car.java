package com.example.victo.carros.entities;

import android.graphics.drawable.Drawable;

public class Car {
    public int id;
    public String model;
    public String manufacturer;
    public int horsePower;
    public double price;
    public Drawable picture;

    public Car(int id, String model, String manufacturer, int horsePower, double price, Drawable picture) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.horsePower = horsePower;
        this.price = price;
        this.picture = picture;
    }
}
