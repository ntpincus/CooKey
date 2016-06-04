package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nates);

        // This code will replace my string array assignment, until then i get it from the "cookies" array in array.xml
        Intent intent = getIntent();

        final Bundle extras = intent.getExtras();
        String recipeTitle = extras.getString("recipeTitle");
        setTitle(recipeTitle);
        String[] stepList = this.getResources().getStringArray(extras.getInt("recipeDirectionsId"));
        //String[] stepList = this.getResources().getStringArray(R.array.DChickenPie);

        //String[] stepList = getResources().getStringArray(R.array.DChocolateChipCookies);
        //This code will replace my number of instructions to display. It is the number of steps of a recipe starting at 1
        Integer count = stepList.length; //
        //Integer count = 10;


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IngredientsFragment ingredientsFragment = IngredientsFragment.newInstance(extras.getString("recipeTitle") + " Ingredients", extras.getInt("recipeIngredientsId"));
                ingredientsFragment.show(getFragmentManager(), "Ingredients");
            }
        });

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /*LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.content_scrolling,
                null);*/
        Space space;
        ScrollView sv = new ScrollView(this);
        sv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT ));
        ll.setOrientation(LinearLayout.VERTICAL);

        space = new Space(this);
        space.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 40));
        ll.addView(space);
        sv.addView(ll);

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        int fadelen = (int) dpHeight/2;
        sv.setFadingEdgeLength(fadelen);
        sv.setVerticalFadingEdgeEnabled(true);

        for (int i = 0; i < count; i++) {
            View custom = inflater.inflate(R.layout.instruction_step, null);
            TextView stepNumber = (TextView) custom.findViewById(R.id.stepNum);
            TextView instructions = (TextView) custom.findViewById(R.id.instructions);
            stepNumber.setText("Step " + (i+1));
            instructions.setText(stepList[i]);
            ll.addView(custom);
            space = new Space(this);
            space.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 10));
            ll.addView(space);
        }
        Button button = new Button(this);
        button.setText("Finish");
        button.setTextColor(getResources().getColor(R.color.colorWhite));
        button.setTextSize(25);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
        button.setBackground(getResources().getDrawable(R.drawable.finish_style));
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ScrollingActivity.this, "You should now be routed to the congrats page", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ScrollingActivity.this, CongratsPage.class);
                startActivity(intent);
            }
        });
        ll.addView(button);

        rl.addView(sv);


    }
}
