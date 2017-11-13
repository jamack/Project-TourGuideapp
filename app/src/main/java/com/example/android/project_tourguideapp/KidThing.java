package com.example.android.project_tourguideapp;

/**
 * {@link KidThing} represents a listing for a child-friendly place (park, playground, store, restaurant, etc.)
 * or event (storytelling, farmers market, music series, etc.)
 */

class KidThing {

    /**
     * Constant value denoting default state of no associated image.
     * Will be overridden if new com.example.android.project_tourguideapp.KidThing object is constructed with an associated image.
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constant value denoting default state of no associated hours/dates.
     * Will be overridden if new com.example.android.project_tourguideapp.KidThing object is constructed with associated hours/dates.
     */
    private static final String NO_HOURS_DATES_PROVIDED = null;

    /**
     * Constant value denoting default state of no associated phone number.
     * Will be overridden if new com.example.android.project_tourguideapp.KidThing object is constructed with an associated phone number.
     */
    private static final long NO_PHONE_NUMBER_PROVIDED = 0;

    /**
     * Title for the listing
     */
    private String mListingName;

    /**
     * IF APPLICABLE, Image Resource ID for a representative image. May not be applicable to some categories.
     */
    private int mImageThumbnailResourceId = NO_IMAGE_PROVIDED;

    /**
     * IF APPLICABLE, Image Resource ID for a representative image. May not be applicable to some categories.
     */
    private int mImageBannerResourceId = NO_IMAGE_PROVIDED;

    /**
     * Overview of the listing. May describe available play equipment, what features make the venue especially child-friendly, etc.
     */
    private String mDescription;

    /**
     * Address for the venue/event
     */
    private String mAddress;

    /**
     * Address for the venue/event - in geographical coordinate format
     */
    private String mGeocoordinates;

    /**
     * Hours (& possibly days of the week) that a venue is open -OR- dates (& possibly hours) that an event is occurring.
     */
    private String mHoursDates = NO_HOURS_DATES_PROVIDED;

    /**
     * IF APPLICABLE, website where user can find more information.
     */
    private String mWebsite;

    /**
     * IF APPLICABLE, phone number to contact for more information, reservations, etc.
     */
    private long mPhoneNumber = NO_PHONE_NUMBER_PROVIDED;

    /**
     * Create a new com.example.android.project_tourguideapp.KidThing object.
     * This constructor includes all fields.
     *
     * @param name             - event/venue title
     * @param imageIdThumbnail - image resource id for representative thumbnail image
     * @param imageIdBanner    - image resource id for representative banner image
     * @param description      - overview of event/venue
     * @param address          - where event/venue is located
     * @param geocoordinates   - address, in geographical coordinate format
     * @param hoursDates       - times when venue is open -or- date(s)/times that event is occurring.
     * @param website          - url for more detailed info
     * @param phoneNum         - phone number to contact
     */
    KidThing(String name, int imageIdThumbnail, int imageIdBanner, String description, String address, String geocoordinates, String hoursDates, String website, long phoneNum) {
        mListingName = name;
        mImageThumbnailResourceId = imageIdThumbnail;
        mImageBannerResourceId = imageIdBanner;
        mDescription = description;
        mAddress = address;
        mGeocoordinates = geocoordinates;
        mHoursDates = hoursDates;
        mWebsite = website;
        mPhoneNumber = phoneNum;
    }

    /**
     * Create a new com.example.android.project_tourguideapp.KidThing object.
     * This constructor excludes phone number.
     *
     * @param name             - event/venue title
     * @param imageIdThumbnail - image resource id for representative thumbnail image
     * @param imageIdBanner    - image resource id for representative banner image
     * @param description      - overview of event/venue
     * @param address          - where event/venue is located
     * @param geocoordinates   - address, in geographical coordinate format
     * @param hoursDates       - times when venue is open -or- date(s)/times that event is occurring.
     * @param website          - url for more detailed info
     */
    KidThing(String name, int imageIdThumbnail, int imageIdBanner, String description, String address, String geocoordinates, String hoursDates, String website) {
        mListingName = name;
        mImageThumbnailResourceId = imageIdThumbnail;
        mImageBannerResourceId = imageIdBanner;
        mDescription = description;
        mAddress = address;
        mGeocoordinates = geocoordinates;
        mHoursDates = hoursDates;
        mWebsite = website;
    }

    /**
     * Getter method for venue/event title
     */
    String getListingName() {
        return mListingName;
    }

    /**
     * Returns whether or not there is an image for this venue/event
     */
    boolean hasImage() {
        return mImageThumbnailResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Getter method for any associated thumbnail image resource ID
     */
    int getThumbnailImageResourceId() {
        return mImageThumbnailResourceId;
    }

    /**
     * Getter method for any associated banner image resource ID
     */
    int getBannerImageResourceId() {
        return mImageBannerResourceId;
    }

    /**
     * Getter method for description of venue/event
     */
    String getDescription() {
        return mDescription;
    }

    /**
     * Getter method for venue/event's physical address
     */
    String getAddress() {
        return mAddress;
    }

    /**
     * Getter method for geocoordinates of venue/event's physical address
     */
    String getGeocoordinates() {
        return mGeocoordinates;
    }

    /**
     * Returns whether or not there are hours/dates for this venue/event
     */
    boolean hasHoursDates() {
        return mHoursDates != NO_HOURS_DATES_PROVIDED;
    }

    /**
     * Getter method for any associated hours/dates
     */
    String getHoursDates() {
        return mHoursDates;
    }

    /**
     * Getter method for venue/event's web address
     */
    String getWebsite() {
        return mWebsite;
    }

    /**
     * Returns whether or not there is a phone number for this venue/event
     */
    boolean hasPhoneNumber() {
        return mPhoneNumber != NO_PHONE_NUMBER_PROVIDED;
    }

    /**
     * Getter method for any associated phone number
     */
    long getPhoneNumber() {
        return mPhoneNumber;
    }

    @Override
    public String toString() {
        return "com.example.android.project_tourguideapp.KidThing{" +
                "mListingName: " + mListingName + "; " +
                "mImageThumbnailResourceID: " + mImageThumbnailResourceId + "; " +
                "mImageBannerResourceID: " + mImageBannerResourceId + "; " +
                "mDescription: " + mDescription + "; " +
                "mAddress: " + mAddress + "; " +
                "mGeocoordinates: " + mGeocoordinates + "; " +
                "mHoursDates: " + mHoursDates + "; " +
                "mWebsite: " + mWebsite + "; " +
                "mPhoneNumber: " + mPhoneNumber;
    }
}
