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

    /* we only declare these variables with the default values, so when we send the array, context,
     and the interface from the MainActivity, the constructor will assign those values to them */
    ArrayList<Animal> animals;
    Context context;
    /* in order to link our interface to the Adapter, we must declare (not create) an object from it
    * , and then add it to the constructor */
    myClickedInterface myClickedInterface;

    // constructor, it assigns the values we sent from the MainActivity to the variables above
    public AnimalAdapter(ArrayList<Animal> animals, Context context, myClickedInterface myClickedInterface){
        this.animals = animals;
        this.context = context;
        this.myClickedInterface = myClickedInterface;
    }

    @NonNull
    @Override
    // SECOND: it creates the item
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent, false);
        return new AnimalRowHolder(view);
    }

    @Override
    // THIRD: it fills the item with the specified data
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        // set the text & image of each object created ,, holder --> object ,, position --> index
        holder.txtAnimalName.setText(animals.get(position).getAnimalName());
        holder.imgAnimal.setImageResource(animals.get(position).getAnimalImage());
    }

    @Override
    // it return the number of objects ( animals ) in the RecyclerView that we created
    public int getItemCount() {
        return animals.size();
    }

    public class AnimalRowHolder extends RecyclerView.ViewHolder{ // ViewHolder class will only finds the views
        // Declare the views
        TextView txtAnimalName;
        ImageView imgAnimal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            // FIRST: inside the constructor, we will find the views (by id) using itemView
            txtAnimalName = (TextView) itemView.findViewById(R.id.txt_animal_name);
            imgAnimal = (ImageView) itemView.findViewById(R.id.image_animal);

            /* we put setOnClickListener in the ViewHolder , because ViewHolder has our
            * item ( itemView ), it catch every item and deals with it, so we want when it catchs
            *  the item that we clicked on it, it implements this method*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   /* here, inside the onClick method, I tell the ViewHolder when I click the item,
                    bring me its position, why? because our interface method (onClickedItem) takes
                    the position, so we need to find it by using getAdapterPosition(), and then it
                    sends it to the myClickedInterface in the MainActivity */
                    myClickedInterface.onClickedItem(getAdapterPosition());
                }
            });
        }
    }
    /* we need interface to do some actions when we click on the item ( animal ) by using
    * setOnClickListener */
    interface myClickedInterface{
        void onClickedItem(int positionOfTheAnimal);
    }
}
