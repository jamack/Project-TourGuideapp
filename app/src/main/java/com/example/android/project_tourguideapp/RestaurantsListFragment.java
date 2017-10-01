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
        kidThings = new ArrayList<KidThing>();

        // Populate our ArrayList by constructing and adding new KidThings
        kidThings.add(new KidThing("Chocolate Shoppe Ice Cream Co.", R.drawable.restaurant_chocolateshoppe_midvale_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Old-fashioned, family-owned store serving up more than 100 flavors of ice cream since 1962. Small play area with toys, child tables/chairs, toy food carts, kitchen set, etc. Jelly beans. Restrooms. Drinking fountain. Indoor & outdoor seating.",
                "555 S Midvale Blvd, Madison, WI 53711", "11:00am – 10:00pm", "http://www.chocolateshoppeicecream.com", 6084415248L));
        kidThings.add(new KidThing("Ella's Deli & Ice Cream Parlor", R.drawable.restaurant_ellas_deli_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Kid-oriented eatery with colorful, animated decor & a carousel offering American food & desserts. ",
                "2902 E Washington Ave, Madison, WI 53704 ", "Sun-Th 11:00am – 10:00pm, F-Sat 11:00am – 11:00pm", "http://www.ellasdeli.com", 6082415291L));
        kidThings.add(new KidThing("Yola's Cafe and Coffee Shop", R.drawable.restaurant_yolas_cafe_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Mellow coffeehouse offering java, pastries & savory dishes plus WiFi, a fireplace & a big patio. Kid's play area. Diaper changing station(s). High chairs. Kids menu.",
                "494 Commerce Dr, Madison, WI 53719", "Tues-Sat 7:00am – 4:30pm", "http://www.yolascafe.com", 6088275800L));


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
        if (isVisibleToUser) {
            // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Child-Friendly Restaurants");
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
    public interface OnRestaurantsFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onRestaurantsFragmentInteraction(int position);
    }

}
