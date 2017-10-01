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

//        // TODO: SETUP MY APPBAR. (FOLLOWING STEPS IN ANDROID DEVELOPERS GUIDE...)
//        // Set the toolbar_list as the app bar for this Activity (via this Fragment)
//        android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar_list);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
//        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
//        actionBar.setTitle("Parks & Playgrounds");
//
//        // TODO: SET MY STATUS BAR COLOR. (IS IT THE BEST PLACE TO PLACE THIS CODE?)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getActivity().getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.BLUE);
//        }


        // Take our global variable and initialize it with a new ArrayList of KidThings
        kidThings = new ArrayList<KidThing>();

        // Populate our ArrayList by constructing and adding new KidThings
        kidThings.add(new KidThing("Nakoma Park", R.drawable.park_nakoma_01_thumbnail, R.drawable.park_nakoma_01_3to2,
                "Medium-sized playground with swingset (including baby swings), play structure (steps, climber, etc), and slide. Drinking fountain. Ball courts/fields. Ice skating.", "3801 Cherokee Dr, Madison, WI 53711",
                "4am - 10pm", "http://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1270"));
        kidThings.add(new KidThing(getString(R.string.park_westmorland_listing_title), R.drawable.westmorland_park_01_thumbnail, R.drawable.westmorland_park_01_3to2,
                getString(R.string.park_westmorland_description), getString(R.string.park_westmorland_address), getString(R.string.park_westmorland_hours_dates), getString(R.string.park_westmorland_website)));
        kidThings.add(new KidThing("Odana Hills East Park", R.drawable.park_odana_hills_east_01_thumbnail, R.drawable.park_odana_hills_east_01_3to2,
                "Mini playground with play structure (climber, etc.), slide, and swings (including baby swings). Drinking fountain. Ball courts.",
                "4627 Odana Rd, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1277"));
        kidThings.add(new KidThing("Glenwood Children's Park", R.drawable.park_glenwood_childrens_01_thumbnail, R.drawable.park_glenwood_childrens_01_3to2,
                "Mini park with play structure (climber, tunnel, etc.), slides, swings, and seesaw. Drinking fountain (a short walk from playground). Ball court.",
                "602 Glenway St, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/history.cfm?id=1213"));
        kidThings.add(new KidThing("Lucia Crest Park", R.drawable.park_lucia_crest_01_thumbnail, R.drawable.park_lucia_crest_01_3to2,
                "Medium-sized playground with play structure (climber, tunnel, etc.), slides, swings (including baby swings), and merry-go-round. Picnic shelter. Drinking fountain. Ball courts.",
                "514 N Owen Dr, Madison, WI 53705", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1236"));
        kidThings.add(new KidThing("Oak Park Heights Park", R.drawable.park_oak_park_heights_01_thumbnail, R.drawable.park_oak_park_heights_01_3to2,
                "Mini park with play structure (climber, etc.), slides, swings, and jungle gym. Picnic shelter. Drinking fountain. Ball court.",
                "641 Hilltop Dr, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1263"));
        kidThings.add(new KidThing("William Slater Park", R.drawable.park_william_slater_01_thumbnail, R.drawable.park_william_slater_01_3to2,
                "Mini park with play structure (climber, etc.), slide, and swings. Ball court.",
                "561 S Segoe Rd, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1342"));
        kidThings.add(new KidThing("Segoe Park", R.drawable.park_segoe_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Mini park with play structure (climber, etc.), slide, and swings. Picnic shelter. Drinking fountain. Ball court.",
                "502 S Segoe Rd, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1327"));
        kidThings.add(new KidThing("Zook Park", R.drawable.park_zook_01_thumbnail, R.drawable.park_zook_01_3to2,
                "Mini park with play structure (climber, tunnel, etc.), slide, and  swings. Picnic table.",
                "950 Pontiac Trail, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1398"));

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
        if (isVisibleToUser) {
            // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Parks & Playgrounds");
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
    public interface OnParksFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onParksFragmentInteraction(int position);
    }
}
