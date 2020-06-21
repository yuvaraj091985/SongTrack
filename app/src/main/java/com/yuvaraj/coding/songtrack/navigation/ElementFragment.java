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

import com.yuvaraj.coding.songtrack.R;
import com.yuvaraj.coding.songtrack.viewmodel.SharedData;

import java.util.ArrayList;
import java.util.List;

public class ElementFragment extends Fragment {
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
        songList.add("Element 1");
        songList.add("Element 2");

        if (savedInstanceState != null) {
            selectedValue = savedInstanceState.getInt("selectedValue");
        }

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        adapter = new ElementListAdapter(getContext() ,songList, new ElementListAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(String item, int position) {
                selectedValue = position;
                sharedViewModel.data(item);
            }
        });

        recyclerView.setAdapter(adapter);
        adapter.setSelected(selectedValue);

        setRetainInstance(true);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("selectedValue", selectedValue);
        super.onSaveInstanceState(outState);
    }

}
