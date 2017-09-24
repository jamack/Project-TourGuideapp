package com.example.android.project_tourguideapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link KidThingAdapter} is a custom {@link ArrayAdapter} that can provide a layout for each list item
 * based on a data source, which is a list of {@link KidThing} objects.
 */

public class KidThingAdapter extends ArrayAdapter<KidThing> {

    /**
     * Constructor for KidThingAdapter
     *
     * @param context
     * @param kidThings
     */
    public KidThingAdapter(@NonNull Context context, @NonNull ArrayList<KidThing> kidThings) {
        super(context, 0, kidThings);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /** Get the {@link KidThing} object located at this position in the list */
        KidThing currentKidThing = getItem(position);

        // Check if the current view is being reused or needs to be inflated
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // TODO: Figure out how to load color resources (in a way that works down to my minimum API 16 setting).
        listItemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        if (position % 2 == 0) {
//            listItemView.setBackgroundColor(getContext().getColor(R.color.colorAccent)); THIS ONLY WORKS FOR API 23 +...
            listItemView.setBackgroundColor(Color.parseColor("#E3F2FD"));
        } else {
            listItemView.setBackgroundColor(Color.parseColor("#FFE0B2"));
        }

        // Find the TextView in the list_item layout with the ID listing_title
        TextView listingTitle = (TextView) listItemView.findViewById(R.id.listing_title);
        listingTitle.setText(currentKidThing.getListingName());

        // Check whether the current item has an associated thumbnail image. (Banner image isn't used here).
        // If so, find the ImageView in the list_item layout with the ID listing listing_image
        // & assign image to the ImageView.
        // If no associated image, turn the ImageView off.
        ImageView listingImage = (ImageView) listItemView.findViewById(R.id.listing_image);
        if (currentKidThing.hasImage()) {
            listingImage.setImageResource(currentKidThing.getThumbnailImageResourceId());
            listingImage.setVisibility(View.VISIBLE);
        } else {
            listingImage.setVisibility(View.GONE);
        }

        // Check whether the current item has a associated hours/dates.
        // Find the TextView in the list_item layout with the ID listing_hours_dates
        // & assign text to the TextView.
        // If no associated hours/dates, turn the TextView off.
        TextView listingHoursDates = (TextView) listItemView.findViewById(R.id.listing_hours_dates);
        if (currentKidThing.hasHoursDates()) {
            listingHoursDates.setText(currentKidThing.getHoursDates());
            listingHoursDates.setVisibility(View.VISIBLE);
        } else {
            listingHoursDates.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item layout with the ID listing_description_snippet
        TextView listingDescription = (TextView) listItemView.findViewById(R.id.listing_description_snippet);
        listingDescription.setText(currentKidThing.getDescription());

        // Return the whole list item layout (containing all Views) so that it can be shown in the ListView
        return listItemView;

    }
}
