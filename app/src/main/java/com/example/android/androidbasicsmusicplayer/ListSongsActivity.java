package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListSongsActivity extends AppCompatActivity {

    private ArrayList<Song> listOfSongs = SongContainer.getListOfSongs();
    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_container);

        adaptListOfSongsToCategoryChosenByUser();

        songAdapter = new SongAdapter(this, listOfSongs);
        ListView listView = findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);

        SearchView searchResult = findViewById(R.id.searchFieldSongContainer);

        searchResult.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.v("ListSongActivity::onQueryTextSubmit", "...");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.v("ListSongActivity::onQueryTextChange", "Filtering for " + newText);
                songAdapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), songAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });

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
