package com.lina.animalsapp;

import android.widget.ImageView;
import android.widget.TextView;

public class Animal {
    String animalName;
    int animalImage;
    public Animal(String animalName, int animalImage){
        this.animalImage = animalImage;
        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(int animalImage) {
        this.animalImage = animalImage;
    }
}
