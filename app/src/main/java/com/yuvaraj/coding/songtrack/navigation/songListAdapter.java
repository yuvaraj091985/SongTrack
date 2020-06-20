package com.yuvaraj.coding.songtrack.navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

import java.util.List;

class songListAdapter extends RecyclerView.Adapter<songListViewHolder> {

    public OnItemClickListener itemClickListener;

    private List<String> songList;

    public songListAdapter(List<String> trackList, OnItemClickListener listener){
        songList = trackList;
        itemClickListener = listener;
    }

    @NonNull
    @Override
    public songListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_name_item, parent,false);
        return new songListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull songListViewHolder holder, int position) {

        holder.bind(songList.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(String item);
    }

}
