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

public class FragmentPizza extends Fragment {

    View v ;
    private RecyclerView myrecyclerview;
    private List<Food> lstFood;

    public  FragmentPizza(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.pizza_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.pizza_Recycler);
        FoodAdapter recyclerAdapter = new FoodAdapter(getContext(), lstFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstFood = new ArrayList<>();
        lstFood.add(new Food("Margarita","7$",R.drawable.pizzamargarita));
        lstFood.add(new Food("Capricciosa","10$",R.drawable.capricciosa));
        lstFood.add(new Food("Quattro Staggioni","10$",R.drawable.quattrostag));
        lstFood.add(new Food("Quattro Formaggio","12$",R.drawable.formaggi));
        lstFood.add(new Food("Pizza Lasagna","15$",R.drawable.lasagnapizza));
        lstFood.add(new Food("Pizza Twists","12$",R.drawable.pizzatwists));
        lstFood.add(new Food("Pizza Bombs","12$",R.drawable.bombspizza));
        lstFood.add(new Food("Pizza Tots","12$",R.drawable.totspizza));

    }

}
