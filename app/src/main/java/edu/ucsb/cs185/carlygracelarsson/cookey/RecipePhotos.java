package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;


public class RecipePhotos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_photos);

        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();
        String recipeTitle = (String) extras.get("RecipeTitle");
        final Integer[] recipePhotos = (Integer[]) extras.get("RecipePhotos");

        setTitle(recipeTitle);

        GridView gridView = (GridView) findViewById(R.id.recipe_photos_gridview);
        gridView.setAdapter(new ImageAdapter(this, recipePhotos));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Open camera to take additional photos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
