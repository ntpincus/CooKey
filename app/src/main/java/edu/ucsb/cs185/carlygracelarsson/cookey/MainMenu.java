package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    RecipeGridViewAdapter recipeGridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.starttoolbar);
        setSupportActionBar(toolbar);


        gridArray.add(new Item("Chicken Pie", R.drawable.chicken_pie, new Integer[]{R.drawable.chicken_pie1, R.drawable.chicken_pie2}, 2, "45", getResources().getString(R.string.des_chick), R.array.DChickenPie, R.array.IChickenPie));
        gridArray.add(new Item("Classic Cookies", R.drawable.cookie, new Integer[]{R.drawable.cookie1, R.drawable.cookie2, R.drawable.cookie3}, 1, "30", getResources().getString(R.string.des_cookies), R.array.DChocolateChipCookies, R.array.IChocolateChipCookies));
        gridArray.add(new Item("Carrot Cake", R.drawable.carrot_cake, new Integer[]{}, 2, "80", getResources().getString(R.string.des_carrot), R.array.DCarrotCake, R.array.ICarrotCake));
        gridArray.add(new Item("Potato Wedges", R.drawable.potato_wedges, new Integer[]{}, 1, "20", getResources().getString(R.string.des_potato), R.array.DPotatoWedges, R.array.IPotatoWedges));
        gridArray.add(new Item("Spring Rolls", R.drawable.spring_rolls, new Integer[]{}, 3, "35", getResources().getString(R.string.des_spring), R.array.DSpringRolls, R.array.ISpringRolls));
        gridArray.add(new Item("Eggs Benedict", R.drawable.eggs, new Integer[]{}, 1, "40", getResources().getString(R.string.des_eggs), R.array.DEggs, R.array.IEggs));
        gridArray.add(new Item("Tomato Tart", R.drawable.tomato_tart, new Integer[]{}, 2, "25", getResources().getString(R.string.des_tomato), R.array.DTomatoTart, R.array.ITomatoTart));
        gridArray.add(new Item("Coconut Pie", R.drawable.coconut_cheese, new Integer[]{}, 1, "50", getResources().getString(R.string.des_coconut), R.array.DCoconutPie, R.array.ICoconutPie));
        gridArray.add(new Item("Cheese Cigars", R.drawable.goat_cheese, new Integer[]{}, 1, "40", getResources().getString(R.string.des_cheese), R.array.DCheese, R.array.ICheese));


        gridView = (GridView) findViewById(R.id.gridview);
        recipeGridViewAdapter = new RecipeGridViewAdapter(this, R.layout.main_menu_elem, gridArray, this.getFragmentManager());
        gridView.setAdapter(recipeGridViewAdapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.view_photos ){
                Intent intent = new Intent(this, ViewPhotos.class);
                this.startActivity(intent);
        } else if (id == R.id.saved_recipes) {
            Intent intent = new Intent(this, SavedRecipes.class);
            this.startActivity(intent);
        } else if (id == R.id.completed_recipies) {
            Intent intent = new Intent(this, CompletedRecipes.class);
            this.startActivity(intent);
        } else if (id == R.id.settings) {
            Intent intent=new Intent(this, SettingsPage.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
