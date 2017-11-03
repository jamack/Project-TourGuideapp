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
 * {@link RestaurantsListFragment.OnRestaurantsFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RestaurantsListFragment extends Fragment {

    // Declare a global reference to an ArrayList of KidThings so it can be accessed methods outside onCreateView()
    private static ArrayList<KidThing> kidThings = null;

    // Create an instance of listener for interaction with the fragment and its listing of KidThing items
    private OnRestaurantsFragmentInteractionListener mRestaurantsListener;

    public RestaurantsListFragment() {
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
        kidThings.add(new KidThing("Chocolate Shoppe Ice Cream Co.", R.drawable.restaurant_chocolateshoppe_midvale_01_thumbnail, R.drawable.restaurant_chocolateshoppe_midvale_01_3to2,
                "Old-fashioned, family-owned store serving up more than 100 flavors of ice cream since 1962. Small play area with toys, child tables/chairs, toy food carts, kitchen set, etc. " +
                        "Jelly beans. Restrooms. Drinking fountain. Indoor & outdoor seating.",
                "555 S Midvale Blvd, Madison, WI 53711", "43.0542777,-89.45083069999998", "11:00am – 10:00pm", "http://www.chocolateshoppeicecream.com", 6084415248L));
        kidThings.add(new KidThing("Ella's Deli & Ice Cream Parlor", R.drawable.restaurant_ellas_deli_01_thumbnail, R.drawable.restaurant_ellas_deli_01_3to2,
                "Kid-oriented eatery with colorful, animated decor & a carousel offering American food & desserts.",
                "2902 E Washington Ave, Madison, WI 53704", "43.1035133,-89.34459809999998", "Sun-Th 11:00am – 10:00pm, F-Sat 11:00am – 11:00pm", "http://www.ellasdeli.com", 6082415291L));
        kidThings.add(new KidThing("Yola's Cafe and Coffee Shop", R.drawable.restaurant_yolas_cafe_01_thumbnail, R.drawable.park_segoe_01_3to2,
                "Mellow coffeehouse offering java, pastries & savory dishes plus WiFi, a fireplace & a big patio. Kid's play area. Diaper changing station(s). High chairs. Kids menu.",
                "494 Commerce Dr, Madison, WI 53719", "43.05542819999999,-89.52318220000001", "Tues-Sat 7:00am – 4:30pm", "http://www.yolascafe.com", 6088275800L));
        kidThings.add(new KidThing("Monty's Blue Plate Diner", R.drawable.restaurant_montys_blue_plate_01_thumbnail, R.drawable.restaurant_montys_blue_plate_01_3to2,
                "Retro gas station-turned-neighborhood diner. Varied menu including breakfast all day. Voted one of Madison's best restaurants for vegetarians/vegans, " +
                        "with walnut burgers, tofu scrambler, vegan banana walnut pancakes, vegetarian chili, fruit plates, grilled vegetable salads, vegetarian hash, veggie wraps (and more!). " +
                        "Great desserts: shakes/malts, sundaes, pies, cakes, bakery goodies, etc. Beer, wine, & mixed drinks. Fun, throwback diner interior. Easy access from/to bike path.",
                "2089 Atwood Avenue, Madison, WI 53704", "43.0923846,-89.35193079999999", "Sun 7:30am-9pm, M-Thurs 7am-9pm, F 7am-10pm, Sat 7:30am-10pm", "https://montysblueplatediner.com/", 6082448505L));
        kidThings.add(new KidThing("Ian's Pizza on State", R.drawable.restaurant_ians_pizza_state_01_thumbnail, R.drawable.restaurant_ians_pizza_state_01_3to2,
                "Wisconsin-born chain known for its creative pizzas including its signature mac 'n' cheese pie. Right off of the Capitol Square, on State Street. Space can be tight, but line usually moves well even when crowded. " +
                        "Many standard and specialty pizzas pre-made for by-the-slice ordering. Friendly staff. College kid favorite, but equally popular with families during downtown events.",
                "100 State St, Madison, WI 53703", "43.0748969,-89.38706460000003", "Sun-Thurs 11am-2:30am, F 11am-3pm, Sat 11am-2:30am", "https://ianspizza.com/madison/", 6082579248L));
        kidThings.add(new KidThing("ZuZu Cafe", R.drawable.restaurant_zuzu_cafe_01_thumbnail, R.drawable.restaurant_zuzu_cafe_01_3to2,
                "Cheery cafe serving American & Mediterranean fare in a family-friendly venue. Cozy interior space including small tables and a limited number of comfy couches/chairs; " +
                        "outdoor seating for good weather. Kid attractions include small indoor play area and outdoor sandbox with toys. Serves varied breakfasts & lunches, coffee, bakery treats, etc. " +
                        "Also serves as a “market” with beverages and small packaged food items for sale. Adjacent to Henry Vilas Zoo.",
                "1336 Drake St, Madison, WI 53715", "43.0623639,-89.40875219999998", "Sun 8:30am-5pm, M 7:30am-3pm, Tues-W 7am-7pm, Thurs-F 7am-9:30pm, Sat 8:30am-9:30pm", "https://www.yelp.com/biz/zuzu-cafe-and-market-madison", 6082609898L));
        kidThings.add(new KidThing("Michael's Frozen Custard - Monroe St", R.drawable.restaurant_michaels_custard_monroe_01_thumbnail, R.drawable.restaurant_michaels_custard_monroe_01_3to2,
                "Nationally reknown frozen custard, since 1986. Featuring a flavor-of-the day plus sundaes, malts, shakes, etc. Fries, hamburgers, hot dogs, etc. Outdoor patio seating, plus some indoor seating. Located on the Monroe St. pedestrian corridor, " +
                        "adjacent to Wingra Park, and relatively close to the bike path.",
                "2531 Monroe St, Madison, WI 53711", "43.0576451,-89.42760579999998", "Sun-Thurs 11am-10pm, F-Sat 11am-10:30pm", "http://www.ilovemichaels.com/", 6082313500L));
        kidThings.add(new KidThing("Michael's Frozen Custard - Schroeder Rd", R.drawable.restaurant_michaels_custard_schroeder_01_thumbnail, R.drawable.restaurant_michaels_custard_schroeder_01_3to2,
                "Nationally reknown frozen custard, since 1986. Featuring a flavor-of-the day plus sundaes, malts, shakes, etc. Fries, hamburgers, hot dogs, etc. Outdoor patio seating only at this location. Located across from Vitense Golfland.",
                "5602 Schroeder Rd, Madison, WI 53711", "43.04674259999999,-89.47580849999997", "Sun-Thurs 11am-10pm, F-Sat 11am-10:30pm", "http://www.ilovemichaels.com/", 6082768100L));
        kidThings.add(new KidThing("Monona Bait & Ice Cream Shop", R.drawable.restaurant_bait_ice_cream_01_thumbnail, R.drawable.restaurant_bait_ice_cream_01_thumbnail,
                "Down-home institution serving 15 flavors of ice cream, malts/shakes, desserts, pizza, wraps, burgers, subs, and made-to-order sandwiches, plus live bait. Freshly popped popcorn, candy counter, and cooler with bottles of soda " +
                        "including Fanta and Orange Crush. On the Lake Monona bike route/loop, across the street from Schluter Park on the shore of Lake Monona. Cash only, but has an ATM. Seasonal – open late spring to early fall.",
                "4516 Winnequah Rd, Monona, WI 53716", "43.0712896,-89.3337962", "April-Oct, Sun-Sat 11am-9pm", "http://mononabaiticecream.yolasite.com/", 6082221944L));
        kidThings.add(new KidThing("Chuck E. Cheese's", R.drawable.restaurants_chuck_e_cheese_01_thumbnail, R.drawable.restaurants_chuck_e_cheese_01_3to2,
                "Kid-friendly chain known for its arcade games, pizza parties, play zones & mouse mascot. This particular Chuck E Cheese gets terrible reviews, on many fronts. Remove this entry and replace with a more promising one...",
                "438 Grand Canyon Dr, Madison, WI 53719", "43.0585402,-89.49731209999999", "Sun-Thurs 11am-9pm, F 11am-10pm, Sat 10am-10pm", "https://www.chuckecheese.com/storedetails/wi/madison/604", 6088292000L));


        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Create instance of KidThing custom adapter
        KidThingAdapter kidThingAdapter = new KidThingAdapter(getActivity(), kidThings);

        // Attach the newly instantiated KidThingAdapter on the ListView
        listView.setAdapter(kidThingAdapter);

        // Initialize an OnItemLickListener and set it on the ListView so we can detect user interaction with the list.
        // Implement the OnItemClickListener by overriding/completing its onItemClick() method signature
        // to call the RestaurantsListener object's (checking first that it's been initialized) onRestaurantsFragmentInteraction() method.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mRestaurantsListener != null) {
                    mRestaurantsListener.onRestaurantsFragmentInteraction(position);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRestaurantsFragmentInteractionListener) {
            mRestaurantsListener = (OnRestaurantsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRestaurantsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mRestaurantsListener = null;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) { // Your fragment is visible
            // Caller setter method in MainActivity to update ActionBar's title for this fragment
            MainActivity.setActionBarTitle("Child-Friendly Restaurants");

            // If in dual pane mode, call method (in MainActivity) to make sure details fragment is updated to show default (first) Restaurants listing.
            // Pass method an integer corresponding to this category's value in the KidThingFragmentPagerAdapter's getItem() method.
            if (getActivity().findViewById(R.id.listing_container) != null) {
                ((MainActivity) getActivity()).displayDefaultDetails(2);
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
    public interface OnRestaurantsFragmentInteractionListener {
        // Method signature to be executed when user clicks on the ListView.
        // This interface will need to be implemented by MainActivity and have the method completed.
        void onRestaurantsFragmentInteraction(int position);
    }

}
