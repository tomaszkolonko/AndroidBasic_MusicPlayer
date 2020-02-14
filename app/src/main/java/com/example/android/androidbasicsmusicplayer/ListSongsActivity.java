package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListSongsActivity extends AppCompatActivity {

    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);

        // Extracts the extras from the passed intent
        Bundle extras = getIntent().getExtras();
        // uses the extras to create a filtered ArrayList<Song> within SongContainer
        SongContainer.filterCurrentListOfSongsByGenre(extras);

        songAdapter = new SongAdapter(this, SongContainer.getListOfSongsByCurrentGenre());
        ListView listView = findViewById(R.id.songListContainer);
        listView.setAdapter(songAdapter);

        addSearchViewFunctionality();
        addBackToHomeButtonFunctionality();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), songAdapter.getItem(position).getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addBackToHomeButtonFunctionality() {
        Button back = findViewById(R.id.home_button_list_activity);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating and starting an explicit intent
                Intent intent = new Intent(v.getContext(), MainActivity.class);

                // Start the intent from the current context
                startActivity(intent);
            }
        });
    }

    private void addSearchViewFunctionality() {
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
    }
}
