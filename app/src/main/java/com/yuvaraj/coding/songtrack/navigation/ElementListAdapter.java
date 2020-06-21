package com.yuvaraj.coding.songtrack.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

import java.util.List;

class ElementListAdapter extends RecyclerView.Adapter<ElementListViewHolder> {

    public OnItemClickListener itemClickListener;
    private Context context;

    private List<String> songList;
    private int selectedItem;

    public ElementListAdapter(Context appContext, List<String> trackList, OnItemClickListener listener){
        context = appContext;
        songList = trackList;
        itemClickListener = listener;
        selectedItem = -1;
    }

    @NonNull
    @Override
    public ElementListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_name_item, parent,false);
        return new ElementListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementListViewHolder holder, final int position) {

        holder.bind(songList.get(position));

        holder.outerLayout.setBackgroundColor(context.getColor(R.color.colorPrimary));
        if (selectedItem == position) {
            holder.outerLayout.setBackgroundColor(context.getColor(R.color.colorPrimaryDark));
        }
        holder.outerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(songList.get(position));
                int previousItem = selectedItem;
                selectedItem = position;

                notifyItemChanged(previousItem);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(String item);
    }

}
