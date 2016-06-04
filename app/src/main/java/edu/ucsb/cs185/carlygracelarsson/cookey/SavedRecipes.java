package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class SavedRecipes extends AppCompatActivity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    RecipeGridViewAdapter recipeGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_recipes);

        gridArray.add(new Item("Chicken Pie", R.drawable.chicken_pie, new Integer[]{R.drawable.chicken_pie1, R.drawable.chicken_pie2}, 2, "45", getResources().getString(R.string.des_chick), R.array.DChickenPie, R.array.IChickenPie));
        gridArray.add(new Item("Classic Cookies", R.drawable.cookie, new Integer[]{R.drawable.cookie1, R.drawable.cookie2, R.drawable.cookie3}, 1, "30", getResources().getString(R.string.des_cookies), R.array.DChocolateChipCookies, R.array.IChocolateChipCookies));
        gridArray.add(new Item("Carrot Cake", R.drawable.carrot_cake, new Integer[]{}, 2, "80", getResources().getString(R.string.des_carrot), R.array.DCarrotCake, R.array.ICarrotCake));
        gridArray.add(new Item("Potato Wedges", R.drawable.potato_wedges, new Integer[]{}, 1, "20", getResources().getString(R.string.des_potato), R.array.DPotatoWedges, R.array.IPotatoWedges));
        //gridArray.add(new Item("Spring Rolls", R.drawable.spring_rolls, new Integer[]{}, 3, "35", getResources().getString(R.string.des_spring), R.array.DSpringRolls, R.array.ISpringRolls));
        gridArray.add(new Item("Eggs Benedict", R.drawable.eggs, new Integer[]{}, 1, "40", getResources().getString(R.string.des_eggs), R.array.DEggs, R.array.IEggs));
        //gridArray.add(new Item("Tomato Tart", R.drawable.tomato_tart, new Integer[]{}, 2, "25", getResources().getString(R.string.des_tomato), R.array.DTomatoTart, R.array.ITomatoTart));
        gridArray.add(new Item("Coconut Pie", R.drawable.coconut_cheese, new Integer[]{}, 1, "50", getResources().getString(R.string.des_coconut), R.array.DCoconutPie, R.array.ICoconutPie));
        //gridArray.add(new Item("Cheese Cigars", R.drawable.goat_cheese, new Integer[]{}, 1, "40", getResources().getString(R.string.des_cheese), R.array.DCheese, R.array.ICheese));


        gridView = (GridView) findViewById(R.id.gridview);
        recipeGridViewAdapter = new RecipeGridViewAdapter(this, R.layout.main_menu_elem, gridArray, getFragmentManager());
        gridView.setAdapter(recipeGridViewAdapter);

    }


}