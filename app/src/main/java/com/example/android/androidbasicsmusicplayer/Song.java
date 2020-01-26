package com.example.android.androidbasicsmusicplayer;

public class Song {
    private String name;
    private String author;
    private String genre;
    private int length;

    /**
     * Simple constructor to create a Song object
     *
     * @param name
     * @param author
     * @param genre
     * @param length
     */
    public Song(String name, String author, String genre, int length) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
