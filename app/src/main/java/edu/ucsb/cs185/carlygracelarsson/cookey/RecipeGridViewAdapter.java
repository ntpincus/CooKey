package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Taylor on 6/2/2016.
 */
public class RecipeGridViewAdapter extends ArrayAdapter<Item> {
        Context context;
        int layoutResourceId;
        ArrayList<Item> data = new ArrayList<Item>();

        public RecipeGridViewAdapter(Context context, int layoutResourceId,
        ArrayList<Item> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            RecordHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new RecordHolder();
                holder.txtMinutes = (TextView) row.findViewById(R.id.time_textview);
                holder.txtTitle = (TextView) row.findViewById(R.id.recipe_title);
                holder.imageItem = (ImageView) row.findViewById(R.id.recipe_image);
                row.setTag(holder);
            } else {
                holder = (RecordHolder) row.getTag();
            }

            final Item item = data.get(position);

            holder.txtMinutes.setText(item.getTimeToComplete());

            holder.txtTitle.setText(item.getTitle());

            Typeface arvo_font = Typeface.createFromAsset(context.getAssets(), "arvo-bold.ttf");

            holder.txtTitle.setTypeface(arvo_font);

            switch (item.getDifficulty()){
                case 1:
                    holder.txtTitle.setBackgroundColor(context.getResources().getColor(R.color.colorBeginner));
                    break;
                case 2:
                    holder.txtTitle.setBackgroundColor(context.getResources().getColor(R.color.colorIntermediate));
                    break;
                case 3:
                    holder.txtTitle.setBackgroundColor(context.getResources().getColor(R.color.colorMaster));
                    break;

            }
            //holder.imageItem.setImageBitmap(item.getImage());
            Picasso.with(context)
                    .load(item.getResourceId())
                    .centerCrop()
                            //.resize(holder.imageItem.getMeasuredWidth(),holder.imageItem.getMeasuredWidth())
                    .resize(400, 400)
                    .into(holder.imageItem);

            holder.imageItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), ScrollingActivity.class);
                    getContext().startActivity(intent);
                }
            });


        return row;

    }

        static class RecordHolder {
            TextView txtMinutes;
            TextView txtTitle;
            ImageView imageItem;

        }
    }
