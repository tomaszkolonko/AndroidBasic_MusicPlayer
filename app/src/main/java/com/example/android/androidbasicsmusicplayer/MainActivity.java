package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the correct view, create the custom adapter and set it on the view
        final GridView gridView = findViewById(R.id.categoryGridView);
        GenreAdapter adapter = new GenreAdapter(this, SongGenerator.getListOfGenre());
        gridView.setAdapter(adapter);

    }
}
