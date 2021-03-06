package com.example.android.project_tourguideapp;

import android.content.Intent;
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
    // Declare global variable to hold reference to the Activity's ToolBar
    android.support.v7.widget.Toolbar myToolbar;
    // Create global variable to later hold reference to a FragmentManager instance
    FragmentManager fragmentManager = null;

    // Global variable to hold reference to a ListingDetailFragment (if present)
    ListingDetailFragment listingDetailFragment = null;

    // Track whether a ListingDetailFragment is being displayed alongside the listing
    private boolean isDualPane;

    /**
     * Updates title displayed in this activity's ActionBar
     *
     * @param title Text to be displayed as the title.
     */
    public static void setActionBarTitle(String title) {
        actionBar.setTitle(title);
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
        KidThingFragmentPagerAdapter adapter = new KidThingFragmentPagerAdapter(fragmentManager, this);
        // Hook the adapter up to the viewpager
        viewPager.setAdapter(adapter);

        // Get the xml layout's TabLayout widget and assign to a variable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        // Set the ViewPager on the TabLayout to connect the pager with the tabs
        tabLayout.setupWithViewPager(viewPager);

        // Reference Toolbar widget for toolbar instance, then get actionbar
        myToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_list);
        setSupportActionBar(myToolbar);
        actionBar = getSupportActionBar();

        // Check whether device's version of Android support the following code.
        // If so, set the status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        // TODO: TRY CODE TO CHECK WHETHER SAVEDINSTANCESTATE CONTAINS THE DETAIL_CONTAINER AND REMOVE IT IF SO...
        // If there is a savedInstanceState bundle (i.e. we've changed orientation or there's been another configuration change) and detail_container is present in the view hierarchy,
        // then retrieve the detail fragment instance via reference in savedInstanceState bundle and remove that fragment so we can start fresh.
        if (savedInstanceState != null && findViewById(R.id.detail_container) == null) {
            listingDetailFragment = (ListingDetailFragment) fragmentManager.getFragment(savedInstanceState, "KEY_DETAIL_FRAGMENT_INSTANCE");
            fragmentManager.beginTransaction().remove(listingDetailFragment).commit();
        }

        // Check for current orientation: if R.id.detail_container is present in view hierarchy,
        // then landscape xml layout is being used. If not present, then we are in portrait orientation.
        FrameLayout detailContainer = (FrameLayout) findViewById(R.id.detail_container);
        if (detailContainer != null) {
            // If the detail_container view exists, we need to update the global variable to reflect two-pane mode
            isDualPane = true;

            // TODO: Do I need to check whether ListingDetailFragment instance exists?
            // Check whether a detail fragment already exists. If not, create a new instance and store reference in a global variable/field
            listingDetailFragment = (ListingDetailFragment) fragmentManager.findFragmentByTag("detail fragment");
            if (listingDetailFragment == null) {
                // Create ListingDetailFragment instance and assign to global variable
                listingDetailFragment = new ListingDetailFragment();
            }

            // Get data for the first list item from the fragment with that arraylist, in the form of a bundle,
            // and pass that bundle to the detail fragment.
            listingDetailFragment.setArguments(ParksListFragment.getBundle(0));

            // Add fragment to the container
            fragmentManager.beginTransaction().add(R.id.detail_container, listingDetailFragment, "detail fragment").commit();

        } else {
            // If the detail container view does NOT exist, we need to update the global variable to reflect one-pane mode
            isDualPane = false;

            // Nullify any previously created and now unused references to a detail fragment
            listingDetailFragment = null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("KEY_TOOLBAR_ID", R.id.toolbar_list);
        if (isDualPane == true) {
            //Save the fragment's instance
            fragmentManager.putFragment(outState, "KEY_DETAIL_FRAGMENT_INSTANCE", listingDetailFragment);
        }
    }

    /**
     * Implemented method for OnParksFragmentInteractionListener interface.
     * Calls getter method in ParksListFragment to get a Bundle with details for the selected listing.
     * Calls showListingDetails method and passes the above Bundle.
     *
     * @param position Integer. Indicates item (in the parks ListView) selected by the user.
     */
    public void onParksFragmentInteraction(int position) {

        // Call the showListingDetails method to display/update the ListingDetailFragment, whether it's shown as dual pane in MainActivity or as single pane in Details Activity.
        // We will pass it a Bundle generated via the ParksListFragment's getBundle method, for item the user has just clicked on.
        showListingDetails(ParksListFragment.getBundle(position));

    }

    /**
     * Implemented method for OnAttractionsFragmentInteractionListener interface.
     * Calls getter method in AttractionsListFragment to get a Bundle with details for the selected listing.
     * Calls showListingDetails method and passes the above Bundle.
     *
     * @param position Integer. Indicates item (in the parks ListView) selected by the user.
     */
    public void onAttractionsFragmentInteraction(int position) {

        // Call the showListingDetails method to display/update the ListingDetailFragment, whether it's shown as dual pane in MainActivity or as single pane in Details Activity.
        // We will pass it a Bundle generated via the AttractionsListFragment's getBundle method, for item the user has just clicked on.
        showListingDetails(AttractionsListFragment.getBundle(position));

    }

    /**
     * Implemented method for OnStoresFragmentInteractionListener interface.
     * Calls getter method in StoresListFragment to get a Bundle with details for the selected listing.
     * Calls showListingDetails method and passes the above Bundle.
     *
     * @param position Integer. Indicates item (in the parks ListView) selected by the user.
     */
    public void onStoresFragmentInteraction(int position) {

        // Call the showListingDetails method to display/update the ListingDetailFragment, whether it's shown as dual pane in MainActivity or as single pane in Details Activity.
        // We will pass it a Bundle generated via the StoresListFragment's getBundle method, for item the user has just clicked on.
        showListingDetails(StoresListFragment.getBundle(position));

    }

    /**
     * Implemented method for OnRestaurantsFragmentInteractionListener interface.
     * Calls getter method in RestaurantsListFragment to get a Bundle with details for the selected listing.
     * Calls showListingDetails method and passes the above Bundle.
     *
     * @param position Integer. Indicates item (in the parks ListView) selected by the user.
     */
    public void onRestaurantsFragmentInteraction(int position) {

        // Call the showListingDetails method to display/update the ListingDetailFragment, whether it's shown as dual pane in MainActivity or as single pane in Details Activity.
        // We will pass it a Bundle generated via the RestaurantsListFragment's getBundle method, for item the user has just clicked on.
        showListingDetails(RestaurantsListFragment.getBundle(position));

    }

    /**
     * This method is used in conjunction with the FragmentPagerAdapter to display details for a default listing as the user swipes
     * between categories IF IN DUAL PANE MODE. This method is called from each category's fragment.
     * This method gets a Bundle for the first entry in a category and passes it to the showListingDetails method.
     *
     * @param position Integer. Corresponds to each category's value in the KidThingFragmentPagerAdapter's getItem() method.
     */
    public void displayDefaultDetails(int position) {

        // If app is in dual pane mode, update the listing shown by default in the details fragment to be the first item in the new category.
        switch (position) {
            case 0:
                showListingDetails(ParksListFragment.getBundle(0));
                break;
            case 1:
                showListingDetails(AttractionsListFragment.getBundle(0));
                break;
            case 2:
                showListingDetails(RestaurantsListFragment.getBundle(0));
                break;
            case 3:
                showListingDetails(StoresListFragment.getBundle(0));
                break;
            default:
                showListingDetails(ParksListFragment.getBundle(0));
        }
    }

    /**
     * This method handles displaying details for a listing - whether user has selected an item
     * or a default listing is being displayed as the user swipes through the FragmentPagerAdapter.
     * This method determines whether to display details in a new DetailsActivity (single pane mode) or within second pane (dual pane mode).
     *
     * @param bundle Bundle containing data for a KidThing listing.
     */
    private void showListingDetails(Bundle bundle) {
        // Bundle being passed into method contains data for a specific listing - in whichever category is currently shown in the ViewPager
        // - that the user has just clicked on.

        // If isDualPane is true, then from our previous check we already know that a detail fragment already exists and we're in two-pane layout.
        if (isDualPane) {
            // Call a method in the ListingDetailFragment and pass it a Bundle to update its content.
            listingDetailFragment.updateListingDetails(bundle);
        } else { // Otherwise, we're in the one-pane layout and must swap frags...

            // Create a new Activity Intent that will show a listing's details
            Intent detailIntent = new Intent(this, DetailsActivity.class);
            // Pass the selected listing's data to the Activity Intent in form of a bundle
            detailIntent.putExtras(bundle);
            // Start the detail activity. (This is a new activity intent, so no need to check whether it can be resolved).
            startActivity(detailIntent);
        }
    }

}
