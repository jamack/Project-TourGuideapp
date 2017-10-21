package com.example.android.project_tourguideapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        // Implement the OnFragmentInteractionListener interfaces in each listing's fragment.
        // This requires overriding & implementing the method signatures in each interface.
        implements ParksListFragment.OnParksFragmentInteractionListener,
        StoresListFragment.OnStoresFragmentInteractionListener,
        RestaurantsListFragment.OnRestaurantsFragmentInteractionListener,
        AttractionsListFragment.OnAttractionsFragmentInteractionListener {

    // Declare global variable to hold reference to the Activity's ActionBar
    private static ActionBar actionBar = null;
    // Create global variable to hold reference to which fragment / category of listings
    // is currently displayed in the FragmentViewPager.
    private static String mListingCategory = null;
    // Create global variable to later hold reference to a FragmentManager instance
    FragmentManager fragmentManager = null;
    // Global variable to hold reference to a ListingDetailFragment (if present)
    ListingDetailFragment listingDetailFragment = null;

    // Track whether a ListingDetailFragment is being displayed alongside the listing
    private boolean isDualPane;

    public static void setActionBarTitle(String title) {
        actionBar.setTitle(title);
    }

    public static void setListingCategory(String ListingCategory) {
        // Sets the global variable to reflect the currently displayed fragment / listing category.
        // Called from the setUserVisibleHint method in the listing category fragments.
        MainActivity.mListingCategory = ListingCategory;

        // TODO: FIGURE OUT HOW TO UPDATE THE INITIALLY-DISPLAYED DETAILS IN DUAL PANE MODE WHEN USER SWIPES TO A DIFFERENT CATEGORY/FRAGMENT...
//        if (R.id.detail_container != 0) {
//            if (ListingCategory == "ParksListFragment") {
//                getSupportFragmentManager().getFragmentById(R.id.fragment_listing_detail).updateListingDetails(ParksListFragment.getBundle(0));
//            } else if (ListingCategory == "AttractionsListFragment") {
//                this.listingDetailFragment.updateListingDetails(AttractionsListFragment.getBundle(0));
//            } else if (ListingCategory == "RestaurantsListFragment") {
//                listingDetailFragment.updateListingDetails(RestaurantsListFragment.getBundle(0));
//            } else if (ListingCategory == "StoresListFragment") {
//                listingDetailFragment.updateListingDetails(StoresListFragment.getBundle(0));
//            } else {
//                Log.v("***TESTING***","In the setListingCategory method & none of the if statements match up!!");}
//        }
    }

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
        // Hook the adapter up to the viewpager
        viewPager.setAdapter(adapter);

        // Get the xml layout's TabLayout widget and assign to a variable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // Set the ViewPager on the TabLayout to connect the pager with the tabs
        tabLayout.setupWithViewPager(viewPager);

        // Set the toolbar_list as the app bar for this Activity (via this Fragment)
        android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_list);
        setSupportActionBar(myToolbar);
        actionBar = getSupportActionBar();

        // TODO: SET MY STATUS BAR COLOR. (IS IT THE BEST PLACE TO PLACE THIS CODE?)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLUE);
        }

        // Check for current orientation: if R.id.detail_container is present in view hierarchy,
        // then landscape xml layout is being used. If not present, then we are in portrait orientation.
        FrameLayout detailContainer = (FrameLayout) findViewById(R.id.detail_container);
        if (detailContainer != null) {

            // If the detail_container view exists, we need to update the global variable to reflect two-pane mode
            isDualPane = true;

            // TODO: Do I need to check whether ListingDetailFragment instance exists?
            // Create ListingDetailFragment instance and assign to global variable
            listingDetailFragment = new ListingDetailFragment();

            // Get data for the first list item from the fragment with that arraylist, in the form of a bundle,
            // and pass that bundle to the detail fragment.
            listingDetailFragment.setArguments(ParksListFragment.getBundle(0));

            // Add fragment to the container
            fragmentManager.beginTransaction().add(R.id.detail_container, listingDetailFragment).commit();

        } else {

            // If the detail container view does NOT exist, we need to update the global variable to reflect one-pane mode
            isDualPane = false;

            // Nullify any previously created and now unused references to a detail fragment
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

    public void onParksFragmentInteraction(int position) {

        // If isDualPane is true, then from our previous check we already know that a detail fragment already exists and we're in two-pane layout.
        if (isDualPane) {

            // Call a method in the ListingDetailFragment to update its content.
            // We will pass it a Bundle generated via the ParksListFragment's getBundle method, for item the user has just clicked on.
            listingDetailFragment.updateListingDetails(ParksListFragment.getBundle(position));
        } else { // Otherwise, we're in the one-pane layout and must swap frags...

            // Create a new Activity Intent that will show a listing's details
            Intent detailIntent = new Intent(this, DetailsActivity.class);
            // Create a new bundle and fill it with data for a selected listing by calling the listing fragment's getBundle()
            Bundle bundle = ParksListFragment.getBundle(position);
            // Pass the selected listing's data to the Activity Intent in form of a bundle
            detailIntent.putExtras(bundle);
            // Start the detail activity
            startActivity(detailIntent);
        }
    }

    public void onStoresFragmentInteraction(int position) {

        // If isDualPane is true, then from our previous check we already know that a detail fragment already exists and we're in two-pane layout.
        if (isDualPane) {

            // Call a method in the ListingDetailFragment to update its content.
            // We will pass it a Bundle generated via the StoresListFragment's getBundle method, for item the user has just clicked on.
            listingDetailFragment.updateListingDetails(StoresListFragment.getBundle(position));
        } else { // Otherwise, we're in the one-pane layout and must swap frags...

            // Create a new Activity Intent that will show a listing's details
            Intent detailIntent = new Intent(this, DetailsActivity.class);
            // Create a new bundle and fill it with data for a selected listing by calling the listing fragment's getBundle()
            Bundle bundle = StoresListFragment.getBundle(position);
            // Pass the selected listing's data to the Activity Intent in form of a bundle
            detailIntent.putExtras(bundle);
            // Start the detail activity
            startActivity(detailIntent);
        }
    }

    public void onRestaurantsFragmentInteraction(int position) {

        // If isDualPane is true, then from our previous check we already know that a detail fragment already exists and we're in two-pane layout.
        if (isDualPane) {

            // Call a method in the ListingDetailFragment to update its content.
            // We will pass it a Bundle generated via the RestaurantsListFragment's getBundle method, for item the user has just clicked on.
            listingDetailFragment.updateListingDetails(RestaurantsListFragment.getBundle(position));
        } else { // Otherwise, we're in the one-pane layout and must swap frags...

            // Create a new Activity Intent that will show a listing's details
            Intent detailIntent = new Intent(this, DetailsActivity.class);
            // Create a new bundle and fill it with data for a selected listing by calling the listing fragment's getBundle()
            Bundle bundle = RestaurantsListFragment.getBundle(position);
            // Pass the selected listing's data to the Activity Intent in form of a bundle
            detailIntent.putExtras(bundle);
            // Start the detail activity
            startActivity(detailIntent);
        }
    }

    public void onAttractionsFragmentInteraction(int position) {

        // If isDualPane is true, then from our previous check we already know that a detail fragment already exists and we're in two-pane layout.
        if (isDualPane) {

            // Call a method in the ListingDetailFragment to update its content.
            // We will pass it a Bundle generated via the AttractionsListFragment's getBundle method, for item the user has just clicked on.
            listingDetailFragment.updateListingDetails(AttractionsListFragment.getBundle(position));
        } else { // Otherwise, we're in the one-pane layout and must swap frags...

            // Create a new Activity Intent that will show a listing's details
            Intent detailIntent = new Intent(this, DetailsActivity.class);
            // Create a new bundle and fill it with data for a selected listing by calling the listing fragment's getBundle()
            Bundle bundle = AttractionsListFragment.getBundle(position);
            // Pass the selected listing's data to the Activity Intent in form of a bundle
            detailIntent.putExtras(bundle);
            // Start the detail activity
            startActivity(detailIntent);
        }
    }
}
