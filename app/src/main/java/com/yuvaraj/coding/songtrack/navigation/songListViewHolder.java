package com.yuvaraj.coding.songtrack.navigation;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

class songListViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public songListViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.name);
    }

    public void bind(final String value, final songListAdapter.OnItemClickListener itemClicklistener) {
        textView.setText(value);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicklistener.onItemClick(value);
            }
        });
    }
}
