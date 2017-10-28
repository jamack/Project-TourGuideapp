package com.example.android.project_tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);
        setContentView(R.layout.activity_details);


        // TODO: Do I need to check whether ListingDetailFragment instance exists?
        // TODO: Or can I simply nullify it in MainActivity's lifecycle? (Do I have to mmanually address it at all?)
        // Create new instance of ListingDetailFragment
        ListingDetailFragment listingDetailFragment = new ListingDetailFragment();
        // Replace container in xml layout with this ListingDetailFragment instance
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_container_activity, listingDetailFragment).commit();

        // Following code identifies the Intent that started DetailsActivity and gets the Bundle of details for a KidThing object
        // that we set as an agrument in that calling Activity (MainActivity)
        Intent callingIntent = getIntent();
        Bundle bundle = callingIntent.getExtras();
        listingDetailFragment.setArguments(bundle);

    }


}
