package com.example.restaurantmadness;

public class Book {

    private String mBookName;
    private String mBookTime;
    private String mBookNumber;

    public Book(String bookname, String booktime, String booknumber){
        mBookName = bookname;
        mBookTime = booktime;
        mBookNumber = booknumber;
    }

    public String getBookName(){
        return mBookName;
    }

    public String getBookTime(){
        return mBookTime;
    }

    public String getBookNumber(){
        return mBookNumber;
    }

}
