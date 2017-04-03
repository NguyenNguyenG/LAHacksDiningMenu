package com.example.nguyennguyen.lahacksdiningmenu;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
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

        ArrayList<ArrayList<String>> foodItems = Singleton.getInstance().getMenu();
        TextView temp = (TextView) getView().findViewById(R.id.fresh1);
        temp.setText(foodItems.get(0).get(0));

        temp = (TextView) getView() .findViewById(R.id.fresh2);
        temp.setText(foodItems.get(0).get(1));

        temp = (TextView)getView().findViewById(R.id.harvest1);
        temp.setText(foodItems.get(0).get(2));

        temp = (TextView)getView().findViewById(R.id.harvest2);
        temp.setText(foodItems.get(0).get(3));

        temp = (TextView)getView().findViewById(R.id.harvest3);
        temp.setText(foodItems.get(0).get(4));

        temp = (TextView)getView().findViewById(R.id.harvest4);
        temp.setText(foodItems.get(0).get(5));

        temp = (TextView)getView().findViewById(R.id.stone1);
        temp.setText(foodItems.get(0).get(6));

        temp = (TextView)getView().findViewById(R.id.grill1);
        temp.setText(foodItems.get(0).get(7));

        temp = (TextView)getView().findViewById(R.id.front1);
        temp.setText(foodItems.get(1).get(0));

        temp = (TextView)getView().findViewById(R.id.front2);
        temp.setText(foodItems.get(1).get(1));

        temp = (TextView)getView().findViewById(R.id.front3);
        temp.setText(foodItems.get(1).get(2));

        temp = (TextView)getView().findViewById(R.id.kitchen1);
        temp.setText(foodItems.get(1).get(3));

        temp = (TextView)getView().findViewById(R.id.kitchen2);
        temp.setText(foodItems.get(1).get(4));

        temp = (TextView)getView().findViewById(R.id.kitchen3);
        temp.setText(foodItems.get(1).get(5));

        temp = (TextView)getView().findViewById(R.id.kitchen4);
        temp.setText(foodItems.get(1).get(6));

        temp = (TextView)getView().findViewById(R.id.kitchen5);
        temp.setText(foodItems.get(1).get(7));

        temp = (TextView)getView().findViewById(R.id.pizzeria1);
        temp.setText(foodItems.get(1).get(8));

        temp = (TextView)getView().findViewById(R.id.thegrill1);
        temp.setText(foodItems.get(1).get(9));

        temp = (TextView)getView().findViewById(R.id.thegrill2);
        temp.setText(foodItems.get(1).get(10));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_breakfast_dining, container, false);
        return v ;
    }

}
