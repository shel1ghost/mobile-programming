package com.example.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Song> {
    private int selectedPosition = -1;
    public CustomListAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Song song = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_items, parent, false);
        }

        // Find the TextViews in the custom layout
        TextView songName = convertView.findViewById(R.id.song_name);
        TextView artistName = convertView.findViewById(R.id.artist_name);
        ImageView albumArtImageView = convertView.findViewById(R.id.album_art);
        // Populate the data into the template
        songName.setText(song.getTitle());
        artistName.setText(song.getArtist());

        // Set the album art
        Bitmap albumArt = song.getAlbumArt();
        if (albumArt != null) {
            Glide.with(getContext())
                    .load(albumArt)// If you have a Bitmap, Glide can load it directly
                    .placeholder(R.drawable.default_music_art)  // Set a placeholder while loading
                    .error(R.drawable.default_music_art)
                    .into(albumArtImageView);
        } else {
            Glide.with(getContext())
                    .load(R.drawable.default_music_art)  // Load default image if no album art
                    .into(albumArtImageView);
        }

        // Change background color based on the selected position
        if (position == selectedPosition) {
            convertView.setBackgroundColor(Color.parseColor("#3da2f5")); // Highlight color
        } else {
            convertView.setBackgroundColor(Color.TRANSPARENT); // Default color
        }

        return convertView;
    }
    // Method to update the selected position
    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged(); // Refresh the ListView
    }
}

