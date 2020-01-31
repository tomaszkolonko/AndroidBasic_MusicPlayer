package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_container);

        SongAdapter songAdapter = new SongAdapter(this, SongContainer.getListOfSongs());
        ListView listView = (ListView) findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);
    }
}
