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
 * {@link RestaurantsListFragment.OnRestaurantsFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RestaurantsListFragment extends Fragment {

    // Declare a global reference to an ArrayList of KidThings so it can be accessed methods outside onCreateView()
    private static ArrayList<KidThing> kidThings = null;

    // Create an instance of listener for interaction with the fragment and its listing of KidThing items
    private OnRestaurantsFragmentInteractionListener mRestaurantsListener;

    public RestaurantsListFragment() {
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
        kidThings.add(new KidThing(getString(R.string.restaurants_chocolate_shoppe_midvale_listing_title), R.drawable.restaurant_chocolateshoppe_midvale_01_thumbnail, R.drawable.restaurant_chocolateshoppe_midvale_01_3to2,
                getString(R.string.restaurants_chocolate_shoppe_midvale_description_full), getString(R.string.restaurants_chocolate_shoppe_midvale_address),
                getString(R.string.restaurants_chocolate_shoppe_midvale_geocoordinates), getString(R.string.restaurants_chocolate_shoppe_midvale_hours_dates),
                getString(R.string.restaurants_chocolate_shoppe_midvale_website), 6084415248L));
        kidThings.add(new KidThing(getString(R.string.restaurants_ellas_deli_listing_title), R.drawable.restaurant_ellas_deli_01_thumbnail, R.drawable.restaurant_ellas_deli_01_3to2,
                getString(R.string.restaurants_ellas_deli_description_full), getString(R.string.restaurants_ellas_deli_address),
                getString(R.string.restaurants_ellas_deli_geocoordinates), getString(R.string.restaurants_ellas_deli_hours_dates),
                getString(R.string.restaurants_ellas_deli_website), 6082415291L));
        kidThings.add(new KidThing(getString(R.string.restaurants_yolas_cafe_listing_title), R.drawable.restaurant_yolas_cafe_01_thumbnail, R.drawable.restaurant_yolas_cafe_01_3to2,
                getString(R.string.restaurants_yolas_cafe_description_full), getString(R.string.restaurants_yolas_cafe_address),
                getString(R.string.restaurants_yolas_cafe_geocoordinates), getString(R.string.restaurants_yolas_cafe_hours_dates),
                getString(R.string.restaurants_yolas_cafe_website), 6088275800L));
        kidThings.add(new KidThing(getString(R.string.restaurants_montys_blue_plate_listing_title), R.drawable.restaurant_montys_blue_plate_01_thumbnail, R.drawable.restaurant_montys_blue_plate_01_3to2,
                getString(R.string.restaurants_montys_blue_plate_description_full), getString(R.string.restaurants_montys_blue_plate_address),
                getString(R.string.restaurants_montys_blue_plate_geocoordinates), getString(R.string.restaurants_montys_blue_plate_hours_dates),
                getString(R.string.restaurants_montys_blue_plate_website), 6082448505L));
        kidThings.add(new KidThing(getString(R.string.restaurants_ians_pizza_state_listing_title), R.drawable.restaurant_ians_pizza_state_01_thumbnail, R.drawable.restaurant_ians_pizza_state_01_3to2,
                getString(R.string.restaurants_ians_pizza_state_description_full), getString(R.string.restaurants_ians_pizza_state_address),
                getString(R.string.restaurants_ians_pizza_state_geocoordinates), getString(R.string.restaurants_ians_pizza_state_hours_dates),
                getString(R.string.restaurants_ians_pizza_state_website), 6082579248L));
        kidThings.add(new KidThing(getString(R.string.restaurants_zuzu_cafe_listing_title), R.drawable.restaurant_zuzu_cafe_01_thumbnail, R.drawable.restaurant_zuzu_cafe_01_3to2,
                getString(R.string.restaurants_zuzu_cafe_description_full), getString(R.string.restaurants_zuzu_cafe_address),
                getString(R.string.restaurants_zuzu_cafe_geocoordinates), getString(R.string.restaurants_zuzu_cafe_hours_dates),
                getString(R.string.restaurants_zuzu_cafe_website), 6082609898L));
        kidThings.add(new KidThing(getString(R.string.restaurants_michaels_custard_monroe_listing_title), R.drawable.restaurant_michaels_custard_monroe_01_thumbnail, R.drawable.restaurant_michaels_custard_monroe_01_3to2,
                getString(R.string.restaurants_michaels_custard_monroe_description_full), getString(R.string.restaurants_michaels_custard_monroe_address),
                getString(R.string.restaurants_michaels_custard_monroe_geocoordinates), getString(R.string.restaurants_michaels_custard_monroe_hours_dates),
                getString(R.string.restaurants_michaels_custard_monroe_website), 6082313500L));
        kidThings.add(new KidThing(getString(R.string.restaurants_michaels_custard_schroeder_listing_title), R.drawable.restaurant_michaels_custard_schroeder_01_thumbnail, R.drawable.restaurant_michaels_custard_schroeder_01_3to2,
                getString(R.string.restaurants_michaels_custard_schroeder_description_full), getString(R.string.restaurants_michaels_custard_schroeder_address),
                getString(R.string.restaurants_michaels_custard_schroeder_geocoordinates), getString(R.string.restaurants_michaels_custard_schroeder_hours_dates),
                getString(R.string.restaurants_michaels_custard_schroeder_website), 6082768100L));
        kidThings.add(new KidThing(getString(R.string.restaurants_monona_bait_ice_cream_listing_title), R.drawable.restaurant_bait_ice_cream_01_thumbnail, R.drawable.restaurant_bait_ice_cream_01_3to2,
                getString(R.string.restaurants_monona_bait_ice_cream_description_full), getString(R.string.restaurants_monona_bait_ice_cream_address),
                getString(R.string.restaurants_monona_bait_ice_cream_geocoordinates), getString(R.string.restaurants_monona_bait_ice_cream_hours_dates),
                getString(R.string.restaurants_monona_bait_ice_cream_website), 6082221944L));
        kidThings.add(new KidThing(getString(R.string.restaurants_chuck_e_cheese_listing_title), R.drawable.restaurants_chuck_e_cheese_01_thumbnail, R.drawable.restaurants_chuck_e_cheese_01_3to2,
                getString(R.string.restaurants_chuck_e_cheese_description_full), getString(R.string.restaurants_chuck_e_cheese_address),
                getString(R.string.restaurants_chuck_e_cheese_geocoordinates), getString(R.string.restaurants_chuck_e_cheese_hours_dates),
                getString(R.string.restaurants_chuck_e_cheese_website), 6088292000L));


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        // Initialize an OnItemLickListener and set it on the ListView so we can detect user interaction with the list.
        // Implement the OnItemClickListener by overriding/completing its onItemClick() method signature
        // to call the RestaurantsListener object's (checking first that it's been initialized) onRestaurantsFragmentInteraction() method.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mRestaurantsListener != null) {
                    mRestaurantsListener.onRestaurantsFragmentInteraction(position);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRestaurantsFragmentInteractionListener) {
            mRestaurantsListener = (OnRestaurantsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRestaurantsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mRestaurantsListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) { // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle(getString(R.string.restaurants_actionbar_title_text));

            // If in dual pane mode, call method (in MainActivity) to make sure details fragment is updated to show default (first) Restaurants listing.
            // Pass method an integer corresponding to this category's value in the KidThingFragmentPagerAdapter's getItem() method.
            if (getActivity().findViewById(R.id.listing_container) != null) {
                ((MainActivity) getActivity()).displayDefaultDetails(2);
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
    interface OnRestaurantsFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onRestaurantsFragmentInteraction(int position);
    }

}
