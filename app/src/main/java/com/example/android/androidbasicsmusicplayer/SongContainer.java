package com.example.android.androidbasicsmusicplayer;

import java.util.ArrayList;

public class SongContainer {

    private static ArrayList<Song> listOfSongs = new ArrayList();
    private static SongGenerator songGenerator = new SongGenerator();

    public static ArrayList<Song> getListOfSongs() {
        if(listOfSongs.isEmpty()) {
            createSongContainer();
        }
        return listOfSongs;
    }

    public static void addNewSong(Song song) {
        listOfSongs.add(song);
    }

    public static void createSongContainer() {
        for (int i = 0; i < 1000; i++) {
            listOfSongs.add(songGenerator.generateSong());
        }
    }
}
