package com.lina.animalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.myClickedInterface{
    RecyclerView recyclerView;
    ArrayList<Animal> animals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        animals = new ArrayList<>();
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

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);

    }

    @Override
    public void onClickedItem(int positionOfTheAnimal) {
        Intent intent = new Intent(this, animal_info.class);
        intent.putExtra("image", animals.get(positionOfTheAnimal).getAnimalImage());
        intent.putExtra("name", animals.get(positionOfTheAnimal).getAnimalName());
        startActivity(intent);
    }
}