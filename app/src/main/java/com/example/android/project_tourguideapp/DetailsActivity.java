package com.example.android.project_tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);
        setContentView(R.layout.activity_details);


//        // TODO: Do I need to check whether ListingDetailFragment instance exists?
//        // Create ListingDetailFragment instance and assign to global variable
//        listingDetailFragment = new ListingDetailFragment();
//        listingDetailFragment.setArguments(ParksListFragment.getBundle(0));
//
//        // Add fragment to the container
//        fragmentManager.beginTransaction().add(R.id.detail_container, listingDetailFragment).commit();

        ListingDetailFragment listingDetailFragment = new ListingDetailFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_container_activity, listingDetailFragment).commit();

        // TODO: GET THE BUNDLE OF DATA PASSED WITH INTENT...
        Intent callingIntent = getIntent();
        Bundle bundle = callingIntent.getExtras();
        listingDetailFragment.setArguments(bundle);

        // TODO: THE BELOW CODE IS JUST FOR TESTING. IT SHOWS THAT BUNDLE IS BEING RECEIVED FINE.
        if (bundle.get(ListingDetailFragment.ARG_LISTING_NAME) != null) {
            Log.v("***TESTING***", "In Details Activity. Bundle retrieved. Confirmed it holds one of the keys!");
        }

//        // TODO: THIS METHOD CALL IS CURRENTLY CAUSING A NULL POINTER EXCEPTION CRASH!!!
//        listingDetailFragment.updateListingDetails(bundle);

    }
}
