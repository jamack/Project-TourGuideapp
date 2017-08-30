package com.example.android.project_tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //String temp = getString(R.string.park_westmorland_listing_title);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listing_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.listing_container, new ParksListFragment()).commit();

//        final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
//        kidThings.add(new KidThing(getString(R.string.park_westmorland_listing_title), R.drawable.westmorland_park_01_thumbnail, getString(R.string.park_westmorland_description), getString(R.string.park_westmorland_address), getString(R.string.park_westmorland_hours_dates), getString(R.string.park_westmorland_website)));
//        kidThings.add(new KidThing("Odana Hills East Park", R.drawable.westmorland_park_01_thumbnail,
//                "String_description", "String_address",
//                "String_hours and dates", "String_web address"));
//        kidThings.add(new KidThing("String_KidThing02", R.drawable.westmorland_park_01_thumbnail,
//                "String_description", "String_address",
//                "String_hours and dates", "String_web address"));
//
//        ListView listView = (ListView) findViewById(R.id.list_view);
//
//        // Create instance of KidThing custom adapter
//        KidThingAdapter kidThingAdapter = new KidThingAdapter(this, kidThings);
//
//        // Attach the newly instantiated KidThingAdapter on the ListView
//        listView.setAdapter(kidThingAdapter);

    }
}
