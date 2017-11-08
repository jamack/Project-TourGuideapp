package com.example.android.project_tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParksListFragment.OnParksFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ParksListFragment extends Fragment {

    // Declare a global reference to an ArrayList of KidThings so it can be accessed methods outside onCreateView()
    private static ArrayList<KidThing> kidThings = null;

    // Create an instance of listener for interaction with the fragment and its listing of KidThing items
    private OnParksFragmentInteractionListener mParksListener;

    public ParksListFragment() {
        // Required empty public constructor
    }

    /**
     * Takes a position on a listview (either selected position or default first item)
     * and puts all the data for the corresponding KidThing ArrayList entry into a bundle.
     *
     * @param position Will determine which ArrayList item to process.
     * @return Return the newly created Bundle.
     */
    public static Bundle getBundle(int position) {
        // Create a a fresh Bundle
        Bundle bundle = new Bundle();

        // Get the desired KidThing from ListArray, call its getter method for each member field,
        // and add that value - along with a key (constant value defined in the ListingDetailFragment class) -
        // to the newly create bundle.
        bundle.putString(ListingDetailFragment.ARG_LISTING_NAME, kidThings.get(position).getListingName());
        bundle.putInt(ListingDetailFragment.ARG_IMAGE_RESOURCE_BANNER, kidThings.get(position).getBannerImageResourceId());
        bundle.putString(ListingDetailFragment.ARG_FULL_DESCRIPTION, kidThings.get(position).getDescription());
        bundle.putString(ListingDetailFragment.ARG_ADDRESS, kidThings.get(position).getAddress());
        bundle.putString(ListingDetailFragment.ARG_GEOCOORDINATES, kidThings.get(position).getGeocoordinates());
        bundle.putString(ListingDetailFragment.ARG_HOURS_DATES, kidThings.get(position).getHoursDates());
        bundle.putString(ListingDetailFragment.ARG_WEBSITE, kidThings.get(position).getWebsite());
        bundle.putLong(ListingDetailFragment.ARG_PHONE_NUMBER, kidThings.get(position).getPhoneNumber());

        return bundle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate our list_view ListView and assign the instance to a variable
        View rootView = inflater.inflate(R.layout.kidthing_list, container, false);

        // Take our global variable and initialize it with a new ArrayList of KidThings
        kidThings = new ArrayList<>();

        // Populate our ArrayList by constructing and adding new KidThings
        kidThings.add(new KidThing(getString(R.string.park_nakoma_listing_title), R.drawable.park_nakoma_01_thumbnail, R.drawable.park_nakoma_01_3to2,
                getString(R.string.park_nakoma_description_full), getString(R.string.park_nakoma_address),
                getString(R.string.park_nakoma_geocoordinates), getString(R.string.park_nakoma_hours_dates), getString(R.string.park_nakoma_website)));
        kidThings.add(new KidThing(getString(R.string.park_westmorland_listing_title), R.drawable.park_westmorland_01_thumbnail, R.drawable.park_westmorland_01_3to2,
                getString(R.string.park_westmorland_description_full), getString(R.string.park_westmorland_address),
                getString(R.string.park_westmorland_geocoordinates), getString(R.string.park_westmorland_hours_dates), getString(R.string.park_westmorland_website)));
        kidThings.add(new KidThing(getString(R.string.park_odana_hills_east_listing_title), R.drawable.park_odana_hills_east_01_thumbnail, R.drawable.park_odana_hills_east_01_3to2,
                getString(R.string.park_odana_hills_east_description_full), getString(R.string.park_odana_hills_east_address),
                getString(R.string.park_odana_hills_east_geocoordinates), getString(R.string.park_odana_hills_east_hours_dates), getString(R.string.park_odana_hills_east_website)));
        kidThings.add(new KidThing(getString(R.string.park_glenwood_childrens_listing_title), R.drawable.park_glenwood_childrens_01_thumbnail, R.drawable.park_glenwood_childrens_01_3to2,
                getString(R.string.park_glenwood_childrens_description_full), getString(R.string.park_glenwood_childrens_address),
                getString(R.string.park_glenwood_childrens_geocoordinates), getString(R.string.park_glenwood_childrens_hours_dates), getString(R.string.park_glenwood_childrens_website)));
        kidThings.add(new KidThing(getString(R.string.park_lucia_crest_listing_title), R.drawable.park_lucia_crest_01_thumbnail, R.drawable.park_lucia_crest_01_3to2,
                getString(R.string.park_lucia_crest_description_full), getString(R.string.park_lucia_crest_address),
                getString(R.string.park_lucia_crest_geocoordinates), getString(R.string.park_lucia_crest_hours_dates), getString(R.string.park_lucia_crest_website)));
        kidThings.add(new KidThing(getString(R.string.park_oak_park_heights_listing_title), R.drawable.park_oak_park_heights_01_thumbnail, R.drawable.park_oak_park_heights_01_3to2,
                getString(R.string.park_oak_park_heights_description_full), getString(R.string.park_oak_park_heights_address),
                getString(R.string.park_oak_park_heights_geocoordinates), getString(R.string.park_oak_park_heights_hours_dates), getString(R.string.park_oak_park_heights_website)));
        kidThings.add(new KidThing(getString(R.string.park_william_slater_listing_title), R.drawable.park_william_slater_01_thumbnail, R.drawable.park_william_slater_01_3to2,
                getString(R.string.park_william_slater_description_full), getString(R.string.park_william_slater_address),
                getString(R.string.park_william_slater_geocoordinates), getString(R.string.park_william_slater_hours_dates), getString(R.string.park_william_slater_website)));
        kidThings.add(new KidThing(getString(R.string.park_segoe_listing_title), R.drawable.park_segoe_01_thumbnail, R.drawable.park_segoe_01_3to2,
                getString(R.string.park_segoe_description_full), getString(R.string.park_segoe_address),
                getString(R.string.park_segoe_geocoordinates), getString(R.string.park_segoe_hours_dates), getString(R.string.park_segoe_website)));
        kidThings.add(new KidThing(getString(R.string.park_zook_listing_title), R.drawable.park_zook_01_thumbnail, R.drawable.park_zook_01_3to2,
                getString(R.string.park_zook_description_full), getString(R.string.park_zook_address),
                getString(R.string.park_zook_geocoordinates), getString(R.string.park_zook_hours_dates), getString(R.string.park_zook_website)));
        kidThings.add(new KidThing(getString(R.string.park_spring_harbor_listing_title), R.drawable.park_spring_harbor_01_thumbnail, R.drawable.park_spring_harbor_01_3to2,
                getString(R.string.park_spring_harbor_description_full), getString(R.string.park_spring_harbor_address),
                getString(R.string.park_spring_harbor_geocoordinates), getString(R.string.park_spring_harbor_hours_dates), getString(R.string.park_spring_harbor_website)));

        // Find instance of the list_view ListView and assign to a variable
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter and assign to a variable
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Hook the newly instantiated KidThingAdapter up to the ListView
        listView.setAdapter(kidThingAdapter);

        // Initialize an OnItemLickListener and set it on the ListView so we can detect user interaction with the list.
        // Implement the OnItemClickListener by overriding/completing its onItemClick() method signature
        // to call the ParksListener object's (checking first that it's been initialized) onParksFragmentInteraction() method.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mParksListener != null) {
                    mParksListener.onParksFragmentInteraction(position);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnParksFragmentInteractionListener) {
            mParksListener = (OnParksFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnParksFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mParksListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) { // Your fragment is visible
            // Call setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Parks & Playgrounds");

            // TODO: FIGURE OUT WHY THIS CODE CRASHES THE APP, BUT IS FINE IN ALL THE OTHER CATEGORY FRAGMENTS...
            // If in dual pane mode, call method (in MainActivity) to make sure details fragment is updated to show default (first) Parks listing.
            // Pass method an integer corresponding to this category's value in the KidThingFragmentPagerAdapter's getItem() method.
//            if(getActivity().findViewById(R.id.listing_container) != null) {
//                ((MainActivity) getActivity()).displayDefaultDetails(0);
//            }
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    interface OnParksFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onParksFragmentInteraction(int position);
    }
}
