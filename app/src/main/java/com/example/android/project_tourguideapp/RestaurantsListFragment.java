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
public class RestaurantsListFragment extends Fragment {

//    private OnFragmentInteractionListener mListener;

    public RestaurantsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate our list_view ListView and assign the instance to a variable
        View rootView = inflater.inflate(R.layout.kidthing_list, container, false);

        final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
        kidThings.add(new KidThing("Chocolate Shoppe Ice Cream Co.", R.drawable.restaurant_chocolateshoppe_midvale_01_thumbnail,
                "Old-fashioned, family-owned store serving up more than 100 flavors of ice cream since 1962. Small play area with toys, child tables/chairs, toy food carts, kitchen set, etc. Jelly beans. Restrooms. Drinking fountain. Indoor & outdoor seating.",
                "555 S Midvale Blvd, Madison, WI 53711", "11:00am – 10:00pm", "http://www.chocolateshoppeicecream.com", 6084415248L));
        kidThings.add(new KidThing("Ella's Deli & Ice Cream Parlor", R.drawable.restaurant_ellas_deli_01_thumbnail,
                "Kid-oriented eatery with colorful, animated decor & a carousel offering American food & desserts. ",
                "2902 E Washington Ave, Madison, WI 53704 ", "Sun-Th 11:00am – 10:00pm, F-Sat 11:00am – 11:00pm", "http://www.ellasdeli.com", 6082415291L));
        kidThings.add(new KidThing("Yola's Cafe and Coffee Shop", R.drawable.restaurant_yolas_cafe_01_thumbnail,
                "Mellow coffeehouse offering java, pastries & savory dishes plus WiFi, a fireplace & a big patio. Kid's play area. Diaper changing station(s). High chairs. Kids menu.",
                "494 Commerce Dr, Madison, WI 53719", "Tues-Sat 7:00am – 4:30pm", "http://www.yolascafe.com", 6088275800L));


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        return rootView;
    }

}
