package com.example.android.androidbasicsmusicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) { super(context, 0, SongContainer.getListOfSongs()); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Song song = getItem(position);

        // Check if an existing view is being reused, otherwise infalte the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_song_view_element, parent, false);
        }

        // Lookup view for data population
        TextView songTitle = (TextView) convertView.findViewById(R.id.songTitle);
        songTitle.setText(song.getTitle());

        TextView songAuthor = (TextView) convertView.findViewById(R.id.songAuthor);
        songAuthor.setText(song.getAuthor());

        TextView songLength = (TextView) convertView.findViewById(R.id.songLegth);
        songLength.setText(song.getLength() + " sec");

        TextView songGenre = (TextView) convertView.findViewById(R.id.songGenre);
        songGenre.setText("<" + song.getGenre() + ">");

        addOnClickListenerToView(convertView);

        // Return the completed view to render on screen
        return convertView;
    }

    public void addOnClickListenerToView(View convertView) {
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "testing", Toast.LENGTH_SHORT).show();

//                // Creating and starting an explicit intent
//                Intent intent = new Intent(v.getContext(), ListSongsActivity.class);
//
//                // Put some Extra field to sort by single_genre_view_element in the next activity
//                intent.putExtra("Genre", v.getTag().toString());
//
//                // Start the intent from the current context
//                v.getContext().startActivity(intent);
            }
        });
    }
}
