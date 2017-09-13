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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListingDetailFragment.OnDetailFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ListingDetailFragment extends Fragment {

    static String ARG_POSITION = "position";
    private OnDetailFragmentInteractionListener mListener;
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

        updateListingDetails(1);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
        mListener = null;

        mListingName = null;
        mImage = null;
        mDescription = null;
        mAddress = null;
        mHoursDates = null;
        mWebsite = null;
        mPhoneNumber = null;
    }

    public void updateListingDetails(int position) {
        // TODO: This method is called from MainActivity. The below message IS printed to the log, but then there's a null pointer excception & app crashes...
        // Using "this" before fields does not solve the problem.
        Log.v("***TESTING***", "We have entered the updateListingDetails method prior to crashing.");


        // TODO: ADD CODE TO DYNAMICALLY POPULATE THE VIEWS. [THIS IS A TESTING PLACEHOLDER]...
        mListingName = (TextView) getActivity().findViewById(R.id.detail_listing_name);
        mListingName.setText("Listing Title");

        // TODO: ADD IF STATEMENT LATER TO CHECK IF SELECTED ITEM HAS AN IMAGE BEFORE SETTING IT...
        mImage = (ImageView) getActivity().findViewById(R.id.detail_image);
        mImage.setImageResource(R.drawable.park_nakoma_01_3to2);

        mDescription = (TextView) getActivity().findViewById(R.id.detail_description_full);
        mDescription.setText("This is where the full description text would go...");

        mHoursDates = (TextView) getActivity().findViewById(R.id.detail_hours_dates);
        mHoursDates.setText("Sun, Sat 11am - 9pm, M-F 9am - 7pm");
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
    public interface OnDetailFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
