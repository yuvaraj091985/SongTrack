package com.yuvaraj.coding.songtrack.details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.OnItemClickListener;
import com.yuvaraj.coding.songtrack.R;

import java.util.List;

class ItemListAdapter extends RecyclerView.Adapter<ItemListViewHolder> {

    public OnItemClickListener itemClickListener;
    private Context context;
    private int selectedItem;
    private List<String> itemList;

    public ItemListAdapter(Context appContext, List<String> trackList, OnItemClickListener listener){
        context = appContext;
        itemList = trackList;
        itemClickListener = listener;
        selectedItem = -1;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.song_name_item, parent,false);
        return new ItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, final int position) {

        holder.bind(itemList.get(position));

        holder.outerLayout.setBackgroundColor(context.getColor(R.color.itemPrimary));
        if (selectedItem == position) {
            holder.outerLayout.setBackgroundColor(context.getColor(R.color.itemSecondary));
        }
        holder.outerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(itemList.get(position), position);
                int previousItem = selectedItem;
                selectedItem = position;

                notifyItemChanged(previousItem);
                notifyItemChanged(position);
            }
        });

    }

    public void setSelected(int position) {
        selectedItem = position;
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
