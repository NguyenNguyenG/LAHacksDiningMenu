package com.example.nguyennguyen.lahacksdiningmenu;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LunchDining extends Fragment {

    private ArrayList<String> listDataHeader;
    private ArrayList<ArrayList<String>> foodItems;
    public LunchDining() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new doit().execute();
        return inflater.inflate(R.layout.fragment_lunch_dining, container, false);
    }



    public class doit extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            int count = 0;
            listDataHeader = new ArrayList<>();
            foodItems = new ArrayList<ArrayList<String>>();
            int i = 0;
            try
            {
                Document d = Jsoup.connect("http://menu.dining.ucla.edu/Menus/2017-04-03").get();
                Elements e = d.select("div#main-content");
                for (Element ele : e.select("div.menu-block")) {
                    listDataHeader.add(ele.select("h3.col-header").text());
                    //Log.d("item", ele.select("h3.col-header").text());
                    ArrayList<String> foodie = new ArrayList<>();
                    for (Element food : ele.select("ul.sect-list")) {

                        for (Element foodItem : food.select("li.sect-item")) {

                            for (Element indivFoodItem : foodItem.select("a.recipelink")) {
                                foodie.add(indivFoodItem.text());
                            }
                        }
                    }
                    foodItems.add(foodie);
                    i++;
                    count++;
                    if(count == 6)
                        return null;
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void avoid)
        {
            ArrayList<String> hall = new ArrayList<String>();
            for(String key:listDataHeader)
            {
                hall.add(key);
                //Log.d("item", key);
            }

            TextView temp = (TextView) getView().findViewById(R.id.EK1);
            temp.setText(foodItems.get(2).get(0));
            temp = (TextView) getView() .findViewById(R.id.EK2);
            temp.setText(foodItems.get(2).get(1));
            temp = (TextView)getView().findViewById(R.id.EuroKit1);
            temp.setText(foodItems.get(2).get(2));
            temp = (TextView)getView().findViewById(R.id.EuroKit2);
            temp.setText(foodItems.get(2).get(3));
            temp = (TextView)getView().findViewById(R.id.PO1);
            temp.setText(foodItems.get(2).get(4));


            temp = (TextView)getView().findViewById(R.id.fresh1);
            temp.setText(foodItems.get(3).get(0));
            temp = (TextView)getView().findViewById(R.id.fresh2);
            temp.setText(foodItems.get(3).get(1));
            temp = (TextView)getView().findViewById(R.id.harvest1);
            temp.setText(foodItems.get(3).get(2));
            temp = (TextView)getView().findViewById(R.id.harvest2);
            temp.setText(foodItems.get(3).get(3));
            temp = (TextView)getView().findViewById(R.id.harvest3);
            temp.setText(foodItems.get(3).get(4));
            temp = (TextView)getView().findViewById(R.id.harvest4);
            temp.setText(foodItems.get(3).get(5));
            temp = (TextView)getView().findViewById(R.id.harvest5);
            temp.setText(foodItems.get(3).get(6));
            temp = (TextView)getView().findViewById(R.id.harvest6);
            temp.setText(foodItems.get(3).get(7));
            temp = (TextView)getView().findViewById(R.id.stone1);
            temp.setText(foodItems.get(3).get(8));
            temp = (TextView)getView().findViewById(R.id.stone2);
            temp.setText(foodItems.get(3).get(9));
            temp = (TextView)getView().findViewById(R.id.grill1);
            temp.setText(foodItems.get(3).get(10));
            temp = (TextView)getView().findViewById(R.id.grill2);
            temp.setText(foodItems.get(3).get(11));
            temp = (TextView)getView().findViewById(R.id.grill3);
            temp.setText(foodItems.get(3).get(12));
            temp = (TextView)getView().findViewById(R.id.grill4);
            temp.setText(foodItems.get(3).get(13));




            temp = (TextView)getView().findViewById(R.id.front1);
            temp.setText(foodItems.get(4).get(0));
            temp = (TextView)getView().findViewById(R.id.front2);
            temp.setText(foodItems.get(4).get(1));
            temp = (TextView)getView().findViewById(R.id.kitchen1);
            temp.setText(foodItems.get(4).get(2));
            temp = (TextView)getView().findViewById(R.id.kitchen2);
            temp.setText(foodItems.get(4).get(3));
            temp = (TextView)getView().findViewById(R.id.pizzeria1);
            temp.setText(foodItems.get(4).get(4));
            temp = (TextView)getView().findViewById(R.id.thegrill1);
            temp.setText(foodItems.get(4).get(5));
            temp = (TextView)getView().findViewById(R.id.thegrill2);
            temp.setText(foodItems.get(4).get(6));


            temp = (TextView)getView().findViewById(R.id.BW1);
            temp.setText(foodItems.get(5).get(0));
            temp = (TextView)getView().findViewById(R.id.BW2);
            temp.setText(foodItems.get(5).get(1));
            temp = (TextView)getView().findViewById(R.id.SK1);
            temp.setText(foodItems.get(5).get(2));
            temp = (TextView)getView().findViewById(R.id.SK2);
            temp.setText(foodItems.get(5).get(3));
            temp = (TextView)getView().findViewById(R.id.SO1);
            temp.setText(foodItems.get(5).get(4));
            temp = (TextView)getView().findViewById(R.id.SO2);
            temp.setText(foodItems.get(5).get(5));
            temp = (TextView)getView().findViewById(R.id.IG1);
            temp.setText(foodItems.get(5).get(6));
            temp = (TextView)getView().findViewById(R.id.IG2);
            temp.setText(foodItems.get(5).get(7));
            super.onPostExecute(avoid);
        }
    }
}
