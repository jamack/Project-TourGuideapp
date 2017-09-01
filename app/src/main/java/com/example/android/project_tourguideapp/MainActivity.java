package com.example.android.project_tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //String temp = getString(R.string.park_westmorland_listing_title);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout with a container view (which will be replaced by the fragments)
        setContentView(R.layout.activity_main);

        // Get the xml layout's ViewPager widget and assign to a variable
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        // Create a new KidThingFragmentAdapter instance via its constructor, passing it a FragmentManager instance
        KidThingFragmentPagerAdapter adapter = new KidThingFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        // Get the xml layout's TabLayout widget and assign to a variable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // Set the ViewPager on the TabLayout to connect the pager with the tabs
        tabLayout.setupWithViewPager(viewPager);


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
