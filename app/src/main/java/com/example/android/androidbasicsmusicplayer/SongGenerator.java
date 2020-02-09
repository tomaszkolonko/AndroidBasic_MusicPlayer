package com.example.android.androidbasicsmusicplayer;

import java.util.ArrayList;
import java.util.Arrays;

public class SongGenerator {
    private final int MAX_SONG_LENGTH_SECONDS = 360;
    private final int MIN_SONG_LENGTH_SECONDS = 60;
    private String[] titles = {"Love", "Never", "Pink", "Rose", "Rainbow", "Unicorn", "Love", "Friend", "Dog", "Cat",
        "About", "Above", "Change", "Billion", "Challenge", "Difficult", "Enter", "Eternity", "Forget", "Garden", "Heart",
        "Interest", "Join", "Light", "Magazin", "Nature", "Option", "Pretty", "Question", "Reach", "Sense", "Tree",
        "Victim", "Wonder", "Yourself"};
    private String[] authorFirstName = {"Alexander", "Peter", "John", "Kay", "Jorget", "Ataca", "Luisa", "Sandra", "Maria",
        "Joel", "Romeo", "Bori", "Prince", "Kewin", "Joe", "Kiko", "Christina", "Jennifer", "Milena", "Natti"};
    private String[] authorLastName = {"Abreu", "Farel", "Floyed", "Santos", "Jackson", "Lee", "Royce", "Cosmos",
        "Vera", "Rodriguez", "Ferreira", "Lirow", "Picasso", "Bach", "Natasha", "Jaza"};
    private static String[] genre = {"Pop", "Blues", "Rock", "Salsa", "Bachata", "Techno", "Jazz", "Swing", "Classic",
        "Ska", "RocknRoll", "Electronic"};

    /**
     * This is the only way to generate a Song and return it for later use
     *
     * @return
     */
    public Song generateSong() {
        String title = generateTitle();
        String author = generateAuthor();
        String genre = generateGenre();
        int length = generateLength();
        Song song = new Song(title, author, genre, length);
        return song;
    }

    /**
     * Generates a random title for the song
     *
     * @return
     */
    private String generateTitle() {
        int first = (int) (Math.random() * titles.length);
        int second = (int) (Math.random() * titles.length);
        int third = (int) (Math.random() * titles.length);

        return titles[first] + " " + titles[second] + " " + titles[third];
    }

    /**
     * Generates a random author for the song
     *
     * @return
     */
    private String generateAuthor() {
        int positionFirstName = (int) (Math.random() * authorFirstName.length);
        int positionLastName = (int) (Math.random() * authorLastName.length);
        return authorFirstName[positionFirstName] + " " + authorLastName[positionLastName];
    }

    /**
     * Generates a random genre for the song
     *
     * @return
     */
    private String generateGenre() {
        int position = (int) (Math.random() * genre.length);
        return genre[position];
    }

    /**
     * Generates a random length for the song
     *
     * @return
     */
    private int generateLength() {
        int length = (int) (Math.random() * MAX_SONG_LENGTH_SECONDS + MIN_SONG_LENGTH_SECONDS);
        return length;
    }

    /**
     * Getter for the list of genres
     *
     * @return
     */
    public static ArrayList<String> getListOfGenre() {
        return new ArrayList(Arrays.asList(genre));
    }



}
