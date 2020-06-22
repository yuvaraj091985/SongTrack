package com.yuvaraj.coding.songtrack.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.OnItemClickListener;
import com.yuvaraj.coding.songtrack.R;
import com.yuvaraj.coding.songtrack.viewmodel.SharedData;

import java.util.ArrayList;
import java.util.List;

public class ElementFragment extends Fragment {
    private static final String SELECTED_VALUE = "selectedValue";
    private SharedData sharedViewModel;
    private RecyclerView recyclerView;
    private List<String> songList = new ArrayList<>();
    private int selectedValue = 0;
    private ElementListAdapter adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(getActivity()).get(SharedData.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        songList.clear();

        for(int i =1;i<=100;i++) {
            songList.add("Element " +i);
        }

        if (savedInstanceState != null) {
            selectedValue = savedInstanceState.getInt(SELECTED_VALUE);
        }

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        adapter = new ElementListAdapter(getContext() ,songList, new OnItemClickListener() {

            @Override
            public void onItemClick(String item, int position) {
                selectedValue = position;
                sharedViewModel.data(item);
            }
        });

        recyclerView.setAdapter(adapter);
        adapter.setSelected(selectedValue);
        recyclerView.scrollToPosition(selectedValue);

        setRetainInstance(true);

        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SELECTED_VALUE, selectedValue);
        super.onSaveInstanceState(outState);
    }

}
