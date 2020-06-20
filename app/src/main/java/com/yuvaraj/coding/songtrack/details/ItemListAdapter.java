package com.yuvaraj.coding.songtrack.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

import java.util.List;

class ItemListAdapter extends RecyclerView.Adapter<ItemListViewHolder> {

    private List<String> songList;

    public ItemListAdapter(List<String> trackList){
        songList = trackList;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_name_item, parent,false);
        return new ItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {

        holder.getTextView().setText(songList.get(position));
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

}
