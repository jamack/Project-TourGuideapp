package com.example.android.project_tourguideapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParksListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ParksListFragment extends Fragment {

//    private OnFragmentInteractionListener mListener;

    public ParksListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate our list_view ListView and assign the instance to a variable
        View rootView = inflater.inflate(R.layout.kidthing_list, container, false);

        final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
        kidThings.add(new KidThing(getString(R.string.park_westmorland_listing_title), R.drawable.westmorland_park_01_thumbnail, getString(R.string.park_westmorland_description), getString(R.string.park_westmorland_address), getString(R.string.park_westmorland_hours_dates), getString(R.string.park_westmorland_website)));
        kidThings.add(new KidThing("Odana Hills East Park", R.drawable.westmorland_park_01_thumbnail,
                "String_description", "String_address",
                "String_hours and dates", "String_web address"));
        kidThings.add(new KidThing("String_KidThing02", R.drawable.westmorland_park_01_thumbnail,
                "String_description", "String_address",
                "String_hours and dates", "String_web address"));

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        return rootView;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
