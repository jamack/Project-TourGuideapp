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
 * {@link StoresListFragment.OnStoresFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class StoresListFragment extends Fragment {

    // Declare a global reference to an ArrayList of KidThings so it can be accessed methods outside onCreateView()
    private static ArrayList<KidThing> kidThings = null;

    // Create an instance of listener for interaction with the fragment and its listing of KidThing items
    private OnStoresFragmentInteractionListener mStoresListener;

    public StoresListFragment() {
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
        kidThings.add(new KidThing(getString(R.string.stores_once_upon_a_child_listing_title), R.drawable.store_once_upon_a_child_01_thumbnail, R.drawable.placeholder_3to2,
                getString(R.string.stores_once_upon_a_child_description_full), getString(R.string.stores_once_upon_a_child_address),
                getString(R.string.stores_once_upon_a_child_geocoordinates), getString(R.string.stores_once_upon_a_child_hours_dates),
                getString(R.string.stores_once_upon_a_child_website), 6082039105L));
        kidThings.add(new KidThing(getString(R.string.stores_learning_shop_listing_title), R.drawable.store_learning_shop_01_thumbnail, R.drawable.store_learning_shop_01_3to2,
                getString(R.string.stores_learning_shop_description_full), getString(R.string.stores_learning_shop_address),
                getString(R.string.stores_learning_shop_geocoordinates), getString(R.string.stores_learning_shop_hours_dates),
                getString(R.string.stores_learning_shop_website), 6082778747L));
        kidThings.add(new KidThing(getString(R.string.stores_capitol_kids_listing_title), R.drawable.store_capitol_kids_01_thumbnail, R.drawable.store_capitol_kids_01_thumbnail,
                getString(R.string.stores_capitol_kids_description_full), getString(R.string.stores_capitol_kids_address),
                getString(R.string.stores_capitol_kids_geocoordinates), getString(R.string.stores_capitol_kids_hours_dates),
                getString(R.string.stores_capitol_kids_website), 6082800744L));
        kidThings.add(new KidThing(getString(R.string.stores_playthings_listing_title), R.drawable.store_playthings_01_thumbnail, R.drawable.store_playthings_01_3to2,
                getString(R.string.stores_playthings_description_full), getString(R.string.stores_playthings_address),
                getString(R.string.stores_playthings_geocoordinates), getString(R.string.stores_playthings_hours_dates),
                getString(R.string.stores_playthings_website), 6082332124L));
        kidThings.add(new KidThing(getString(R.string.stores_barnes_noble_listing_title), R.drawable.store_barnes_noble_01_thumbnail, R.drawable.store_barnes_noble_01_3to2,
                getString(R.string.stores_barnes_noble_description_full), getString(R.string.stores_barnes_noble_address),
                getString(R.string.stores_barnes_noble_geocoordinates), getString(R.string.stores_barnes_noble_hours_dates),
                getString(R.string.stores_barnes_noble_website), 6088270809L));
        kidThings.add(new KidThing(getString(R.string.stores_happy_bambino_listing_title), R.drawable.store_happy_bambino_01_thumbnail, R.drawable.store_happy_bambino_01_3to2,
                getString(R.string.stores_happy_bambino_description_full), getString(R.string.stores_happy_bambino_address),
                getString(R.string.stores_happy_bambino_geocoordinates), getString(R.string.stores_happy_bambino_hours_dates),
                getString(R.string.stores_happy_bambino_website), 6082236261L));
        kidThings.add(new KidThing(getString(R.string.stores_toys_r_us_listing_title), R.drawable.store_toys_r_us_01_thumbnail, R.drawable.store_toys_r_us_01_3to2,
                getString(R.string.stores_toys_r_us_description_full), getString(R.string.stores_toys_r_us_address),
                getString(R.string.stores_toys_r_us_geocoordinates), getString(R.string.stores_toys_r_us_hours_dates),
                getString(R.string.stores_toys_r_us_website), 6088290910L));
        kidThings.add(new KidThing(getString(R.string.stores_tj_maxx_listing_title), R.drawable.store_tj_maxx_01_thumbnail, R.drawable.store_tj_maxx_01_3to2,
                getString(R.string.stores_tj_maxx_description_full), getString(R.string.stores_tj_maxx_address),
                getString(R.string.stores_tj_maxx_geocoordinates), getString(R.string.stores_tj_maxx_hours_dates),
                getString(R.string.stores_tj_maxx_website), 6082732153L));
        kidThings.add(new KidThing(getString(R.string.stores_homegoods_listing_title), R.drawable.store_homegoods_01_thumbnail, R.drawable.store_homegoods_01_3to2,
                getString(R.string.stores_homegoods_description_full), getString(R.string.stores_homegoods_address),
                getString(R.string.stores_homegoods_geocoordinates), getString(R.string.stores_homegoods_hours_dates),
                getString(R.string.stores_homegoods_website), 6088360020L));
        kidThings.add(new KidThing(getString(R.string.stores_satara_listing_title), R.drawable.store_satara_01_thumbnail, R.drawable.placeholder_3to2,
                getString(R.string.stores_satara_description_full), getString(R.string.stores_satara_address),
                getString(R.string.stores_satara_geocoordinates), getString(R.string.stores_satara_hours_dates),
                getString(R.string.stores_satara_website), 6082514905L));


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        // Initialize an OnItemLickListener and set it on the ListView so we can detect user interaction with the list.
        // Implement the OnItemClickListener by overriding/completing its onItemClick() method signature
        // to call the StoresListener object's (checking first that it's been initialized) onStoresFragmentInteraction() method.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mStoresListener != null) {
                    mStoresListener.onStoresFragmentInteraction(position);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStoresFragmentInteractionListener) {
            mStoresListener = (OnStoresFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStoresFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mStoresListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) { // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Stores with Children's Items");

            // If in dual pane mode, call method (in MainActivity) to make sure details fragment is updated to show default (first) Stores listing.
            // Pass method an integer corresponding to this category's value in the KidThingFragmentPagerAdapter's getItem() method.
            if (getActivity().findViewById(R.id.listing_container) != null) {
                ((MainActivity) getActivity()).displayDefaultDetails(3);
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
    interface OnStoresFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onStoresFragmentInteraction(int position);
    }

}
