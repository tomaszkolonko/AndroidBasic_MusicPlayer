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
        ArrayList<Song> yolo = null;

        Bundle extras = getIntent().getExtras();
        if(extras != null && extras.getString("Genre") != null) {
            String genre = extras.getString("Genre");
            yolo = listOfSongs.stream().filter((Song song) -> song.getGenre().equals(genre)).collect(Collectors.toCollection(ArrayList<Song>::new));
        }


        SongAdapter songAdapter = new SongAdapter(this, yolo);
        ListView listView = (ListView) findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);
    }
}
