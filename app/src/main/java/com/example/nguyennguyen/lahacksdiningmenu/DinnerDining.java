package com.example.nguyennguyen.lahacksdiningmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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

        ArrayList<ArrayList<ArrayList<String>>> foodItems = Singleton.getInstance().getMenu();
        LinearLayout lin = (LinearLayout) getView().findViewById(R.id.Dinner);

        int target = 2;
        if(foodItems.size() == 2)
            target = 1;


        if(foodItems.size() > 1)
        {
            for(int i = 0; i < foodItems.get(target).size();i++) {
                for(int j = 0; j < foodItems.get(target).get(i).size(); j++) {
                    TextView text = new TextView(getContext());
                    int length = foodItems.get(target).get(i).get(j).length();
                    if(j == 0) {
                        text.setText(foodItems.get(target).get(i).get(j));
                        text.setGravity(Gravity.CENTER);
                        text.setTextAppearance(R.style.DinningHallName);
                    }
                    else if(foodItems.get(target).get(i).get(j).charAt(length-1)=='!')
                    {
                        text.setBackgroundResource(R.drawable.rounded_corner);
                        text.setText(foodItems.get(target).get(i).get(j).substring(0,length-1));
                        text.setTextAppearance(R.style.Kitchen);
                        text.setPadding(10,10,0,10);
                    }
                    else
                    {
                        text.setText(foodItems.get(target).get(i).get(j));
                        text.setTextAppearance(R.style.FoodItems);
                        if(j == foodItems.get(target).get(i).size() - 1)
                            text.setPadding(60,10,0,50);
                        else
                            text.setPadding(60,10,0,10);
                    }
                    lin.addView(text);
                }

            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_dinner_dining, container, false);
    }


}
