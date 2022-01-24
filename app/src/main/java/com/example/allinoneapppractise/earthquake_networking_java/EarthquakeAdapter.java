package com.example.allinoneapppractise.earthquake_networking_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.allinoneapppractise.R;

import java.util.List;

/**
 * An {@link EarthquakeAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link Earthquake} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }
    /**
      Returns a list item view that displays information about the earthquake at the given position
      in the list of earthquakes.
     */

    /*@NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View listItemView = convertView;
       if(listItemView == null){
           listItemView = LayoutInflater.from(getContext()).inflate(
                   R.layout.earthquake_list_item, parent, false);
       }

       Earthquake currentEarthQuake = getItem(position);
       TextView magnitudeView = listItemView.findViewById(R.id.magnitude);




    }*/
}
