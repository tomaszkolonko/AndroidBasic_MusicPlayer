package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

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

        TextView tv = findViewById(R.id.randomGenre);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating and starting an explicit intent
                Intent intent = new Intent(v.getContext(), ListSongsActivity.class);

                // Put some Extra field to sort by single_genre_view_element in the next activity
                intent.putExtra("Genre", v.getTag().toString());

                // Start the intent from the current context
                startActivity(intent);
            }
        });
    }
}
