package com.example.android.project_tourguideapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by James on 8/31/2017.
 */

public class KidThingFragmentPagerAdapter extends FragmentPagerAdapter {

    // TODO: UPDATE FOR FINAL # OF SCREENS
    // Create constant value for the number of screens
    private static final int NUMBER_OF_SCREENS = 2;

    /**
     * Constructor method for {@KidThingFragmentPagerAdapter}
     *
     * @param fm - FragmentManager
     */
    public KidThingFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // TODO: UPDATE once all category Fragments are included below
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ParksListFragment();
            case 1:
                return new RestaurantsListFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Playgrounds";
            case 1:
                return "Food";
        }

        return null;
    }

    @Override
    public int getCount() {
        return NUMBER_OF_SCREENS;
    }
}
