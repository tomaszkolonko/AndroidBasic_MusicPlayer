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
        listOfSongs.add(new Song("Live For My Love", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Sound Of The City", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Words Of My Soul", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Words Of My Darling", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("One More Angel", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Stolen Grooves", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Babe, You're A Mystery", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("Babe, Without You", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("I Love He Ain't Bad", "Jose Albir", "Blues", 120));
        listOfSongs.add(new Song("He's Mysterious", "Jose Albir", "Blues", 120));

        for (int i = 0; i < 1000; i++) {
            listOfSongs.add(songGenerator.generateSong());
        }
    }
}
