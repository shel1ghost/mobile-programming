package com.example.musicplayer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        // Populate the data into the template
        songName.setText(song.getTitle());
        artistName.setText(song.getArtist());

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
