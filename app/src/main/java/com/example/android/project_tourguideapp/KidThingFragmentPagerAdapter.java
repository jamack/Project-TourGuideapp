package com.example.android.project_tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * FragmentPagerAdapter, customized to handle this project's fragments with KidThing listviews.
 */

class KidThingFragmentPagerAdapter extends FragmentPagerAdapter {

    // Create constant value for the number of screens
    private static final int NUMBER_OF_SCREENS = 4;

    /**
     * Constructor method for {@KidThingFragmentPagerAdapter}
     *
     * @param fm - FragmentManager
     */
    KidThingFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
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

        // Update TabLayout's tab titles
        switch (position) {
            case 0:
                return "Play";
            case 1:
                return "Do";
            case 2:
                return "Eat";
            case 3:
                return "Shop";
        }

        return null;
    }

    @Override
    public int getCount() {
        return NUMBER_OF_SCREENS;
    }

}
