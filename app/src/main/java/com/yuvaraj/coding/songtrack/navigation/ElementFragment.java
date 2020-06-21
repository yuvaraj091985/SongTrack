package com.yuvaraj.coding.songtrack.navigation;

import android.os.Bundle;
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
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(getActivity()).get(SharedData.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        songList.add("Element 1");
        songList.add("Element 2");

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(new ElementListAdapter(getContext() ,songList, new ElementListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                sharedViewModel.data(item);
            }
        }));


        return root;
    }
}
