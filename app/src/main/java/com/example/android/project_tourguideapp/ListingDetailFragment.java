package com.example.android.project_tourguideapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListingDetailFragment.OnDetailFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ListingDetailFragment extends Fragment implements OnMapReadyCallback {

    // Create constant values for keys that would be expected in Bundle used to create Fragment
    public static String ARG_LISTING_NAME = "ARG_LISTING_NAME";
    public static String ARG_IMAGE_RESOURCE_BANNER = "ARG_IMAGE_RESOURCE_BANNER";
    public static String ARG_FULL_DESCRIPTION = "ARG_FULL_DESCRIPTION";
    public static String ARG_ADDRESS = "ARG_ADDRESS";
    public static String ARG_GEOCOORDINATES = "ARG_GEOCOORDINATES";
    public static String ARG_HOURS_DATES = "ARG_HOURS_DATES";
    public static String ARG_WEBSITE = "ARG_WEBSITE";
    public static String ARG_PHONE_NUMBER = "ARG_PHONE_NUMBER";
    // Global variable to track whether ListingDetailFragment is being shown in one- or two-pane mode
    boolean isDualPane;

//    private OnDetailFragmentInteractionListener mListener;

    // Global variable to store reference to fragment's view hierarchy
    View rootView = null;

    // Global variable to store reference to any applicable Bundle used within this Fragment
    private Bundle mBundle = null;

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
        rootView = inflater.inflate(R.layout.fragment_listing_detail, container, false);

        // Report that this fragment would like to participate in populating the options menu by receiving a call to
        // onCreateOptionsMenu and related methods.
        setHasOptionsMenu(true);

//        // TODO: FIGURE OUT HOW TO GET MAP GOING...ADD A CHILD FRAGMENT HERE?
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_container);
//        mapFragment.getMapAsync(this);

        return rootView;
//        return inflater.inflate(R.layout.fragment_listing_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LinearLayout listContainer = (LinearLayout) getActivity().findViewById(R.id.listing_container);
        if (listContainer != null) {
            isDualPane = true;
            Log.v("***TESTING***", "Per ListingDetailFragment's listContainer check, isDualPane is currently: TRUE!");
        } else {
            isDualPane = false;
            Log.v("***TESTING***", "Per ListingDetailFragment's listContainer check,  isDualPane is currently: FALSE!");
        }

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

        // TODO: SETUP MY APPBAR. (FOLLOWING STEPS IN ANDROID DEVELOPERS GUIDE...)
        if (!isDualPane) {
            Log.v("***TESTING***", "In ListingDetailFragment's actionbar setup, and  isDualPane is currently: FALSE!");
            //Set the toolbar_list as the app bar for this Activity (via this Fragment)
            android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar_detail);
            ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            actionBar.setTitle("Details");


            // TODO: SET MY STATUS BAR COLOR. (IS IT THE BEST PLACE TO PLACE THIS CODE?)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getActivity().getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.BLUE);
            }
        } else {
            Log.v("***TESTING***", "In ListingDetailFragment's actionbar setup, and isDualPane is currently: TRUE!");
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.action_bar_details, menu);

        // Hide Call_the_Listing action if Listing has no associated phone number
        if (mBundle.getLong(ARG_PHONE_NUMBER) == 0) {
            MenuItem item = menu.findItem(R.id.call_the_listing);
            item.setVisible(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.call_the_listing:
                // User chose the "Call the Listing" item - launch dialer intent
                // with phone number from the currently displayed listing details.
                Intent dialerIntent = new Intent(Intent.ACTION_DIAL);
                String dialerIntentString = "tel:" + Long.toString(mBundle.getLong(ARG_PHONE_NUMBER));
                dialerIntent.setData(Uri.parse(dialerIntentString));
                startActivity(dialerIntent);

            case R.id.open_in_browser:
                // User chose the "Open in Browser" item - launch browser
                // with the website address from the currently displayed listing details.
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                String websiteIntentString = mBundle.getString(ARG_WEBSITE);
                websiteIntent.setData(Uri.parse(websiteIntentString));
                startActivity(websiteIntent);

            case R.id.navigate_to_listing:
                // User chose the "Navigate to Listing" item - launch navigation
                // with the address from the currently displayed listing details.
                String geocoordString = "google.navigation:q=" + mBundle.getString(ARG_GEOCOORDINATES);
                Uri gmmIntentUri = Uri.parse(geocoordString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
//        LatLng sydney = new LatLng(-33.852, 151.211);
//        googleMap.addMarker(new MarkerOptions().position(sydney)
//                .title("Marker in Sydney"));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Get geocoordinates from the listing's Bundle, and process that into a Double for latitude & for longitude.
        String stringLatLong = mBundle.getString(ARG_GEOCOORDINATES);
        String[] stringArrayLatLong = stringLatLong.split(",");
        double latitude = Double.parseDouble(stringArrayLatLong[0]);
        double longitude = Double.parseDouble(stringArrayLatLong[1]);

        // Construct a LatLng object for the listing using its latitude & longitude.
        LatLng listingLatLng = new LatLng(latitude, longitude);

        // Add a marker at the listing's location,
        // and move the map's camera to the same location.
        googleMap.addMarker(new MarkerOptions().position(listingLatLng)
                .title("Location X"));
        Float zoomLevel = (float) 12;
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(listingLatLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(zoomLevel));
    }

    public void updateListingDetails(Bundle bundle) {
        // TODO: This method is called from MainActivity. The below message IS printed to the log, but then there's a null pointer excception & app crashes...
        // Using "this" before fields does not solve the problem.
        Log.v("***TESTING***", "We have entered the updateListingDetails method.");
        Log.v("***TESTING***", bundle.toString());

        // TODO: ADD CODE TO DYNAMICALLY POPULATE THE VIEWS. [THIS IS A TESTING PLACEHOLDER]...
        // Ensure that required data has been passed via the Bundle before proceeding
        if (bundle != null) {

            // TODO: ADD IF STATEMENT LATER TO CHECK IF SELECTED ITEM HAS AN IMAGE BEFORE SETTING IT...
            mImage = (ImageView) getActivity().findViewById(R.id.detail_image);
            mImage.setImageResource(bundle.getInt(ARG_IMAGE_RESOURCE_BANNER));

            mListingName = (TextView) getActivity().findViewById(R.id.detail_listing_name);
            if (mListingName != null) {
                Log.v("***TESTING***", "mListingName is NOT null, so we've found the listing name TextView to update!");
            }
            mListingName.setText(bundle.getString(ARG_LISTING_NAME));

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