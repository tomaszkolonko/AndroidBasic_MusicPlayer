package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SongGenerator songGenerator = new SongGenerator();

        ArrayList<Song> listOfSongs = new ArrayList<Song>();

        listOfSongs.add(new Song("Live For My Love", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Sound Of The City", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("Words Of My Soul", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("Words Of My Darling", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("One More Angel", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("Stolen Grooves", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("Babe, You're A Mystery", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("Babe, Without You", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("I Love He Ain't Bad", "Jose Albir","Blues", 120));
        listOfSongs.add(new Song("He's Mysterious", "Jose Albir", "Blues", 120));

        for(int i = 0; i < 1000; i++) {
            listOfSongs.add(songGenerator.generateSong());
        }

    }
}
