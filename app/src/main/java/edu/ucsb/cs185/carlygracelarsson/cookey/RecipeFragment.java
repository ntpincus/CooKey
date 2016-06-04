package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by carlygracelarsson on 6/4/16.
 */
public class RecipeFragment extends DialogFragment
{
    public static RecipeFragment  newInstance(Item recipeItem)
    {
        RecipeFragment recipeFragement = new RecipeFragment();

        Bundle args = new Bundle();
        args.putInt("recipeDirectionsId", recipeItem.getRecipeDirectionsId());
        args.putInt("recipeIngredientsId", recipeItem.getRecipeIngredientsId());
        args.putInt("imageId", recipeItem.getResourceId());
        args.putInt("difficulty", recipeItem.getDifficulty());
        args.putString("title", recipeItem.getTitle());
        args.putString("time", recipeItem.getTimeToComplete());
        args.putString("description", recipeItem.getRecipeDescription());

        recipeFragement.setArguments(args);

        return recipeFragement;
    };



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //teamScoreCommunicator = (TeamScoreCommunicator) activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        RelativeLayout relativeLayout= new RelativeLayout(getActivity());

        View v = View.inflate(getActivity(), R.layout.fragment_recipe, null);
        relativeLayout.addView(v);

        final Bundle args = getArguments();
        TextView titleTextView = (TextView) relativeLayout.findViewById(R.id.recipe_title);

        Typeface arvo_font = Typeface.createFromAsset(getContext().getAssets(), "arvo-bold.ttf");

        titleTextView.setTypeface(arvo_font);
        titleTextView.setText(args.getString("title"));

        ImageView recipeImage = (ImageView) relativeLayout.findViewById(R.id.recipe_image);

        Picasso.with(getContext())
                .load(args.getInt("imageId"))
                .centerCrop()
                .resize(900, 700)
                .into(recipeImage);


        TextView minutesTextView = (TextView) relativeLayout.findViewById(R.id.time_textview);
        minutesTextView.setText(args.getString("time"));

        TextView descriptionTextView = (TextView) relativeLayout.findViewById(R.id.recipe_description);

        String[] ingredientsArray = getResources().getStringArray(args.getInt("recipeIngredientsId"));
        String ingredientsString = "Ingredients:\n";
        for (int i = 0; i < ingredientsArray.length; i++){
            ingredientsString = ingredientsString + ingredientsArray[i] + "\n";
        }

        descriptionTextView.setText(args.getString("description") + "\n\n" + ingredientsString);

        Button startButton = (Button) relativeLayout.findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ScrollingActivity.class);
                intent.putExtra("recipeTitle", args.getString("title"));
                intent.putExtra("recipeDirectionsId", args.getInt("recipeDirectionsId"));
                intent.putExtra("recipeIngredientsId", args.getInt("recipeIngredientsId"));
                getContext().startActivity(intent);
                dismiss();
            }
        });


        Button saveButton = (Button) relativeLayout.findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Add recipe to Saved Recipes", Toast.LENGTH_SHORT).show();
            }
        });
        return relativeLayout;
    }


}
