package com.yuvaraj.coding.songtrack.details;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;

class songDetailsListViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public songDetailsListViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById( R.id.name);
    }

    public TextView getTextView() {
        return textView;
    }
}
