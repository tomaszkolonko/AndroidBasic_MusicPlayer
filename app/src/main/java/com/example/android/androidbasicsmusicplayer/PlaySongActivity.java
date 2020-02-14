package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PlaySongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        addBackToHomeButtonFunctionality();

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("Title") != null && extras.getString("Author") != null) {
            TextView songTitlePlayView = findViewById(R.id.songTitlePlayView);
            songTitlePlayView.setText(extras.getString("Title"));
            TextView songAuthorPlayView = findViewById(R.id.songAuthorPlayView);
            songAuthorPlayView.setText("by: " + extras.getString("Author"));
        }
        addPlayerButtons();

    }

    private void addPlayerButtons() {
        // adding Toast for previous button
        ImageButton previousButton = findViewById(R.id.playPreviousButton);
        previousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Jumping to previous song",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // adding Toast for play / pause button
        ImageButton playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Playing / Pausing current song",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // adding Toast for next button
        ImageButton nextButton = findViewById(R.id.playNextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Jumping to the next song",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addBackToHomeButtonFunctionality() {
        Button back = findViewById(R.id.home_button_play_song_activity);
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
}
