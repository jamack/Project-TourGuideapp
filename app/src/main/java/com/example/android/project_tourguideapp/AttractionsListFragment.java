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
 * {@link AttractionsListFragment.OnAttractionsFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AttractionsListFragment extends Fragment {

    // Declare a global reference to an ArrayList of KidThings so it can be accessed methods outside onCreateView()
    private static ArrayList<KidThing> kidThings = null;

    // Create an instance of listener for interaction with the fragment and its listing of KidThing items
    private OnAttractionsFragmentInteractionListener mAttractionsListener;

    public AttractionsListFragment() {
        // Required empty public constructor
    }

    // TODO: THIS CODE IS REPEATED IN ALL MY LIST FRAGMENTS. SHOULD I CREATE A MASTER CLASS AND INHERIT FROM THAT?

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
        kidThings.add(new KidThing(getString(R.string.attractions_madison_childrens_museum_listing_title), R.drawable.attractions_childrens_museum_01_thumbnail, R.drawable.attractions_childrens_museum_01_3to2,
                getString(R.string.attractions_madison_childrens_museum_description_full), getString(R.string.attractions_madison_childrens_museum_address),
                getString(R.string.attractions_madison_childrens_museum_geocoordinates), getString(R.string.attractions_madison_childrens_museum_hours_dates),
                getString(R.string.attractions_madison_childrens_museum_website), 6082566445L));
        kidThings.add(new KidThing(getString(R.string.attractions_henry_vilas_zoo_listing_title), R.drawable.attractions_vilas_zoo_01_thumbnail, R.drawable.attractions_vilas_zoo_01_3to2,
                getString(R.string.attractions_henry_vilas_zoo_description_full), getString(R.string.attractions_henry_vilas_zoo_address),
                getString(R.string.attractions_henry_vilas_zoo_geocoordinates), getString(R.string.attractions_henry_vilas_zoo_hours_dates),
                getString(R.string.attractions_henry_vilas_zoo_website), 6082589490L));
        kidThings.add(new KidThing(getString(R.string.attractions_playn_wisconsin_listing_title), R.drawable.attractions_playn_wisconsin_01_thumbnail, R.drawable.attractions_playn_wisconsin_01_3to2,
                getString(R.string.attractions_playn_wisconsin_description_full), getString(R.string.attractions_playn_wisconsin_address),
                getString(R.string.attractions_playn_wisconsin_geocoordinates), getString(R.string.attractions_playn_wisconsin_hours_dates),
                getString(R.string.attractions_playn_wisconsin_website), 6082345600L));
        kidThings.add(new KidThing(getString(R.string.attractions_rockin_jump_listing_title), R.drawable.attractions_rockin_jump_01_thumbnail, R.drawable.attractions_rockin_jump_01_3to2,
                getString(R.string.attractions_rockin_jump_description_full),
                getString(R.string.attractions_rockin_jump_address), getString(R.string.attractions_rockin_jump_geocoordinates), getString(R.string.attractions_rockin_jump_hours_dates),
                getString(R.string.attractions_rockin_jump_website), 6088195368L));
        kidThings.add(new KidThing(getString(R.string.attractions_sky_zone_listing_title), R.drawable.attractions_sky_zone_01_thumbnail, R.drawable.attractions_sky_zone_01_3to2,
                getString(R.string.attractions_sky_zone_description_full), getString(R.string.attractions_sky_zone_address),
                getString(R.string.attractions_sky_zone_geocoordinates), getString(R.string.attractions_sky_zone_hours_dates),
                getString(R.string.attractions_sky_zone_website), 6087193379L));
        kidThings.add(new KidThing(getString(R.string.attractions_pump_it_up_listing_title), R.drawable.attractions_pump_it_up_01_thumbnail, R.drawable.attractions_pump_it_up_01_3to2,
                getString(R.string.attractions_pump_it_up_description_full), getString(R.string.attractions_pump_it_up_address),
                getString(R.string.attractions_pump_it_up_geocoordinates), getString(R.string.attractions_pump_it_up_hours_dates),
                getString(R.string.attractions_pump_it_up_website), 6084426386L));
        kidThings.add(new KidThing(getString(R.string.attractions_olbrich_gardens_listing_title), R.drawable.attractions_olbrich_gardens_01_thumbnail, R.drawable.attractions_olbrich_gardens_01_3to2,
                getString(R.string.attractions_olbrich_gardens_description_full), getString(R.string.attractions_olbrich_gardens_address),
                getString(R.string.attractions_olbrich_gardens_geocoordinates), getString(R.string.attractions_olbrich_gardens_hours_dates),
                getString(R.string.attractions_olbrich_gardens_website), 6082464550L));
        kidThings.add(new KidThing(getString(R.string.attractions_vitense_golfland_listing_title), R.drawable.attractions_vitense_golfland_01_thumbnail, R.drawable.attractions_vitense_golfland_01_3to2,
                getString(R.string.attractions_vitense_golfland_description_full), getString(R.string.attractions_vitense_golfland_address),
                getString(R.string.attractions_vitense_golfland_geocoordinates), getString(R.string.attractions_vitense_golfland_hours_dates),
                getString(R.string.attractions_vitense_golfland_website), 6082711411L));
        kidThings.add(new KidThing(getString(R.string.attractions_arboretum_listing_title), R.drawable.attractions_the_arboretum_01_thumbnail, R.drawable.attractions_the_arboretum_01_3to2,
                getString(R.string.attractions_arboretum_description_full), getString(R.string.attractions_arboretum_address),
                getString(R.string.attractions_arboretum_geocoordinates), getString(R.string.attractions_arboretum_hours_dates),
                getString(R.string.attractions_arboretum_website), 6082637888L));
        kidThings.add(new KidThing(getString(R.string.attractions_spring_harbor_beach_listing_title), R.drawable.attractions_spring_harbor_beach_01_thumbnail, R.drawable.attractions_spring_harbor_beach_01_3to2,
                getString(R.string.attractions_spring_harbor_beach_description_full), getString(R.string.attractions_spring_harbor_beach_address),
                getString(R.string.attractions_spring_harbor_beach_geocoordinates), getString(R.string.attractions_spring_harbor_beach_hours_dates),
                getString(R.string.attractions_spring_harbor_beach_website), 6082664711L));

        // Find instance of the list_view ListView and assign to a variable
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter and assign to a variable
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Hook the newly instantiated KidThingAdapter up to the ListView
        listView.setAdapter(kidThingAdapter);

        // Initialize an OnItemLickListener and set it on the ListView so we can detect user interaction with the list.
        // Implement the OnItemClickListener by overriding/completing its onItemClick() method signature
        // to call the AttractionsListener object's (checking first that it's been initialized) onAttractionsFragmentInteraction() method.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mAttractionsListener != null) {
                    mAttractionsListener.onAttractionsFragmentInteraction(position);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAttractionsFragmentInteractionListener) {
            mAttractionsListener = (OnAttractionsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAttractionsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAttractionsListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) { // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Activities");

            // If in dual pane mode, call method (in MainActivity) to make sure details fragment is updated to show default (first) Attractions listing.
            // Pass method an integer corresponding to this category's value in the KidThingFragmentPagerAdapter's getItem() method.
            if (getActivity().findViewById(R.id.listing_container) != null) {
                ((MainActivity) getActivity()).displayDefaultDetails(1);
            }
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
    interface OnAttractionsFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onAttractionsFragmentInteraction(int position);
    }

}
