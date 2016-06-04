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
    private int resourceId;
    private Integer[] photos;
    private int difficulty;
    private String timeToComplete;
    private int recipeDirectionsId;
    private String recipeDescription;
    private int recipeIngredientsId;

    public Item(String ti, int id, Integer[] p, int diff, String t){
        title = ti;
        resourceId = id;
        photos = p;
        difficulty = diff;
        timeToComplete = t;
    }


    public Item(String ti, int id, Integer[] p, int diff, String t, String description, int directionsId, int ingredientsId){
        title = ti;
        resourceId = id;
        photos = p;
        difficulty = diff;
        timeToComplete = t;
        recipeDescription = description;
        recipeDirectionsId = directionsId;
        recipeIngredientsId = ingredientsId;
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
    public int getRecipeDirectionsId(){return recipeDirectionsId;}
    public int getRecipeIngredientsId(){return recipeIngredientsId;}
    public String getRecipeDescription(){return recipeDescription;}
}
