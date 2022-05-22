package com.example.restaurantmadness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    public ArrayList<Book> mBookList;


    public static class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView bName;
        public TextView bTime;
        public TextView bNumber;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bName = itemView.findViewById(R.id.book_name);
            bTime = itemView.findViewById(R.id.book_time);
            bNumber = itemView.findViewById(R.id.book_number);
        }
    }

    public BookAdapter(ArrayList<Book> bookList) {
        mBookList = bookList;
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_list,parent, false);
        BookViewHolder bvh = new BookViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book currentItem = mBookList.get(position);

        holder.bName.setText(currentItem.getBookName());
        holder.bTime.setText(currentItem.getBookTime());
        holder.bNumber.setText(currentItem.getBookNumber());

    }

    @Override
    public int getItemCount() {
        return mBookList.size();
    }





}
