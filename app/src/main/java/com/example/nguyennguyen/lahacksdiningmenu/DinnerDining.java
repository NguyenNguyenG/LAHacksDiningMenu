package com.example.nguyennguyen.lahacksdiningmenu;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DinnerDining extends Fragment {

    public DinnerDining() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<ArrayList<String>> foodItems = Singleton.getInstance().getMenu();

        TextView temp = (TextView) getView().findViewById(R.id.EK1);
        temp.setText(foodItems.get(6).get(0));
        temp = (TextView) getView().findViewById(R.id.EK2);
        temp.setText(foodItems.get(6).get(1));
        temp = (TextView)getView().findViewById(R.id.EuroKit1);
        temp.setText(foodItems.get(6).get(2));
        temp = (TextView)getView().findViewById(R.id.PO1);
        temp.setText(foodItems.get(6).get(3));
        temp = (TextView)getView().findViewById(R.id.CovelG1);
        temp.setText(foodItems.get(6).get(4));


        temp = (TextView)getView().findViewById(R.id.fresh1);
        temp.setText(foodItems.get(7).get(0));
        temp = (TextView)getView().findViewById(R.id.fresh2);
        temp.setText(foodItems.get(7).get(1));
        temp = (TextView)getView().findViewById(R.id.harvest1);
        temp.setText(foodItems.get(7).get(2));
        temp = (TextView)getView().findViewById(R.id.harvest2);
        temp.setText(foodItems.get(7).get(3));
        temp = (TextView)getView().findViewById(R.id.stone1);
        temp.setText(foodItems.get(7).get(4));
        temp = (TextView)getView().findViewById(R.id.stone2);
        temp.setText(foodItems.get(7).get(5));
        temp = (TextView)getView().findViewById(R.id.grill1);
        temp.setText(foodItems.get(7).get(6));
        temp = (TextView)getView().findViewById(R.id.grill2);
        temp.setText(foodItems.get(7).get(7));
        temp = (TextView)getView().findViewById(R.id.grill3);
        temp.setText(foodItems.get(7).get(8));




        temp = (TextView)getView().findViewById(R.id.front1);
        temp.setText(foodItems.get(8).get(0));
        temp = (TextView)getView().findViewById(R.id.front2);
        temp.setText(foodItems.get(8).get(1));
        temp = (TextView)getView().findViewById(R.id.kitchen1);
        temp.setText(foodItems.get(8).get(2));
        temp = (TextView)getView().findViewById(R.id.kitchen2);
        temp.setText(foodItems.get(8).get(3));
        temp = (TextView)getView().findViewById(R.id.pizzeria1);
        temp.setText(foodItems.get(8).get(4));
        temp = (TextView)getView().findViewById(R.id.thegrill1);
        temp.setText(foodItems.get(8).get(5));
        temp = (TextView)getView().findViewById(R.id.thegrill2);
        temp.setText(foodItems.get(8).get(6));


        temp = (TextView)getView().findViewById(R.id.BW1);
        temp.setText(foodItems.get(9).get(0));
        temp = (TextView)getView().findViewById(R.id.BW2);
        temp.setText(foodItems.get(9).get(1));
        temp = (TextView)getView().findViewById(R.id.SK1);
        temp.setText(foodItems.get(9).get(2));
        temp = (TextView)getView().findViewById(R.id.SK2);
        temp.setText(foodItems.get(9).get(3));
        temp = (TextView)getView().findViewById(R.id.SO1);
        temp.setText(foodItems.get(9).get(4));
        temp = (TextView)getView().findViewById(R.id.SO2);
        temp.setText(foodItems.get(9).get(5));
        temp = (TextView)getView().findViewById(R.id.IG1);
        temp.setText(foodItems.get(9).get(6));
        temp = (TextView)getView().findViewById(R.id.IG2);
        temp.setText(foodItems.get(9).get(7));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_dinner_dining, container, false);
    }


}
