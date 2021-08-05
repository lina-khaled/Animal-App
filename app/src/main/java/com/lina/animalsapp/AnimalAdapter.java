package com.lina.animalsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder> {

    ArrayList<Animal> animals;
    Context context;
    myClickedInterface myClickedInterface;


    public AnimalAdapter(ArrayList<Animal> animals, Context context, myClickedInterface myClickedInterface){
        this.animals = animals;
        this.context = context;
        this.myClickedInterface = myClickedInterface;
    }

    @NonNull
    @Override
    // it creates the item
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    // it fills the item with the specified data
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.txtAnimalName.setText(animals.get(position).getAnimalName());
        holder.imgAnimal.setImageResource(animals.get(position).getAnimalImage());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class AnimalRowHolder extends RecyclerView.ViewHolder{
        TextView txtAnimalName;
        ImageView imgAnimal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            txtAnimalName = (TextView) itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = (ImageView) itemView.findViewById(R.id.image_animal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myClickedInterface.onClickedItem(getAdapterPosition());
                }
            });
        }
    }
    // interface
    interface myClickedInterface{
        void onClickedItem(int positionOfTheAnimal);


    }
}
