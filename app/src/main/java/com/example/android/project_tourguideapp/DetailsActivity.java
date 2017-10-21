package com.example.android.project_tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    // Global variable that will later serve as a reference to a FragmentManager instance for multiple transactions
    FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);
        setContentView(R.layout.activity_details);


        // TODO: Do I need to check whether ListingDetailFragment instance exists?
        ListingDetailFragment listingDetailFragment = new ListingDetailFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.detail_container_activity, listingDetailFragment).commit();

        // TODO: GET THE BUNDLE OF DATA PASSED WITH INTENT...
        Intent callingIntent = getIntent();
        Bundle bundle = callingIntent.getExtras();
        listingDetailFragment.setArguments(bundle);

    }


}
