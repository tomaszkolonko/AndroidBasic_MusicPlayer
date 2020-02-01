package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_container);

        ArrayList<Song> listOfSongs = SongContainer.getListOfSongs();

        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.getString("Genre") != null) {
            String genre = extras.getString("Genre");
            listOfSongs = listOfSongs.stream()
                    .filter((Song song) -> song.getGenre().equals(genre))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        SongAdapter songAdapter = new SongAdapter(this, listOfSongs);
        ListView listView = findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);
    }
}
