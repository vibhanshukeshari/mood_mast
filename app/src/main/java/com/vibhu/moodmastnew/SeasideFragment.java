package com.vibhu.moodmastnew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vibhu.moodmastnew.Adapter.ItemAdapter;
import com.vibhu.moodmastnew.Model.ItemList;

public class SeasideFragment extends Fragment {

    RecyclerView recyclerView;
    View view;

    ItemList[] mData = new ItemList[] {

            new ItemList("Seagull",R.drawable.seagull_hd),
            new ItemList("Campfire",R.drawable.campfire_hd),
            new ItemList("Wave",R.drawable.wind_hd),
            new ItemList("Rain",R.drawable.rain_hd),
            new ItemList("Storm",R.drawable.storm_hd),
            new ItemList("Boat",R.drawable.boat_hd),
            new ItemList("Rowboat",R.drawable.rowboat_hd),
            new ItemList("Guitar",R.drawable.guitar_hd),

    };









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =   inflater.inflate(R.layout.fragment_seaside, container, false);

//        setRetainInstance(true);

        recyclerView = view.findViewById(R.id.recyclerView);


        ItemAdapter itemAdapter = new ItemAdapter(mData);
        recyclerView.setHasFixedSize(true);


//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(itemAdapter);
//


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);



       return view;


    }
}