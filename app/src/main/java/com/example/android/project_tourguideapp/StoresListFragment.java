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
        kidThings.add(new KidThing("Once Upon A Child", R.drawable.store_once_upon_a_child_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Chain operation that buys & sells gently used items for children, including clothes, shoes & toys.",
                "7475 Mineral Point Rd, Madison, WI 53717", "Sun 10:00am - 5:00pm, M-Sat 10:00am - 7:00pm", "http://www.onceuponachildmadisonwest.com", 6082039105L));
        kidThings.add(new KidThing("Learning Shop", R.drawable.store_satara_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Toy store.",
                "714 S Gammon Rd, Madison, WI 53719", "Sun 11:00am - 5:00pm, M-F 9:00am - 7:00pm, Sat 10:00am - 5:00 pm", "http://www.learningshop.com", 6082778747L));
        kidThings.add(new KidThing("Happy Bambino", R.drawable.store_happy_bambino_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Local shop offering eco-friendly baby products, maternity needs & classes for parents & infants.",
                "4116 Monona Dr, Madison, WI 53716", "Sat,Sun 11:00am – 4:00pm, M-W 9:00am – 6:00pm, Thur,F 9:00am - 5:00pm", "https://www.happybambino.com", 6082236261L));
        kidThings.add(new KidThing("Satara Home and Baby", R.drawable.store_satara_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Simple shop for mattresses, bedding & towels made from organic materials, plus baby cribs & toys.",
                "6333 University Ave, Middleton, WI 53562", "M-F 10:00am - 6:00pm, Sat 10:00am - 5:00pm", "https://www.satarahome.com", 6082514905L));
        kidThings.add(new KidThing("Toys R Us", R.drawable.store_satara_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Chain retailer providing an assortment of brand-name children's toys, games, electronics & gear.",
                "7309 W Towne Way, Madison, WI 53719", "Sun-M 10:00am - 8:00pm, Tues 10:00am - 9:00pm, W-Thur 10:00am - 9:30pm, F 10:00am - 10:00pm, Sat 9:00am - 10:00pm", "https://www.toysrus.com", 6088290910L));


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
        if (isVisibleToUser) {
            // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Stores with Children's Items");
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
    public interface OnStoresFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onStoresFragmentInteraction(int position);
    }

}
