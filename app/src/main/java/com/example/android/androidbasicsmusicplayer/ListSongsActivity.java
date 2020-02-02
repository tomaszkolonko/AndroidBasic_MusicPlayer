package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListSongsActivity extends AppCompatActivity {

    private ArrayList<Song> listOfSongs = SongContainer.getListOfSongs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_container);

        adaptListOfSongsToCategoryChosenByUser();

        SongAdapter songAdapter = new SongAdapter(this, listOfSongs);
        ListView listView = findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);

        // addOnClickListenerToSearchField(listOfSongs);
    }

    /**
     * This method checks what genre has been clicked on and returns the
     * corresponding list of Songs, if the "random" button has been clicked
     * the whole list of all songs will be used.
     *
     * @return
     */
    private void adaptListOfSongsToCategoryChosenByUser() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("Genre") != null) {
            if (!extras.getString("Genre").equalsIgnoreCase("random")) {
                String genre = extras.getString("Genre");
                listOfSongs = listOfSongs.stream()
                        .filter((Song song) -> song.getGenre().equals(genre))
                        .collect(Collectors.toCollection(ArrayList::new));
            }
        }
    }
}
