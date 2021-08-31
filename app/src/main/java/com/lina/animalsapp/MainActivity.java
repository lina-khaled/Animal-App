package com.lina.animalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.myClickedInterface{

    /* to link the interface with the MainActivity, we didn't say implements myClickedInterface,
    because we didn't create an interface in the com.lina.animalsapp, so it will cause an error,
    because we create the interface in the AnimalAdapter class, so we have to tell him that you
    will find our interface there, that's why we said implements AnimalAdapter.myClickedInterface,
    which means go there and u will find it */

    RecyclerView recyclerView; // define RecyclerView
    ArrayList<Animal> animals; // define array objects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView); // find the RecyclerView by id

        animals = new ArrayList<>(); // create the animals array , and add objects to it
        animals.add(new Animal("Lion", R.drawable.lion));
        animals.add(new Animal("elephant", R.drawable.elephant));
        animals.add(new Animal("hedgehog", R.drawable.hedgehog));
        animals.add(new Animal("horse", R.drawable.horses));
        animals.add(new Animal("Dog", R.drawable.husky));
        animals.add(new Animal("lynx", R.drawable.lynx));
        animals.add(new Animal("owl", R.drawable.owl));
        animals.add(new Animal("swan", R.drawable.swan));
        animals.add(new Animal("cat", R.drawable.cat));
        animals.add(new Animal("wolf", R.drawable.wolf));

        /* create adapter, and send the array, context(MainActivity), and interface to the
        AnimalAdapter class */
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this);

        // add the adapter to the RecyclerView
        recyclerView.setAdapter(animalAdapter);

        // chose a layout for the RecyclerView (LinearLayout, because our RecyclerView is rows)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    /* override the method that we created in the interface ( in AnimalAdapter class ), this method
    takes the position of each (object, item, animal) that we sent it from the ViewHolder in
    AnimalAdapter class */
    @Override
    public void onClickedItem(int positionOfTheAnimal) {
        /* what will this method does when we click on each item in the recyclerView? it will jump
        * to another Activity ( animal_info ) */
        Intent intent = new Intent(this, animal_info.class);
        intent.putExtra("image", animals.get(positionOfTheAnimal).getAnimalImage());
        intent.putExtra("name", animals.get(positionOfTheAnimal).getAnimalName());
        startActivity(intent);
    }
}