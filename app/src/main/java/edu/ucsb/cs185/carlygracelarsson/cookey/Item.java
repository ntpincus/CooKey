package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.graphics.Bitmap;
import android.net.Uri;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Taylor on 6/1/2016.
 */
public class Item {
    private String title;
    private Bitmap image;
    private int resourceId;
    private Integer[] photos;
    private int difficulty;
    private String timeToComplete;
    private String[] recipeDirections;
    private String recipeDescription;
    private String[] recipeIngredients;

    public Item(String ti, int id, Integer[] p, int diff, String t){
        title = ti;
        resourceId = id;
        photos = p;
        difficulty = diff;
        timeToComplete = t;
    }


    public Item(Bitmap i, String ti, int id, Integer[] p, int diff, String t, String rde, String[] ri){
        title = ti;
        image = i;
        resourceId = id;
        photos = p;
        difficulty = diff;
        timeToComplete = t;
        recipeDescription = rde;
        recipeIngredients = ri;
    }

    public Item(Bitmap i, String ti, int id, Integer[] p, int diff, String t, String[] rdi, String[] ri)
    {
        title = ti;
        image = i;
        resourceId = id;
        photos = p;
        difficulty = diff;
        timeToComplete = t;
        recipeDirections = rdi;
        recipeIngredients = ri;
    }


    public String getTitle(){
        return title;
    }
    public int getResourceId(){
        return resourceId;
    }
    public Integer[] getPhotos(){
        return photos;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public String getTimeToComplete(){return timeToComplete; }
}
