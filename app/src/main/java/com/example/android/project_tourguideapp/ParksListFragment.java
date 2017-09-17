package com.example.android.project_tourguideapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

    // TODO: IN PROCESS OF TWEAKING A GLOBAL REFERENCE TO ARRAYLIST SO IT CAN BE ACCESSED BY MAINACTIVITY'S CREATE BUNDLE METHOD...
    private static ArrayList parksArrayList = null;
    //    final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
    private static ArrayList<KidThing> kidThings = null;

    private OnParksFragmentInteractionListener mParksListener;

    public ParksListFragment() {
        // Required empty public constructor
    }

    // TODO: TESTING METHODS TO DELIVER INFO TO MAINACTIVITY FOR UPDATING DETAIL FRAGMENT...
    public static ArrayList getArrayList() {
        return kidThings;
    } // This method works, but I can't access info once back in MainActivity...

//    // TODO: Can i just delete this now? [Rename method, update argument and hook method into UI event]
//    public void onButtonPressed(Uri uri) {
//        if (mParksListener != null) {
//            mParksListener.onParksFragmentInteraction(uri);
//        }
//    }

    public static Bundle getBundle(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(ListingDetailFragment.ARG_LISTING_NAME, kidThings.get(position).getListingName());
        bundle.putInt(ListingDetailFragment.ARG_IMAGE_RESOURCE, kidThings.get(position).getImageResourceId());
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


        //final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
        kidThings = new ArrayList<KidThing>();
        kidThings.add(new KidThing("Nakoma Park", R.drawable.park_nakoma_01_thumbnail,
                "Medium-sized playground with swingset (including baby swings), play structure (steps, climber, etc), and slide. Drinking fountain. Ball courts/fields. Ice skating.", "3801 Cherokee Dr, Madison, WI 53711",
                "4am - 10pm", "http://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1270"));
        kidThings.add(new KidThing(getString(R.string.park_westmorland_listing_title), R.drawable.westmorland_park_01_thumbnail, getString(R.string.park_westmorland_description), getString(R.string.park_westmorland_address), getString(R.string.park_westmorland_hours_dates), getString(R.string.park_westmorland_website)));
        kidThings.add(new KidThing("Odana Hills East Park", R.drawable.park_odana_hills_east_01_thumbnail,
                "Mini playground with play structure (climber, etc.), slide, and swings (including baby swings). Drinking fountain. Ball courts.",
                "4627 Odana Rd, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1277"));
        kidThings.add(new KidThing("Glenwood Children's Park", R.drawable.park_glenwood_childrens_01_thumbnail,
                "Mini park with play structure (climber, tunnel, etc.), slides, swings, and seesaw. Drinking fountain (a short walk from playground). Ball court.",
                "602 Glenway St, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/history.cfm?id=1213"));
        kidThings.add(new KidThing("Lucia Crest Park", R.drawable.park_lucia_crest_01_thumbnail,
                "Medium-sized playground with play structure (climber, tunnel, etc.), slides, swings (including baby swings), and merry-go-round. Picnic shelter. Drinking fountain. Ball courts.",
                "514 N Owen Dr, Madison, WI 53705", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1236"));
        kidThings.add(new KidThing("Oak Park Heights Park", R.drawable.park_oak_park_heights_01_thumbnail,
                "Mini park with play structure (climber, etc.), slides, swings, and jungle gym. Picnic shelter. Drinking fountain. Ball court.",
                "641 Hilltop Dr, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1263"));
        kidThings.add(new KidThing("William Slater Park", R.drawable.park_william_slater_01_thumbnail,
                "Mini park with play structure (climber, etc.), slide, and swings. Ball court.",
                "561 S Segoe Rd, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1342"));
        kidThings.add(new KidThing("Segoe Park", R.drawable.park_segoe_01_thumbnail,
                "Mini park with play structure (climber, etc.), slide, and swings. Picnic shelter. Drinking fountain. Ball court.",
                "502 S Segoe Rd, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1327"));
        kidThings.add(new KidThing("Zook Park", R.drawable.park_zook_01_thumbnail,
                "Mini park with play structure (climber, tunnel, etc.), slide, and  swings. Picnic table.",
                "950 Pontiac Trail, Madison, WI 53711", "4am - 10pm", "https://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1398"));

//        parksArrayList = kidThings;

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        // TODO: This sorta (Log does; toast doesn't) works. But - don't know that it is the way to go to another fragment...
        // TODO: Finish coding this OnItemClickListener so that it either opens the detail fragment (w/ correct item)
        // or passes that item to the already displayed detail fragment...
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getActivity(),"You've made a selection from the list!",Toast.LENGTH_LONG).show();
                Log.v("***TESTING***", "onItemClickListener is registering!");
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
        // TODO: Update argument type and name
        void onParksFragmentInteraction(int position);
    }
}
