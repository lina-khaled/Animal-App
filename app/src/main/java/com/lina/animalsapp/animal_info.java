package com.lina.animalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class animal_info extends AppCompatActivity {
TextView textView;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);
        textView = findViewById(R.id.animalName);
        imageView = findViewById(R.id.imgCircled);

        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        textView.setText(intent.getStringExtra("name"));
    }
}