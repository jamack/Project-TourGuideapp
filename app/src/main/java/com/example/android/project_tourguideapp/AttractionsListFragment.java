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
 * {@link AttractionsListFragment.OnAttractionsFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AttractionsListFragment extends Fragment {

    // Declare a global reference to an ArrayList of KidThings so it can be accessed methods outside onCreateView()
    private static ArrayList<KidThing> kidThings = null;

    // Create an instance of listener for interaction with the fragment and its listing of KidThing items
    private OnAttractionsFragmentInteractionListener mAttractionsListener;

    public AttractionsListFragment() {
        // Required empty public constructor
    }

    // TODO: THIS CODE IS REPEATED IN ALL MY LIST FRAGMENTS. SHOULD I CREATE A MASTER CLASS AND INHERIT FROM THAT?

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
        bundle.putString(ListingDetailFragment.ARG_GEOCOORDINATES, kidThings.get(position).getGeocoordinates());
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
        kidThings.add(new KidThing("Madison Children's Museum", R.drawable.attractions_childrens_museum_01_thumbnail, R.drawable.attractions_childrens_museum_01_3to2,
                "With one-of-a-kind interactive exhibits, daily activities, and year-round special events, there is always something to do " +
                        "at Madison Children's Museum. Come see where children, newborn through age 12, bring grown-ups for a day of play! " +
                        "$8/child + $8/adult. Annual family membership: $125 - 4 members, $150 - 6 members.",
                "100 N Hamilton St, Madison, WI 53703", "43.0768232,-89.3844752", "Tues - Sun 9:30am - 5pm",
                "http://madisonchildrensmuseum.org/", 6082566445L));
        kidThings.add(new KidThing("Henry Vilas Zoo", R.drawable.attractions_vilas_zoo_01_thumbnail, R.drawable.attractions_vilas_zoo_01_3to2,
                "28-acre zoo with no admission or parking fees. Amphibians, birds, fish, insects, mammals, & reptiles. Petting zoo. Childrens play area, " +
                        "including huge play structure, carousel & train rides. Concessions, cafe, gift shop.",
                "702 S Randall Ave, Madison, WI 53715", "43.06061039999999,-89.410035", "Sun-Sat 9:30am - 5pm",
                "http://www.vilaszoo.org/", 6082589490L));
        kidThings.add(new KidThing("PlayN Wisconsin", R.drawable.attractions_playn_wisconsin_01_thumbnail, R.drawable.attractions_playn_wisconsin_01_3to2,
                "Indoor Play: Our all day, unlimited open gym play sessions allow children the benefits of fun-filled physical activity. " +
                        "Toddlers, tweens and even grandparents will enjoy our brightly decorated, 12,000+ square foot, indoor sock-only facility." +
                        "Our huge indoor play showroom is filled with more than ten of the safest most durable play systems, basketball hoops, trainers, " +
                        "and the world’s safest trampolines! $7/child weekdays, $9/child weekends. $100 + tax for 1-child annual pass.",
                "3919 Parmenter Street, Middleton, WI 53562", "43.1184483,-89.51212040000001", "M & Thurs 10am - 7pm, Tues/W/F 10am - 5pm, Sat & Sun 12pm - 4pm",
                "http://playnwisconsin.com/playn-wisconsin-about-us/open-play/", 6082345600L));
        kidThings.add(new KidThing("Rockin' Jump Trampoline Park", R.drawable.attractions_rockin_jump_01_thumbnail, R.drawable.attractions_rockin_jump_01_3to2,
                "Indoor trampoline park where you can soar in open jump arenas, play trampoline dodgeball, do flips and somersaults, slam dunk zone, concessions area," +
                        " kids' parties, etc. Rockin' Tots times: Sat 8am-10pm, Sun 9am-11am, W 9am-12pm.",
                "2700 Novation Pkwy, Madison, WI 53713", "43.0320338,-89.38453870000001", "Sun 9am - 7pm, Tues 4pm - 8pm, W 9am-12-m 4pm-8pm, Thur 4pm - 8pm, F 9am - 12pm 1pm - 10pm, Sat 8am - 10pm",
                "https://madison.rockinjump.com/", 6088195368L));
        kidThings.add(new KidThing("Sky Zone Trampoline Park", R.drawable.attractions_sky_zone_01_thumbnail, R.drawable.attractions_sky_zone_01_3to2,
                "Indoor trampoline park with freestyle jump, skyslam, ultimate dodgeball, skyjoust, skyladder, drop zone, warped wall, freeclimb, etc." +
                        "Toddler Time: Sat 9am-10am, Sun 10am-11am, $8/child.",
                "2134 W Beltline Hwy, Madison, WI 53713", "43.0367226,-89.41472970000001", "Sun 11am - 7pm, Tues-Thurs 4pm - 8pm, F 1:30pm - 11pm, Sat 10am - 11pm",
                "https://www.skyzone.com/madison", 6087193379L));
        kidThings.add(new KidThing("Pump It Up of Madison", R.drawable.attractions_pump_it_up_01_thumbnail, R.drawable.attractions_pump_it_up_01_3to2,
                "The Inflatable Party Zone - indoor gigantic inflatable-filled arenas for open play and private parties. Toddler Time: Thurs 2pm-4pm, $10/child.",
                "2911 Marketplace Dr, Fitchburg, WI 53719", "43.0104965,-89.45885329999999", "Hours vary - see calendar on website.",
                "https://www.pumpitupparty.com/fitchburg-wi/", 6084426386L));
        kidThings.add(new KidThing("Olbrich Botanical Gardens", R.drawable.attractions_olbrich_gardens_01_thumbnail, R.drawable.attractions_olbrich_gardens_01_3to2,
                "Stroll 16 acres of outdoor gardens featuring stunning landscapes and Midwest-hardy plants. Outdoor Gardens free & open daily." +
                        "Enjoy the Bolz Conservatory, an indoor tropical paradise, featuring exotic plants, fragrant flowers, and free-flying birds.",
                "3330 Atwood Ave, Madison, WI 53704", "43.09246929999999,-89.33571080000002", "Sun - Sat 8am - 8pm",
                "http://www.olbrich.org/", 6082464550L));
        kidThings.add(new KidThing("Vitense Golfland", R.drawable.attractions_vitense_golfland_01_thumbnail, R.drawable.attractions_vitense_golfland_01_3to2,
                "The #1 rated miniature golf courses in WI. Two 18-hole outdoor + one indoor miniature golf courses. Batting cages, climbing wall, arcade, remote-controlled boats," +
                        "jumpshot, water wars, platform tennis, driving range. Cafe.",
                "5501 Schroeder Rd, Madison, WI 53711", "43.04473489999999,-89.47643749999997", "Sun - Thur 8am - 10:30pm, F - Sat 8am - 11pm",
                "http://www.vitense.com/", 6082711411L));
        kidThings.add(new KidThing("UW-Madison Arboretum", R.drawable.attractions_the_arboretum_01_thumbnail, R.drawable.attractions_the_arboretum_01_3to2,
                "Arboretum trails invite hours of exploration for thousands of visitors. The nearly 20-mile trail system winds through prairies, savannas, woodlands, and wetlands, " +
                        "offering recreational opportunities for hikers and runners; scientific exploration for birders, botanists, and naturalists; inspiration for artists and photographers; " +
                        "and respite for anyone looking for a place to enjoy the outdoors. Visitors Center with classes.",
                "1207 Seminole Hwy, Madison, WI 53711", "43.0392482,-89.44362969999997", "Sun - Sat 8am - 8pm",
                "https://arboretum.wisc.edu/", 6082637888L));
        kidThings.add(new KidThing("Spring Harbor Beach", R.drawable.attractions_spring_harbor_beach_01_thumbnail, R.drawable.attractions_spring_harbor_beach_01_3to2,
                "This a fairly quiet, unknown beach tucked away within a small lakeside community. The water isn't the best here, but the general serenity provides " +
                        "a lovely place to relax and soak up some sun. Bathrooms. Water fountain. Picnic table. Swim ropes. Lifeguard 6/10 - 9/03, 12:30pm - 4:30pm",
                "1918 Norman Way, Madison, WI 53705", "43.0827839,-89.46963499999998", "Sun - Sat 4am - 10pm",
                "https://www.cityofmadison.com/parks/facilities/beach.cfm?id=10", 6082664711L));

        // Find instance of the list_view ListView and assign to a variable
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter and assign to a variable
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Hook the newly instantiated KidThingAdapter up to the ListView
        listView.setAdapter(kidThingAdapter);

        // Initialize an OnItemLickListener and set it on the ListView so we can detect user interaction with the list.
        // Implement the OnItemClickListener by overriding/completing its onItemClick() method signature
        // to call the AttractionsListener object's (checking first that it's been initialized) onAttractionsFragmentInteraction() method.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mAttractionsListener != null) {
                    mAttractionsListener.onAttractionsFragmentInteraction(position);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAttractionsFragmentInteractionListener) {
            mAttractionsListener = (OnAttractionsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnAttractionsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAttractionsListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) { // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Activities");

            // If in dual pane mode, call method (in MainActivity) to make sure details fragment is updated to show default (first) Attractions listing.
            // Pass method an integer corresponding to this category's value in the KidThingFragmentPagerAdapter's getItem() method.
            if (getActivity().findViewById(R.id.listing_container) != null) {
                ((MainActivity) getActivity()).displayDefaultDetails(1);
            }
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
    public interface OnAttractionsFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onAttractionsFragmentInteraction(int position);
    }

}
