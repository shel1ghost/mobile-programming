package com.example.musicplayer;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

public class PlaySong {
    MediaPlayer mediaPlayer;
    ImageButton prevButton, nextButton, pauseButton;
    SeekBar seekBar;
    TextView songPlayed, artistPlayed, elapsedTime, totalDuration;
    ArrayList<String> songTitles = new ArrayList<>();
    ArrayList<String> songPaths = new ArrayList<>();
    ArrayList<String> songArtists = new ArrayList<>();
    ArrayList<Bitmap> albumArts = new ArrayList<>();
    CustomListAdapter adapter;
    Context context;
    public PlaySong(Context context, CustomListAdapter adapter, ArrayList<String> songTitles, ArrayList<String> songPaths, ArrayList<String> songArtists){
        this.context = context;
        this.adapter = adapter;
        this.songTitles = songTitles;
        this.songArtists = songArtists;
        this.songPaths = songPaths;
    }
    public void playSong(int songIndex, String songTitle, String songArtist, String selectedPath) {
        adapter.setSelectedPosition(songIndex);
        // Stop any currently playing music
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        pauseButton.setImageResource(R.drawable.circlepausesolid);
        // Step 3: Play the selected song
        mediaPlayer = new MediaPlayer();
        try {
            songPlayed.setText(songTitle);
            artistPlayed.setText(songArtist);
            mediaPlayer.setDataSource(selectedPath); // Set the song's file path
            mediaPlayer.prepare(); // Prepare MediaPlayer for playback
            mediaPlayer.start(); // Start playback

            mediaPlayer.setOnPreparedListener(mp -> {
                seekBar.setMax(mp.getDuration()); // Set max value based on song duration
                int duration = mediaPlayer.getDuration(); // Get total duration in milliseconds
                totalDuration.setText(formatTime(duration));

                Handler handler = new Handler();
                Runnable updateSeekBar = new Runnable() {
                    @Override
                    public void run() {
                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                            int currentPosition = mediaPlayer.getCurrentPosition(); // Get current position
                            // Update elapsed time TextView
                            elapsedTime.setText(formatTime(currentPosition));
                            seekBar.setProgress(mediaPlayer.getCurrentPosition()); // Update progress
                            handler.postDelayed(this, 1000); // Update every second
                        }
                    }
                };
                handler.removeCallbacks(updateSeekBar);
                handler.post(updateSeekBar); // Start the Runnable when MediaPlayer is ready
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser && mediaPlayer != null) {
                            mediaPlayer.seekTo(progress); // Seek to the desired position
                            elapsedTime.setText(formatTime(progress));
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        handler.removeCallbacks(updateSeekBar); // Pause updates while dragging
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        handler.post(updateSeekBar); // Resume updates after dragging
                    }
                });
                // Play Button: Resume Playback and Start SeekBar Updates
                prevButton.setOnClickListener(v -> {
                    int prevSongIndex = songIndex - 1; // Increment and get the next song index
                    if (prevSongIndex < songPaths.size() && prevSongIndex >= 0) {
                        String nextSelectedPath = songPaths.get(prevSongIndex); // Get the file path of the clicked item
                        String nextSongTitle = songTitles.get(prevSongIndex);
                        String nextSongArtist = songArtists.get(prevSongIndex);
                        playSong(prevSongIndex, nextSongTitle, nextSongArtist, nextSelectedPath); // Play the next song
                    }
                });

                pauseButton.setOnClickListener(v -> {
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        mediaPlayer.pause(); // Pause playback
                        handler.removeCallbacks(updateSeekBar); // Stop updating the SeekBar
                        pauseButton.setImageResource(R.drawable.circleplaysolid);
                    }else{
                        pauseButton.setImageResource(R.drawable.circlepausesolid);
                        mediaPlayer.start();
                        handler.post(updateSeekBar);
                    }
                });
                nextButton.setOnClickListener(v ->{
                    int nextSongIndex = songIndex + 1; // Increment and get the next song index
                    if (nextSongIndex < songPaths.size()) {
                        String nextSelectedPath = songPaths.get(nextSongIndex); // Get the file path of the clicked item
                        String nextSongTitle = songTitles.get(nextSongIndex);
                        String nextSongArtist = songArtists.get(nextSongIndex);
                        playSong(nextSongIndex, nextSongTitle, nextSongArtist, nextSelectedPath); // Play the next song
                    } else {
                        // Reset to the first song if the playlist is complete
                        String firstSelectedPath = songPaths.get(0); // Get the file path of the clicked item
                        String firstSongTitle = songTitles.get(0);
                        String firstSongArtist = songArtists.get(0);
                        playSong(0, firstSongTitle, firstSongArtist, firstSelectedPath);
                    }
                });
            });
            mediaPlayer.setOnCompletionListener(mp -> {
                int nextSongIndex = songIndex + 1; // Increment and get the next song index
                if (nextSongIndex < songPaths.size()) {
                    String nextSelectedPath = songPaths.get(nextSongIndex); // Get the file path of the clicked item
                    String nextSongTitle = songTitles.get(nextSongIndex);
                    String nextSongArtist = songArtists.get(nextSongIndex);
                    playSong(nextSongIndex, nextSongTitle, nextSongArtist, nextSelectedPath); // Play the next song
                } else {
                    // Reset to the first song if the playlist is complete
                    String firstSelectedPath = songPaths.get(0); // Get the file path of the clicked item
                    String firstSongTitle = songTitles.get(0);
                    String firstSongArtist = songArtists.get(0);
                    playSong(0, firstSongTitle, firstSongArtist, firstSelectedPath);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatTime(int timeInMillis) {
        int minutes = (timeInMillis / 1000) / 60;
        int seconds = (timeInMillis / 1000) % 60;
        return String.format("%d:%02d", minutes, seconds);
    }

    public Bitmap getAlbumArt(Uri albumArtUri) {
        Bitmap albumArt = null;
        try {
            // Query for the album art
            Cursor cursor = context.getContentResolver().query(albumArtUri, new String[]{MediaStore.Audio.Albums.ALBUM_ART}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String artPath = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART));
                if (artPath != null) {
                    // Decode the album art file into a Bitmap
                    albumArt = BitmapFactory.decodeFile(artPath);
                }
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumArt;
    }

}

