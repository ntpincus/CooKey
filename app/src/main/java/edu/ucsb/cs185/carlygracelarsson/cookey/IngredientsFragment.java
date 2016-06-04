package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class IngredientsFragment extends DialogFragment {

    public static IngredientsFragment newInstance(String title, int ingredientsId)
    {
        IngredientsFragment ingredientsFragment = new IngredientsFragment();

        Bundle args = new Bundle();
        args.putString("recipeTitle", title);
        args.putInt("recipeIngredientsId", ingredientsId);

        ingredientsFragment.setArguments(args);

        return ingredientsFragment;
    };

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        RelativeLayout relativeLayout= new RelativeLayout(getActivity());

        View v = View.inflate(getActivity(), R.layout.fragment_ingredients, null);
        relativeLayout.addView(v);

        TextView titleTextView = (TextView) relativeLayout.findViewById(R.id.recipe_title);

        Typeface arvo_font = Typeface.createFromAsset(getContext().getAssets(), "arvo-bold.ttf");
        final Bundle args = getArguments();
        titleTextView.setTypeface(arvo_font);
        titleTextView.setText(args.getString("recipeTitle"));

        TextView ingredientsTextView = (TextView) relativeLayout.findViewById(R.id.ingredients);
        String[] ingredientsArray = getResources().getStringArray(args.getInt("recipeIngredientsId"));
        String ingredientsString = "";
        for (int i = 0; i < ingredientsArray.length; i++){
            ingredientsString = ingredientsString + ingredientsArray[i] + "\n";
        }
        ingredientsTextView.setText(ingredientsString);

        return relativeLayout;
    }

}
