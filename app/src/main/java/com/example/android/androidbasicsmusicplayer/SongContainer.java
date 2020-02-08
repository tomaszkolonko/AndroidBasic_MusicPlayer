package com.example.android.androidbasicsmusicplayer;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SongContainer {

    private static ArrayList<Song> listOfSongs = new ArrayList();
    private static ArrayList<Song> listOfSongsByCurrentGenre = new ArrayList();
    private static SongGenerator songGenerator = new SongGenerator();


    public static ArrayList<Song> getListOfSongsByCurrentGenre() {

        return listOfSongsByCurrentGenre;
    }

    public static void filterCurrentListOfSongsByGenre(Bundle extras) {
        if (extras != null && extras.getString("Genre") != null) {
            if (!extras.getString("Genre").equalsIgnoreCase("random")) {
                String genre = extras.getString("Genre");
                // If a particular genre is selected, filter accordingly
                listOfSongsByCurrentGenre = getOrCreateIfEmptyListOfSongs().stream()
                        .filter((Song song) -> song.getGenre().equals(genre))
                        .collect(Collectors.toCollection(ArrayList::new));
            } else {
                // If "random" is selected, return the full library
                listOfSongsByCurrentGenre = getCurrentListOfSongs();
            }
        }
    }

    public static ArrayList<Song> getCurrentListOfSongs() {
        return listOfSongs;
    }

    private static ArrayList<Song> getOrCreateIfEmptyListOfSongs() {
        if(listOfSongs.isEmpty()) {
            createSongContainer();
        }
        return listOfSongs;
    }

    private static void createSongContainer() {
        for (int i = 0; i < 1000; i++) {
            listOfSongs.add(songGenerator.generateSong());
        }
    }
}
