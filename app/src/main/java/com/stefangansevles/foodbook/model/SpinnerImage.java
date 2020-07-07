package com.stefangansevles.foodbook.model;

/**
 * Created by Stefan Gansevles on 7-7-2020
 */

public class SpinnerImage
{
    private int img;
    private String text;
    private FoodTypes foodType = null;
    private Countries country = null;

    public SpinnerImage(int img, String text, FoodTypes foodType)
    {
        this.img = img;
        this.text = text;
        this.foodType = foodType;
    }
    public SpinnerImage(int img, String text, Countries country)
    {
        this.img = img;
        this.text = text;
        this.country = country;
    }

    public int getImg()
    {
        return img;
    }

    public String getText()
    {
        return text;
    }

    public FoodTypes getFoodType()
    {
        return foodType;
    }

    public Countries getCountry()
    {
        return country;
    }
}
