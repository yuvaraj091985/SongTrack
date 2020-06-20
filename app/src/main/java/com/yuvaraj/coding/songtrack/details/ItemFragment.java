package com.yuvaraj.coding.songtrack.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.R;
import com.yuvaraj.coding.songtrack.viewmodel.SharedData;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {
    private SharedData sharedViewModel;
    private RecyclerView recyclerView;
    private ItemListAdapter itemListAdapter;
    private List<String> trackList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(getActivity()).get(SharedData.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        sharedViewModel.getData().observe(getViewLifecycleOwner(),new Observer<String>() {
            @Override
            public void onChanged(@Nullable String item) {
                Toast.makeText(getActivity(), " We clicked on "+ item,
                        Toast.LENGTH_SHORT).show();
                updateDetails(item);
            }
        });


        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        itemListAdapter = new ItemListAdapter(trackList);
        recyclerView.setAdapter(itemListAdapter);
        return root;
    }

    private void updateDetails(String value) {

        trackList.clear();
        switch (value) {
            case "Element 1" :
                trackList.add("Element 1 Item 1");
                trackList.add("Element 1 Item 2");
                break;
            case "Element 2" :
                trackList.add("Element 2 Item 1");
                trackList.add("Element 2 Item 2");
                break;

        }
        itemListAdapter.notifyDataSetChanged();
    }
}
