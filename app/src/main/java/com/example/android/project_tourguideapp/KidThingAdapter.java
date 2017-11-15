package com.example.android.project_tourguideapp;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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

class KidThingAdapter extends ArrayAdapter<KidThing> {

    /**
     * Constructor for KidThingAdapter
     *
     * @param context   Context providing interface to application environment.
     * @param kidThings Object containing data for a child-friendly place/event.
     */
    KidThingAdapter(@NonNull Context context, @NonNull ArrayList<KidThing> kidThings) {
        super(context, 0, kidThings);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Get the {@link KidThing} object located at this position in the list
        KidThing currentKidThing = getItem(position);

        // Cache with view lookup for a KidThing object which will be stored in a tag
        ViewHolder viewHolder;

        // Check if the current view is being reused or needs to be inflated
        View listItemView = convertView;
        if (listItemView == null) {
            // Instantiate new ViewHolder object to cache Views for current KidThing
            viewHolder = new ViewHolder();

            // Inflate current view
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            // Perform View lookups and cache those in the ViewHolder:

            // Find the TextView in the list_item layout with the ID listing_title
            viewHolder.listingTitle = (TextView) listItemView.findViewById(R.id.listing_title);

            // Find the ImageView in the list_item layout with the ID listing_image
            viewHolder.listingImage = (ImageView) listItemView.findViewById(R.id.listing_image);

            // Find the TextView in the list_item layout with the ID listing_hours_dates
            viewHolder.listingHoursDates = (TextView) listItemView.findViewById(R.id.listing_hours_dates);

            // Find the TextView in the list_item layout with the ID listing_description_snippet
            viewHolder.listingDescription = (TextView) listItemView.findViewById(R.id.listing_description_snippet);

            // Cache the viewHolder object inside the fresh view
            listItemView.setTag(viewHolder);

        } else { // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set the background color, alternating colors based upon items position in the arraylist
        if (position % 2 == 0) {
            listItemView.setBackgroundColor(Color.parseColor("#" + Integer.toHexString(ContextCompat.getColor(getContext(), R.color.colorPrimaryLight))));
        } else {
            listItemView.setBackgroundColor(Color.parseColor("#" + Integer.toHexString(ContextCompat.getColor(getContext(), R.color.colorAccentLight))));
        }

        // Set the listing name on the appropriate TextView cached in the ViewHolder
        viewHolder.listingTitle.setText(currentKidThing.getListingName());

        // Check whether the current item has an associated thumbnail image. (Banner image isn't used here).
        // If so, assign image to the ImageView cached in the ViewHolder.
        // If no associated image, turn the ImageView off.
        if (currentKidThing.hasImage()) {
            viewHolder.listingImage.setImageResource(currentKidThing.getThumbnailImageResourceId());
            viewHolder.listingImage.setVisibility(View.VISIBLE);
        } else {
            viewHolder.listingImage.setVisibility(View.GONE);
        }

        // Check whether the current item has a associated hours/dates.
        // If so, assign text to the TextView cached in the ViewHolder.
        // If no associated hours/dates, turn the TextView off.
        if (currentKidThing.hasHoursDates()) {
            viewHolder.listingHoursDates.setText(currentKidThing.getHoursDates());
            viewHolder.listingHoursDates.setVisibility(View.VISIBLE);
        } else {
            viewHolder.listingHoursDates.setVisibility(View.GONE);
        }

        // Set the listing description snippet on the appropriate TextView cached in the ViewHolder
        viewHolder.listingDescription.setText(currentKidThing.getDescription());

        // Return the whole list item layout (containing all Views) so that it can be shown in the ListView
        return listItemView;

    }

    // View lookup cache
    private static class ViewHolder {
        TextView listingTitle;
        ImageView listingImage;
        TextView listingHoursDates;
        TextView listingDescription;
    }
}
