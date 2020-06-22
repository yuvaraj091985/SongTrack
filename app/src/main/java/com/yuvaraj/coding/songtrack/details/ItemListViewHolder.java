package com.yuvaraj.coding.songtrack.details;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

class ItemListViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public LinearLayout outerLayout;

    public ItemListViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById( R.id.name);
        outerLayout = itemView.findViewById(R.id.element_layout);
    }

    public void bind(final String value) {
        textView.setText(value);
    }

}
