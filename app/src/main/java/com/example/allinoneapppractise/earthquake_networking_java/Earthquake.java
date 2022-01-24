package com.example.allinoneapppractise.earthquake_networking_java;

public class Earthquake {
    /**
     * Magnitude of the earthquake
     */
    private double mMagnitude;

    /**
     * Location of the earthquake
     */
    private String mLocation;

    /**
     * Time of the earthquake
     */
    private long mTimeInMilliseconds;

    /**
     * Website URL of the earthquake
     */
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getmUrl() {
        return mUrl;
    }
}


