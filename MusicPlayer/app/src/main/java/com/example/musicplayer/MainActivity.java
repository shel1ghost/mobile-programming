package com.example.musicplayer;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.Manifest;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button playButton, pauseButton, stopButton;
    SeekBar seekBar;
    ListView listView;
    TextView songPlayed, artistPlayed;
    private static final int PERMISSION_REQUEST_CODE = 101; // You can choose any integer value
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);
        seekBar = findViewById(R.id.seekBar);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

        /*mediaPlayer = MediaPlayer.create(this, R.raw.pyaar_aata_hai); // Replace 'sample_audio' with your audio file in 'res/raw'

        playButton.setOnClickListener(v -> mediaPlayer.start());
        pauseButton.setOnClickListener(v -> mediaPlayer.pause());
        stopButton.setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer.prepareAsync(); // Re-prepare after stop
        });*/
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ArrayList<String> songTitles = new ArrayList<>();
                ArrayList<String> songPaths = new ArrayList<>();
                ArrayList<String> songArtists = new ArrayList<>();
                listView = findViewById(R.id.songListView);
                String[] projection = {MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.DATA};
                Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        null,
                        null,
                        null,
                        null
                );

                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int titleIndex = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                        int pathIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
                        int artistIndex = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

                        if (titleIndex != -1 && pathIndex != -1) {
                            String title = cursor.getString(titleIndex);
                            String path = cursor.getString(pathIndex);
                            String artist = cursor.getString(artistIndex);

                            songTitles.add(title); // Add title to the title array
                            songPaths.add(path);   // Add path to the path array
                            songArtists.add(artist);
                        }
                    }
                    cursor.close();
                }
                /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_items, R.id.song_name, songTitles);
                listView.setAdapter(adapter);*/
                ArrayList<Song> songs = new ArrayList<>();
                for (int i = 0; i < songTitles.size(); i++) {
                    songs.add(new Song(songTitles.get(i), songArtists.get(i))); // Add title and artist to list
                }

                CustomListAdapter adapter = new CustomListAdapter(this, songs);
                listView.setAdapter(adapter); // Set the custom adapter

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        String selectedPath = songPaths.get(position); // Get the file path of the clicked item
                        String songTitle = songTitles.get(position);
                        String songArtist = songArtists.get(position);
                        playButton = findViewById(R.id.playButton);
                        pauseButton = findViewById(R.id.pauseButton);
                        stopButton = findViewById(R.id.stopButton);
                        songPlayed = findViewById(R.id.song_played);
                        artistPlayed = findViewById(R.id.artist_played);

                        // Stop any currently playing music
                        if (mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }

                        // Step 3: Play the selected song
                        mediaPlayer = new MediaPlayer();
                        try {
                            songPlayed.setText(songTitle);
                            artistPlayed.setText(songArtist);
                            mediaPlayer.setDataSource(selectedPath); // Set the song's file path
                            mediaPlayer.prepare();                  // Prepare MediaPlayer for playback
                            mediaPlayer.start();// Start playback

                            mediaPlayer.setOnPreparedListener(mp -> {
                                seekBar.setMax(mp.getDuration()); // Set max value based on song duration

                                Handler handler = new Handler();
                                Runnable updateSeekBar = new Runnable() {
                                    @Override
                                    public void run() {
                                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                            seekBar.setProgress(mediaPlayer.getCurrentPosition()); // Update progress
                                            handler.postDelayed(this, 1000); // Update every second
                                        }
                                    }
                                };
                                handler.post(updateSeekBar); // Start the Runnable when MediaPlayer is ready
                                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                    @Override
                                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                        if (fromUser && mediaPlayer != null) {
                                            mediaPlayer.seekTo(progress); // Seek to the desired position
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
                                playButton.setOnClickListener(v -> {
                                    if (mediaPlayer != null) {
                                        mediaPlayer.start(); // Start/resume playback
                                        handler.post(updateSeekBar); // Resume updating the SeekBar
                                    }
                                });

                                pauseButton.setOnClickListener(v -> {
                                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                                        mediaPlayer.pause(); // Pause playback
                                        handler.removeCallbacks(updateSeekBar); // Stop updating the SeekBar
                                    }
                                });
                                stopButton.setOnClickListener(v -> {
                                    if (mediaPlayer != null) {
                                        mediaPlayer.stop();
                                        mediaPlayer.reset(); // Reset the MediaPlayer
                                        try {
                                            mediaPlayer.setDataSource(selectedPath); // Set the song's file path again
                                            mediaPlayer.prepare(); // Prepare it for playback
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error playing song", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                // Permission denied
                System.out.println("Permission denied. Cannot access storage.");
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release resources like MediaPlayer here
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
