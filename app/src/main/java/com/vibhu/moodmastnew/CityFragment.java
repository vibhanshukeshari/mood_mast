package com.vibhu.moodmastnew;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vibhu.moodmastnew.Adapter.ItemAdapterCity;
import com.vibhu.moodmastnew.Model.ItemList;

public class CityFragment extends Fragment {

    RecyclerView recyclerViewCity;
    View view;
    ItemList[] mData = new ItemList[] {

            new ItemList("Sample",R.drawable.seagull_hd),
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


    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_city, container, false);
        recyclerViewCity = view.findViewById(R.id.recyclerViewCity);


        ItemAdapterCity itemAdapterCity = new ItemAdapterCity(mData);
        recyclerViewCity.setHasFixedSize(true);


//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewCity.setAdapter(itemAdapterCity);
//


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerViewCity.setLayoutManager(gridLayoutManager);









        return view;

    }
}