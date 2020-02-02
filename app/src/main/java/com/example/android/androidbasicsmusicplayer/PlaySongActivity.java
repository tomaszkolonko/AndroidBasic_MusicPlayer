package com.example.android.androidbasicsmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlaySongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getString("Title") != null && extras.getString("Author") != null) {
            TextView songTitlePlayView = findViewById(R.id.songTitlePlayView);
            songTitlePlayView.setText(extras.getString("Title"));
            TextView songAuthorPlayView = findViewById(R.id.songAuthorPlayView);
            songAuthorPlayView.setText("by: " + extras.getString("Author"));
        }
    }
}
