package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListSongsActivity extends AppCompatActivity {

    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_container);

        // Extracts the extras from the passed intent
        Bundle extras = getIntent().getExtras();
        // uses the extras to create a filtered ArrayList<Song> within SongContainer
        SongContainer.filterCurrentListOfSongsByGenre(extras);

        songAdapter = new SongAdapter(this, SongContainer.getListOfSongsByCurrentGenre());
        ListView listView = findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);

        SearchView searchResult = findViewById(R.id.searchFieldSongContainer);

        // Search mechanisme that searches by constraint within the genre-filtered selection
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
    }
}
