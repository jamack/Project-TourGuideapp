package com.example.android.project_tourguideapp;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.description;
import static android.R.attr.name;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListingDetailFragment.OnDetailFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ListingDetailFragment extends Fragment {

    public static String ARG_LISTING_NAME = "ARG_LISTING_NAME";
    public static String ARG_IMAGE_RESOURCE = "ARG_IMAGE_RESOURCE";
    public static String ARG_FULL_DESCRIPTION = "ARG_FULL_DESCRIPTION";
    public static String ARG_ADDRESS = "ARG_ADDRESS";
    public static String ARG_HOURS_DATES = "ARG_HOURS_DATES";
    public static String ARG_WEBSITE = "ARG_WEBSITE";
    public static String ARG_PHONE_NUMBER = "ARG_PHONE_NUMBER";
    // Create constant values for keys that would be expected in Bundle used to create Fragment
    static String ARG_POSITION = "position";
    private Bundle mBundle = null;

//    private OnDetailFragmentInteractionListener mListener;

    // Create fields that will later hold references to Views
    private TextView mListingName;
    private ImageView mImage;
    private TextView mDescription;
    private TextView mAddress;
    private TextView mHoursDates;
    private TextView mWebsite;
    private TextView mPhoneNumber;

    public ListingDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listing_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO: [seems to be working!] FIGURE OUT HOW TO HANDLE SAVED INSTANCE STATE VS. PASSED BUNDLE WHEN STARTED BY MY DETAILSACTIVITY...
        if (savedInstanceState != null) {
            mBundle = savedInstanceState;
            updateListingDetails(mBundle);
        } else if (getArguments() != null) {
            Log.v("***TESTING***", "In ListingDetailFragment's onViewCreated method; savedInstanceState is null, but getArguments bundle is NOT!");
            mBundle = getArguments();
            updateListingDetails(mBundle);
        } else {
            Log.v("***TESTING***", "In ListingDetailFragment's onViewCreated method; savedInstanceState and getArguments bundles are BOTH null...");
            updateListingDetails(ParksListFragment.getBundle(0));
        }

    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnDetailFragmentInteractionListener) {
//            mListener = (OnDetailFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnDetailFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;

        mListingName = null;
        mImage = null;
        mDescription = null;
        mAddress = null;
        mHoursDates = null;
        mWebsite = null;
        mPhoneNumber = null;
    }

    public void updateListingDetails(Bundle bundle) {
        // TODO: This method is called from MainActivity. The below message IS printed to the log, but then there's a null pointer excception & app crashes...
        // Using "this" before fields does not solve the problem.
        Log.v("***TESTING***", "We have entered the updateListingDetails method.");
        Log.v("***TESTING***", bundle.toString());

        // TODO: ADD CODE TO DYNAMICALLY POPULATE THE VIEWS. [THIS IS A TESTING PLACEHOLDER]...
        // Ensure that required data has been passed via the Bundle before proceeding
        if (bundle != null) {
            mListingName = (TextView) getActivity().findViewById(R.id.detail_listing_name);
            if (mListingName != null) {
                Log.v("***TESTING***", "mListingName is NOT null, so we've found the listing name TextView to update!");
            }
            mListingName.setText(bundle.getString(ARG_LISTING_NAME));

            // TODO: ADD IF STATEMENT LATER TO CHECK IF SELECTED ITEM HAS AN IMAGE BEFORE SETTING IT...
            mImage = (ImageView) getActivity().findViewById(R.id.detail_image);
            mImage.setImageResource(bundle.getInt(ARG_IMAGE_RESOURCE));

            mDescription = (TextView) getActivity().findViewById(R.id.detail_description_full);
            mDescription.setText(bundle.getString(ARG_FULL_DESCRIPTION));

            mHoursDates = (TextView) getActivity().findViewById(R.id.detail_hours_dates);
            mHoursDates.setText(bundle.getString(ARG_HOURS_DATES));
        }
    }

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
//    public interface OnDetailFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
