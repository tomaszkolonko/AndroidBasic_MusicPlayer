package com.example.android.androidbasicsmusicplayer;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SongContainer {

    private static ArrayList<Song> listOfSongs = new ArrayList();
    // TODO: Understand how it is possible that this private member is changed with
    // TODO: each character added to the SearchView (filter)
    private static ArrayList<Song> listOfSongsByCurrentGenre = new ArrayList();
    private static SongGenerator songGenerator = new SongGenerator();

    /**
     * This method extracts the genre which was passed in with the intent and
     * filters the full library by genre. After filtering it writes the filtered
     * song list into listOfSongsByCurrentGenre
     *
     * @param extras
     */
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

    /**
     * Getter for listOfSongs
     *
     * @return
     */
    public static ArrayList<Song> getCurrentListOfSongs() {
        return listOfSongs;
    }

    /**
     * Getter for listOfSongsByCurrentGenre
     *
     * @return
     */
    public static ArrayList<Song> getListOfSongsByCurrentGenre() {
        return listOfSongsByCurrentGenre;
    }

    /**
     * This method checks if the listOfSongs member has been populated already with Song
     * objects and returns it if so. If not, it populates the member variable before
     * returning it
     *
     * @return
     */
    private static ArrayList<Song> getOrCreateIfEmptyListOfSongs() {
        if(listOfSongs.isEmpty()) {
            createSongContainer();
        }
        return listOfSongs;
    }

    /**
     * Creates 1000 random song objects and adds them to the listOfSongs member. This
     * method can only be called from within this class.
     */
    private static void createSongContainer() {
        for (int i = 0; i < 1000; i++) {
            listOfSongs.add(songGenerator.generateSong());
        }
    }
}
