package com.example.android.project_tourguideapp;

/**
 * {@link KidThing} represents a listing for a child-friendly location (park, playground, store, restaurant, etc.)
 * or event (storytelling, farmers market, music series, etc.)
 */

public class KidThing {

    /** Title for the listing */
    private String mListingName;

    /** Constant value denoting default state of no associated image.
     * Will be overridden if new com.example.android.project_tourguideapp.KidThing object is constructed with an associated image.
     */
     private static final int NO_IMAGE_PROVIDED = -1;

    /** IF APPLICABLE, Image Resource ID for a representative image. May not be applicable to some categories. */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Overview of the listing. May describe available play equipment, what features make the venue especially child-friendly, etc. */
    private String mDescription;

    /** Address for the venue/event */
    private String mAddress;

    /** Constant value denoting default state of no associated hours/dates.
     * Will be overridden if new com.example.android.project_tourguideapp.KidThing object is constructed with associated hours/dates.
     */
    private static final String NO_HOURS_DATES_PROVIDED = null;

    /** Hours (& possibly days of the week) that a venue is open -OR- dates (& possibly hours) that an event is occurring. */
    private String mHoursDates = NO_HOURS_DATES_PROVIDED;

    /** IF APPLICABLE, website where user can find more information. */
    private String mWebsite;

    /** Constant value denoting default state of no associated phone number.
     * Will be overridden if new com.example.android.project_tourguideapp.KidThing object is constructed with an associated phone number.
     */
    private static final long NO_PHONE_NUMBER_PROVIDED = 0;

    /** IF APPLICABLE, phone number to contact for more information, reservations, etc. */
    private long mPhoneNumber = NO_PHONE_NUMBER_PROVIDED;

    /**
     * Create a new com.example.android.project_tourguideapp.KidThing object.
     * This constructor includes all fields.
     * @param name - event/venue title
     * @param imageId - image resource id for representative image
     * @param description - overview of event/venue
     * @param address - where event/venue is located
     * @param hoursDates - times when venue is open -or- date(s)/times that event is occurring.
     * @param website - url for more detailed info
     * @param phoneNum - phone number to contact
     */
    public KidThing(String name, int imageId, String description, String address, String hoursDates, String website, long phoneNum) {
        mListingName = name;
        mImageResourceId = imageId;
        mDescription = description;
        mAddress = address;
        mHoursDates = hoursDates;
        mWebsite = website;
        mPhoneNumber = phoneNum;
    }

    /**
     * Create a new com.example.android.project_tourguideapp.KidThing object.
     * This constructor excludes images.
     * @param name - event/venue title
     * @param description - overview of event/venue
     * @param address - where event/venue is located
     * @param hoursDates - times when venue is open -or- date(s)/times that event is occurring.
     * @param website - url for more detailed info
     * @param phoneNum - phone number to contact
     */
    public KidThing(String name, String description, String address, String hoursDates, String website, long phoneNum) {
        mListingName = name;
        mDescription = description;
        mAddress = address;
        mHoursDates = hoursDates;
        mWebsite = website;
        mPhoneNumber = phoneNum;
    }

    /**
     * Create a new com.example.android.project_tourguideapp.KidThing object.
     * This constructor excludes phone number.
     * @param name - event/venue title
     * @param imageId - image resource id for representative image
     * @param description - overview of event/venue
     * @param address - where event/venue is located
     * @param hoursDates - times when venue is open -or- date(s)/times that event is occurring.
     * @param website - url for more detailed info
     */
    public KidThing(String name, int imageId, String description, String address, String hoursDates, String website) {
        mListingName = name;
        mImageResourceId = imageId;
        mDescription = description;
        mAddress = address;
        mHoursDates = hoursDates;
        mWebsite = website;
    }

    /**
     * Create a new com.example.android.project_tourguideapp.KidThing object.
     * This constructor excludes image & phone number.
     * @param name - event/venue title
     * @param description - overview of event/venue
     * @param address - where event/venue is located
     * @param hoursDates - times when venue is open -or- date(s)/times that event is occurring.
     * @param website - url for more detailed info
     */
    public KidThing(String name, String description, String address, String hoursDates, String website) {
        mListingName = name;
        mDescription = description;
        mAddress = address;
        mHoursDates = hoursDates;
        mWebsite = website;
    }

    /** Getter method for venue/event title */
    public String getListingName() {
        return mListingName;
    }

    /** Returns whether or not there is an image for this venue/event */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /** Getter method for any associated image resource ID */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getAddress() {
        return mAddress;
    }

    /** Returns whether or not there are hours/dates for this venue/event */
    public boolean hasHoursDates() {
        return mHoursDates != NO_HOURS_DATES_PROVIDED;
    }

    public String getHoursDates() {
        return mHoursDates;
    }

    public String getWebsite() {
        return mWebsite;
    }

    /** Returns whether or not there is a phone number for this venue/event */
    public boolean hasPhoneNumber() {
        return mPhoneNumber != NO_PHONE_NUMBER_PROVIDED;
    }

    public long getPhoneNumber() {
        return mPhoneNumber;
    }

    @Override
    public String toString() {
        return "com.example.android.project_tourguideapp.KidThing{" +
                "mListingName: " + mListingName + "; " +
                "mImageResourceID: " + mImageResourceId + "; " +
                "mDescription: " + mDescription + "; " +
                "mAddress: " + mAddress + "; " +
                "mHoursDates: " + mHoursDates + "; " +
                "mWebsite: " + mWebsite + "; " +
                "mPhoneNumber: " + mPhoneNumber;
    }
}
