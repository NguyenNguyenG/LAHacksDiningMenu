package com.example.nguyennguyen.lahacksdiningmenu;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class BreakfastDining extends Fragment {

    private ArrayList<String> listDataHeader;
    public BreakfastDining() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayout lin = (LinearLayout) getView().findViewById(R.id.Breakfast);
        JSONObject breakfast = Singleton.getInstance().getMenu("breakfast");
        JSONArray dinningHall = breakfast.names();

        try {

            for (int i = 0; i < dinningHall.length(); i++) {

                JSONObject foodPlace = breakfast.getJSONObject(dinningHall.get(i).toString());
                TextView dinningName = new TextView(getContext());
                dinningName.setText(dinningHall.get(i).toString());
                dinningName.setGravity(Gravity.CENTER);
                dinningName.setTextAppearance(R.style.DinningHallName);
                lin.addView(dinningName);
                for (int j = 0; j < foodPlace.names().length(); j++) {
                    JSONArray array = foodPlace.getJSONArray(foodPlace.names().get(j).toString());
                    TextView station = new TextView(getContext());
                    station.setBackgroundResource(R.drawable.rounded_corner);
                    station.setText(foodPlace.names().get(j).toString());
                    station.setTextAppearance(R.style.Kitchen);
                    station.setPadding(10, 10, 0, 10);
                    lin.addView(station);
                    for(int k = 0; k < array.length(); k++)
                    {
                        TextView foodItems = new TextView(getContext());
                        foodItems.setText(array.getJSONObject(k).getString("name"));
                        foodItems.setTextAppearance(R.style.FoodItems);
                        if (k == array.length() - 1)
                            foodItems.setPadding(60, 10, 0, 50);
                        else
                            foodItems.setPadding(60, 10, 0, 10);

                        lin.addView(foodItems);
                    }
                }
            }
        }catch (JSONException e){
            Log.e("LOG_E", "PARSING JSON", e);}

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_breakfast_dining, container, false);
        return v ;
    }

}
