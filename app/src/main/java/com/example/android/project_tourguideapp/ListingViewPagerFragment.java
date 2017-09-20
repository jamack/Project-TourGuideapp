package com.example.android.project_tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListingViewPagerFragment extends Fragment {
// TODO: THIS XML LAYOUT FILE IS ONLY NEEDED IF I PUT VIEWPAGER + TABLAYOUT IN A FRAGMENT THAT I CAN SWAP,
// RATHER THAN DIRECTLY IN THE MAINACTIVITY XML FILE...

    public ListingViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listing_view_pager, container, false);
    }

}
