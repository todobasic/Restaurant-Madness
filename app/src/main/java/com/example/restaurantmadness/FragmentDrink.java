package com.example.restaurantmadness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentDrink extends Fragment {

    View v ;
    private RecyclerView myrecyclerview;
    private List<Food> lstFood;

    public  FragmentDrink(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.drink_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.drink_Recycler);
        FoodAdapter recyclerAdapter = new FoodAdapter(getContext(), lstFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstFood = new ArrayList<>();
        lstFood.add(new Food("Water","2$",R.drawable.water));
        lstFood.add(new Food("Juices (all)","4$",R.drawable.juices));
        lstFood.add(new Food("Cosmopolitan","7$",R.drawable.cosmopolitan));
        lstFood.add(new Food("Mojito","7$",R.drawable.mojito));
        lstFood.add(new Food("Mai Tai","10$",R.drawable.maitai));
        lstFood.add(new Food("Margarita","10$",R.drawable.margarita));
        lstFood.add(new Food("Pina Colada","12$",R.drawable.pinacolada));
        lstFood.add(new Food("Long Island Ice Tea","15$",R.drawable.longislandicetea));
    }

}
