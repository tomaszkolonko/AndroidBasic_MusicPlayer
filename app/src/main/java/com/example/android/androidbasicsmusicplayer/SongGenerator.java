package com.example.android.androidbasicsmusicplayer;

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
    private String[] genre = {"Pop", "Blues", "Rock", "Salsa", "Bachata", "Techno", "Jazz", "Swing", "Classic",
        "Ska", "RocknRoll", "Instrumental", "Electronic"};

    public Song generateSong() {
        String title = generateTitle();
        String author = generateAuthor();
        String genre = generateGenre();
        int length = (int) Math.random() * MAX_SONG_LENGTH_SECONDS + MIN_SONG_LENGTH_SECONDS;
        Song song = new Song(title, author, genre, length);
        return song;
    }

    private String generateTitle() {
        int position = (int) Math.random() * titles.length;
        return titles[position];
    }

    private String generateAuthor() {
        int positionFirstName = (int) Math.random() * authorFirstName.length;
        int positionLastName = (int) Math.random() * authorLastName.length;
        return authorFirstName[positionFirstName] + " " + authorLastName[positionLastName];
    }

    private String generateGenre() {
        int position = (int) Math.random() * genre.length;
        return genre[position];
    }


}
