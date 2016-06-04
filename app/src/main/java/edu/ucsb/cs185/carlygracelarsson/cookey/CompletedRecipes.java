package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;



public class CompletedRecipes extends AppCompatActivity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    CompletedRecipeGridViewAdapter completedRecipeGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_recipes);


        gridArray.add(new Item("Chicken Pie", R.drawable.chicken_pie, new Integer[]{R.drawable.chicken_pie1, R.drawable.chicken_pie2}, 2, "45"));
        gridArray.add(new Item("Classic Cookies", R.drawable.cookie, new Integer[]{R.drawable.cookie1, R.drawable.cookie2, R.drawable.cookie3,R.drawable.cookie3}, 1, "30"));
        gridArray.add(new Item("Carrot Cake", R.drawable.carrot_cake, new Integer[]{}, 2, "80"));
        //gridArray.add(new Item("Potato Wedges", R.drawable.potato_wedges, new Integer[]{}, 1, "20"));
        //gridArray.add(new Item("Spring Rolls", R.drawable.spring_rolls, new Integer[]{}, 3, "35"));
        //gridArray.add(new Item("Tomato Tart", R.drawable.tomato_tart, new Integer[]{}, 3, "25"));

        gridView = (GridView) findViewById(R.id.gridview);
        completedRecipeGridViewAdapter = new CompletedRecipeGridViewAdapter(this, R.layout.completed_recipe_elem, gridArray);
        gridView.setAdapter(completedRecipeGridViewAdapter);
    }
}