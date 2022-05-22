package com.example.restaurantmadness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    Context mContext;
    List<Food> mData;

    public FoodAdapter(Context mContext, List<Food> mData){
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.food_item_list,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.foodName.setText(mData.get(position).getName());
        holder.foodPrice.setText(mData.get(position).getPrice());
        holder.foodImage.setImageResource(mData.get(position).getImage());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        private TextView foodName;
        private TextView foodPrice;
        private ImageView foodImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = (TextView) itemView.findViewById(R.id.food_name);
            foodPrice = (TextView) itemView.findViewById(R.id.food_price);
            foodImage = (ImageView) itemView.findViewById(R.id.food_img);


        }
    }



}
