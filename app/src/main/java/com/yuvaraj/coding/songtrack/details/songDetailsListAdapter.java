package com.yuvaraj.coding.songtrack.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

import java.util.List;

class songDetailsListAdapter extends RecyclerView.Adapter<songDetailsListViewHolder> {

    private List<String> songList;

    public songDetailsListAdapter(List<String> trackList){
        songList = trackList;
    }

    @NonNull
    @Override
    public songDetailsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_name_item, parent,false);
        return new songDetailsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull songDetailsListViewHolder holder, int position) {

        holder.getTextView().setText(songList.get(position));
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

}
