package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> genre = new ArrayList(Arrays.asList("Pop", "Blues", "Rock",
            "Salsa", "Bachata", "Techno", "Jazz", "Swing", "Classic", "Ska",
            "RocknRoll", "Electronic"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongGenerator songGenerator = new SongGenerator();

        ArrayList<Song> listOfSongs = new ArrayList();

        listOfSongs.add(new Song("Live For My Love", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Sound Of The City", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Words Of My Soul", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Words Of My Darling", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("One More Angel", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Stolen Grooves", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Babe, You're A Mystery", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Babe, Without You", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("I Love He Ain't Bad", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("He's Mysterious", "Jose Albir", "Blues", 120));

        for (int i = 0; i < 1000; i++) {
            listOfSongs.add(songGenerator.generateSong());
        }

        final GridView gridView = findViewById(R.id.categoryGridView);

        GenreAdapter adapter = new GenreAdapter(this, genre);
        gridView.setAdapter(adapter);


//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch(v.getId()) {
//                    case(1):
//                        Intent intent = new Intent(MainActivity.this, PopActivity.class);
//                        startActivity(intent);
//
//                        Toast.makeText(gridView.getContext(), "ID = 1", Toast.LENGTH_LONG).show();
//                }
//            }
//        });

    }
}
