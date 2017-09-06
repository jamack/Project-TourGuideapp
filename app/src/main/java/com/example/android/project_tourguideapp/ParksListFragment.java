package com.example.android.project_tourguideapp;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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

        // TODO: SETUP MY APPBAR. (FOLLOWING STEPS IN ANDROID DEVELOPERS GUIDE...)
        // Set the toolbar_list as the app bar for this Activity (via this Fragment)
        android.support.v7.widget.Toolbar myToolbar = (android.support.v7.widget.Toolbar) getActivity().findViewById(R.id.toolbar_list);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle("Parks & Playgrounds");

        // TODO: SET MY STATUS BAR COLOR. (IS IT THE BEST PLACE TO PLACE THIS CODE?)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.BLUE);
        }


        final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
        kidThings.add(new KidThing(getString(R.string.park_westmorland_listing_title), R.drawable.westmorland_park_01_thumbnail, getString(R.string.park_westmorland_description), getString(R.string.park_westmorland_address), getString(R.string.park_westmorland_hours_dates), getString(R.string.park_westmorland_website)));
        kidThings.add(new KidThing("Nakoma Park", R.drawable.park_nakoma_01_thumbnail,
                "Medium-sized playground with swingset (including baby swings), play structure (steps, climber, etc), and slide. Drinking fountain. Ball courts/fields. Ice skating.", "3801 Cherokee Dr, Madison, WI 53711",
                "4am - 10pm", "http://www.cityofmadison.com/parks/find-a-park/park.cfm?id=1270"));
        kidThings.add(new KidThing("Odana Hills East Park", R.drawable.park_odana_hills_east_01_thumbnail,
                "Mini playground with play structure (climber, etc.), slide, and swings (including baby swings). Drinking fountain. Benches. Ball courts.",
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
