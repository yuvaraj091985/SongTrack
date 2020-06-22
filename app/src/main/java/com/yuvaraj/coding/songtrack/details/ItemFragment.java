package com.yuvaraj.coding.songtrack.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yuvaraj.coding.songtrack.OnItemClickListener;
import com.yuvaraj.coding.songtrack.R;
import com.yuvaraj.coding.songtrack.viewmodel.SharedData;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {
    private SharedData sharedViewModel;
    private RecyclerView recyclerView;
    private ItemListAdapter itemListAdapter;
    private List<String> trackList = new ArrayList<>();
    private int selectedValue = 0;
    private boolean orientationChanged = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel =
                new ViewModelProvider(getActivity()).get(SharedData.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //Observing on viewmodel livedata on any Element item change
        sharedViewModel.getData().observe(getViewLifecycleOwner(),new Observer<String>() {
            @Override
            public void onChanged(@Nullable String item) {
                    updateDetails(item);

                    //Observing if it was emitted on config change
                    if(!orientationChanged) {
                        itemListAdapter.setSelected(-1);
                        recyclerView.scrollToPosition(0);
                    }
                    orientationChanged = false;

            }
        });

        if (savedInstanceState != null) {
            selectedValue = savedInstanceState.getInt("selectedValue");
        }

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        itemListAdapter = new ItemListAdapter(getContext() ,trackList, new OnItemClickListener() {

            @Override
            public void onItemClick(String item, int position) {
                selectedValue = position;
            }
        });

        //Setting up the adapter
        recyclerView.setAdapter(itemListAdapter);
        itemListAdapter.setSelected(selectedValue);

        //scroll to selected position
        recyclerView.scrollToPosition(selectedValue);

        //toRetain fragment on config changes
        setRetainInstance(true);
        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        orientationChanged = true;
        outState.putInt("selectedValue", selectedValue);
        super.onSaveInstanceState(outState);
    }

    private void updateDetails(String value) {

        trackList.clear();

        for(int i =1; i<=100;i++){
            trackList.add(value + " Item " +i);
        }

        itemListAdapter.notifyDataSetChanged();
    }
}
