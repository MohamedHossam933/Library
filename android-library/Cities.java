package com.mkandeel.countryandcity;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cities {
    private Context mContext;
    private Cities cities = null;

    public Cities(Context context){
        this.mContext = context;
    }

    public Cities getInstance(Context context){
        if (cities == null) {
            cities = new Cities(context);
        }
        return cities;
    }

    public ArrayList<String> getCitiesByCountryName(String countryName){
        Countries countries = new Countries();
        String countryCode = countries.getInstance().getCountryCode(countryName);
        ArrayList<String> cities = new ArrayList<>(getCitiesByCountryCode(countryCode));
        Collections.sort(cities);
        return cities;
    }

    private List<String> getCitiesByCountryCode(String countryCode){
        Countries countries = new Countries();
        Integer arr = countries.getInstance().getCityArrayReference(countryCode);
        String[] citiesArray = mContext.getResources().getStringArray(arr);
        return Arrays.asList(citiesArray);
    }
}