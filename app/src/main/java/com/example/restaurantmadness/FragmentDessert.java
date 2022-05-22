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

public class FragmentDessert extends Fragment {

    View v ;
    private RecyclerView myrecyclerview;
    private List<Food> lstFood;

    public  FragmentDessert(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dessert_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.dessert_Recycler);
        FoodAdapter recyclerAdapter = new FoodAdapter(getContext(), lstFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstFood = new ArrayList<>();
        lstFood.add(new Food("Chocolate Chip Cookies","5$",R.drawable.cookies));
        lstFood.add(new Food("Chocolate Cupcake","4$",R.drawable.cupcakechoc));
        lstFood.add(new Food("Vanilla Cupcake","4$",R.drawable.cupcakevanilla));
        lstFood.add(new Food("Apple Pie","10$",R.drawable.applepie));
        lstFood.add(new Food("Ginger and Rum Pumpkin Pie","15$",R.drawable.gingerandrumpumpkinpie));
        lstFood.add(new Food("Chocolate Cake","25$",R.drawable.choccake));
        lstFood.add(new Food("Jelly Cheesecake","22$",R.drawable.jellycheesecake));
        lstFood.add(new Food("Unicorn Cheesecake","27$",R.drawable.unicorncheesecake));
    }

}
