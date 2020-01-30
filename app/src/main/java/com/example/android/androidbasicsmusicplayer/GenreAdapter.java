package com.example.android.androidbasicsmusicplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<String> {

    public GenreAdapter(Context context, ArrayList<String> words) { super(context, 0, words); }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        String genre = getItem(position);

        // Check if an existing view is being reused, otherwise infalte the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.genre, parent, false);
        }

        // Lookup view for data population
        TextView genreView = (TextView) convertView.findViewById(R.id.genre);

        // Populate the data into the template view using the data object
        setGenreView(genreView, genre);

        // Return the completed view to render on screen
        return convertView;
    }

    /**
     * Setting everything parameter on the view
     *
     * @param genreView
     * @param genre
     */
    private void setGenreView(TextView genreView, String genre) {
        genreView.setText(genre);
        genreView.setTag(genre);
        genreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked on " + v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
