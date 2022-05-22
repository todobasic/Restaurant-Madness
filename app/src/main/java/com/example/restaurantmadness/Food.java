package com.example.restaurantmadness;

public class Food {

    private String Name;
    private String Price;
    private int Image;

    public Food(){

    }

    public Food(String name, String price, int image){
        Name = name;
        Price = price;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public int getImage() {
        return Image;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setImage(int image) {
        Image = image;
    }
}
