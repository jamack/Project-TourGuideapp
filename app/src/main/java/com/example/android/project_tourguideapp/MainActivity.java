package com.example.android.project_tourguideapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ParksListFragment.OnParksFragmentInteractionListener {

    // Create global variable to later hold reference to a FragmentManager instance
    FragmentManager fragmentManager;
    // Global variable to hold reference to a ListingDetailFragment (if present)
    ListingDetailFragment listingDetailFragment;
    // Track whether a ListingDetailFragment is being displayed alongside the listing
    private boolean isDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout with a container view (which will be replaced by the fragments)
        setContentView(R.layout.activity_main);

        // Get a FragmentManager instance to be used throughout Activity and assign to the global variable.
        fragmentManager = getSupportFragmentManager();

        // Get the xml layout's ViewPager widget and assign to a variable
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        // Create a new KidThingFragmentAdapter instance via its constructor, passing it a FragmentManager instance
        KidThingFragmentPagerAdapter adapter = new KidThingFragmentPagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);

        // Get the xml layout's TabLayout widget and assign to a variable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // Set the ViewPager on the TabLayout to connect the pager with the tabs
        tabLayout.setupWithViewPager(viewPager);


        // Check for current orientation: if R.id.detail_container is present in view hierarchy,
        // then landscape xml layout is being used. If not present, then we are in portrait orientation.
        FrameLayout detailContainer = (FrameLayout) findViewById(R.id.detail_container);
        if (detailContainer != null) {
            Log.v("***TESTING***", "We have found the FrameLayout!!");
            isDualPane = true;

            // TODO: Do I need to check whether ListingDetailFragment instance exists?
            // Create ListingDetailFragment instance and assign to global variable
            listingDetailFragment = new ListingDetailFragment();

            // Add fragment to the container
            fragmentManager.beginTransaction().add(R.id.detail_container, listingDetailFragment).commit();

//            // TODO: APP CRASHES WHEN I CALL THIS METHOD...PERHAPS THE FRAGMENT'S VIEW HIERARCHY ISN'T CREATED YET IN THE ONCREATE METHOD??
//            // Call a method in the listingDetailFragment instance to update its content
//            listingDetailFragment.updateListingDetails(1);

        } else {
            isDualPane = false;
            listingDetailFragment = null;
        }


//         CODE BELOW IS SIMPLY USING A LISTVIEW + CUSTOM ADAPTER FOR THE ACTIVITY - NO FRAGMENTS OR VIEWPAGER.
//         SAVING THIS TEMPORARILY SO I CAN REVIEW & MEMORIZE IT.
//
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

    // TODO: Add code implementing the onParksFragmentInteraction method...
    public void onParksFragmentInteraction(int position) {
        Toast.makeText(this, "Item #" + Integer.toString(position) + " selected - making toast!", Toast.LENGTH_LONG).show();

        // The user selected a listing from one of the *ListFragments
        // Do something here to display that listing's details

//        ListingDetailFragment detailFrag = (ListingDetailFragment)
//                getSupportFragmentManager().findFragmentById(R.id.fragment_listing_detail);
//
////        if (detailFrag != null) {
//            // If article frag is available, we're in two-pane layout...
//
//            // Call a method in the ListingDetailFragment to update its content
//            detailFrag.updateListingDetails(position);
//            Log.v("***TESTING***", "detailFrag is present and is NOT null...");
//            getSupportFragmentManager().beginTransaction().add(R.id.detail_container, detailFrag).commit();
        if (listingDetailFragment != null) {
            // If listingDetailFragment is not null, then a detail fragment already exists and we're in two-pane layout.
            Log.v("***TESTING***", "In onParksFragmentInteraction method. Existing detail fragment's existence has been recognized!");

            // Call a method in the ListingDetailFragment to update its content
            listingDetailFragment.updateListingDetails(position);

        } else {
            Log.v("***TESTING***", "detailFrag is IS null - so it was NOT located...");
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected listing
            ListingDetailFragment newFragment = new ListingDetailFragment();
            Bundle args = new Bundle();
            args.putInt(ListingDetailFragment.ARG_POSITION, position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.detail_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }


//        if (isDualPane) {
//            ListingDetailFragment detailFragment = (ListingDetailFragment) fragmentManager.findFragmentById(R.id.fragment_listing_detail);
//            detailFragment.updateListingDetails(position);
//        }
    }
}
