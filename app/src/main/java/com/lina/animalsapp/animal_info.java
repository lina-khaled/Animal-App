package com.lina.animalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class animal_info extends AppCompatActivity {
    // declare the circle ImageView that we created in activity_animal_info, and the TextView as well
       TextView textView;
       ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);

        // find them by id ( this method doesn't take View, so no need to casting
        textView = findViewById(R.id.animalName);
        imageView = findViewById(R.id.imgCircled);

        /* create intent to hold that intent we created in MainActivity, so we can extract all
         information from it ( all we sent ) */
        Intent intent = getIntent();

        // set the ImageView & TextView in the activity_animal_info to the ones who sent
        imageView.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        textView.setText(intent.getStringExtra("name"));
    }
}