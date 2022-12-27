package com.vibhu.moodmastnew;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vibhu.moodmastnew.Adapter.ItemAdapter;
import com.vibhu.moodmastnew.Adapter.ItemAdapterCity;
import com.vibhu.moodmastnew.Adapter.ItemAdapterJungle;
import com.vibhu.moodmastnew.Model.ItemList;

public class JungleFragment extends Fragment {

    RecyclerView recyclerViewJungle;
    View view;
    ItemList[] mData = new ItemList[] {
//
            new ItemList("sample",R.drawable.seagull_hd),
//            new ItemList("Campfire",R.drawable.campfire_hd),
//            new ItemList("Wave",R.drawable.wind_hd),
//            new ItemList("Rain",R.drawable.rain_hd),
//            new ItemList("Storm",R.drawable.storm_hd),
//            new ItemList("Boat",R.drawable.boat_hd),
//            new ItemList("Rowboat",R.drawable.rowboat_hd),
//            new ItemList("Guitar",R.drawable.guitar_hd),
//            new ItemList("Seaside",R.drawable.seagull_hd),
//            new ItemList("Seaside",R.drawable.seagull_hd),
//            new ItemList("Seaside",R.drawable.seagull_hd),

//
    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_jungle, container, false);
        recyclerViewJungle = view.findViewById(R.id.recyclerViewJungle);


        ItemAdapterJungle itemAdapterJungle = new ItemAdapterJungle(mData);
        recyclerViewJungle.setHasFixedSize(true);


//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewJungle.setAdapter(itemAdapterJungle);
//


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerViewJungle.setLayoutManager(gridLayoutManager);









        return view;

    }
}