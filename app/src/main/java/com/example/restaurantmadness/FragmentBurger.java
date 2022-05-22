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

public class FragmentBurger extends Fragment {

    View v ;
    private RecyclerView myrecyclerview;
    private List<Food> lstFood;

    public  FragmentBurger(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.burger_fragment, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.burger_Recycler);
        FoodAdapter recyclerAdapter = new FoodAdapter(getContext(), lstFood);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstFood = new ArrayList<>();
        lstFood.add(new Food("Hamburger","4$",R.drawable.hamburger));
        lstFood.add(new Food("Cheeseburger","6$",R.drawable.cheese));
        lstFood.add(new Food("Black Bean Burger","7$",R.drawable.blackbean));
        lstFood.add(new Food("Mushroom Cheeseburger","7$",R.drawable.cheesemushroom));
        lstFood.add(new Food("Loco Moco Rice Burger","9$",R.drawable.locomoco));
        lstFood.add(new Food("Fried Chicken Sandwich","12$",R.drawable.buttermilk));
        lstFood.add(new Food("Sweet Potato Burger","9$",R.drawable.sweetpotato));
        lstFood.add(new Food("Hummus Veggie Burger","7$",R.drawable.hummus));

    }
}
