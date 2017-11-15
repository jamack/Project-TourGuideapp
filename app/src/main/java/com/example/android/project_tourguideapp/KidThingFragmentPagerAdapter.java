package com.example.android.project_tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * FragmentPagerAdapter, customized to handle this project's fragments with KidThing listviews.
 */

class KidThingFragmentPagerAdapter extends FragmentPagerAdapter {

    // Create constant value for the number of screens
    private static final int NUMBER_OF_SCREENS = 4;

    // Global variable/field to reference Context passed in by constructor.
    private Context mContext;

    /**
     * Constructor method for {@KidThingFragmentPagerAdapter}
     *
     * @param fm - FragmentManager
     */
    KidThingFragmentPagerAdapter(FragmentManager fm, Context context) {

        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // Construct and return a Fragment
        switch (position) {
            case 0:
                return new ParksListFragment();
            case 1:
                return new AttractionsListFragment();
            case 2:
                return new RestaurantsListFragment();
            case 3:
                return new StoresListFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {

//        // Update TabLayout's tab titles
//        switch (position) {
//            case 0:
//                return mContext.getString(R.string.tablayout_tab_title_parks);
//            case 1:
//                return mContext.getString(R.string.tablayout_tab_title_attractions);
//            case 2:
//                return mContext.getString(R.string.tablayout_tab_title_restaurants);
//            case 3:
//                return mContext.getString(R.string.tablayout_tab_title_stores);
//        }

        // Update TabLayout's tab titles
        switch (position) {
            case 0:
                return "Play";
            case 1:
                return mContext.getString(R.string.tablayout_tab_title_attractions);
            case 2:
                return mContext.getString(R.string.tablayout_tab_title_restaurants);
            case 3:
                return mContext.getString(R.string.tablayout_tab_title_stores);
        }

        return null;
    }

    @Override
    public int getCount() {
        return NUMBER_OF_SCREENS;
    }

}
