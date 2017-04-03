package com.example.nguyennguyen.lahacksdiningmenu;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class BreakfastDining extends Fragment {
    private ProgressBar progressBar;
    private ScrollView scrollView;
    private ArrayList<ArrayList<String>> foodItems;
    private ArrayList<String> listDataHeader;
    public BreakfastDining() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("list", (Serializable) foodItems);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            //probably orientation change
            foodItems = (ArrayList<ArrayList<String>>) savedInstanceState.getSerializable("list");

        } else {
            if (foodItems != null) {
                //returning from backstack, data is fine, do nothing
            }
            else
                foodItems = new ArrayList<ArrayList<String>>();
        }
        progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
        scrollView = (ScrollView) getView().findViewById(R.id.BSV);
        new doit().execute();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_breakfast_dining, container, false);
        return v ;
    }
    public class doit extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
            Log.d("item","HERE");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            int count = 0;
            if(!foodItems.isEmpty())
                return null;
            listDataHeader = new ArrayList<>();
            //foodItems = new ArrayList<ArrayList<String>>();
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
                    if(count == 2)
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
            progressBar.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            ArrayList<String> hall = new ArrayList<String>();
            for(String key:listDataHeader)
            {
                hall.add(key);
                Log.d("item", key);
            }




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
            super.onPostExecute(avoid);
        }
    }


}
