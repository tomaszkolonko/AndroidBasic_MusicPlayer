package com.example.android.androidbasicsmusicplayer;

public class Song {
    private String title;
    private String author;
    private String genre;
    private int length;

    /**
     * Simple constructor to create a Song object
     *
     * @param title
     * @param author
     * @param genre
     * @param length
     */
    public Song(String title, String author, String genre, int length) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
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
