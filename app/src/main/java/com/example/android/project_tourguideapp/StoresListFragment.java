package com.example.android.project_tourguideapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoresListFragment extends Fragment {


    public StoresListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate our list_view ListView and assign the instance to a variable
        View rootView = inflater.inflate(R.layout.kidthing_list, container, false);

        final ArrayList<KidThing> kidThings = new ArrayList<KidThing>();
        kidThings.add(new KidThing("Once Upon A Child", R.drawable.store_once_upon_a_child_01_thumbnail,
                "Chain operation that buys & sells gently used items for children, including clothes, shoes & toys.",
                "7475 Mineral Point Rd, Madison, WI 53717", "Sun 10:00am - 5:00pm, M-Sat 10:00am - 7:00pm", "http://www.onceuponachildmadisonwest.com", 6082039105L));
        kidThings.add(new KidThing("Happy Bambino", R.drawable.store_happy_bambino_01_thumbnail,
                "Local shop offering eco-friendly baby products, maternity needs & classes for parents & infants.",
                "4116 Monona Dr, Madison, WI 53716", "Sat,Sun 11:00am – 4:00pm, M-W 9:00am – 6:00pm, Thur,F 9:00am - 5:00pm", "https://www.happybambino.com", 6082236261L));
        kidThings.add(new KidThing("Satara Home and Baby", R.drawable.store_satara_01_thumbnail,
                "Simple shop for mattresses, bedding & towels made from organic materials, plus baby cribs & toys.",
                "6333 University Ave, Middleton, WI 53562", "M-F 10:00am - 6:00pm, Sat 10:00am - 5:00pm", "https://www.satarahome.com", 6082514905L));


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        return rootView;
    }

}