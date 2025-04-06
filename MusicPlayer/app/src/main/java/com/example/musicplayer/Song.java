package com.example.musicplayer;

import android.graphics.Bitmap;

public class Song {
    private String title;
    private String artist;
    private Bitmap albumArt;

    public Song(String title, String artist, Bitmap albumArt) {
        this.title = title;
        this.artist = artist;
        this.albumArt = albumArt;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Bitmap getAlbumArt() {
        return albumArt;
    }

}
