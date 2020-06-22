package com.yuvaraj.coding.songtrack.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.OnItemClickListener;
import com.yuvaraj.coding.songtrack.R;

import java.util.List;

class ElementListAdapter extends RecyclerView.Adapter<ElementListViewHolder> {

    public OnItemClickListener itemClickListener;
    private Context context;
    private List<String> ElementList;
    private int selectedItem;

    public ElementListAdapter(Context appContext, List<String> trackList, OnItemClickListener listener){
        context = appContext;
        ElementList = trackList;
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

        holder.bind(ElementList.get(position));

        holder.outerLayout.setBackgroundColor(context.getColor(R.color.elementPrimary));

        if (selectedItem == position) {
            holder.outerLayout.setBackgroundColor(context.getColor(R.color.elementSecondary));
        }

        //Onclick of items
        holder.outerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(ElementList.get(position), position);
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
        return ElementList.size();
    }
}
