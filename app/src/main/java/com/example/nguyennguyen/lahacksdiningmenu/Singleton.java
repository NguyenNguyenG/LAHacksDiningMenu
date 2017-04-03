package com.example.nguyennguyen.lahacksdiningmenu;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

/**
 * Created by nguyennguyen on 4/2/17.
 */

public class Singleton {
    private static Singleton mInstance = null;
    private ArrayList<ArrayList<String>> menu ;

    private Singleton()
    {
        new InitTask().execute();
    }

    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public ArrayList<ArrayList<String>> getMenu(){
        return this.menu;
    }

    public class InitTask extends AsyncTask<Void, Void, ArrayList<ArrayList<String>>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected ArrayList<ArrayList<String>> doInBackground(Void... params) {
            ArrayList<ArrayList<String>> foodItems = new ArrayList<>();
            ArrayList<String> listDataHeader = new ArrayList<>();
            //foodItems = new ArrayList<ArrayList<String>>();
            int i = 0;
            try
            {
                Document d = Jsoup.connect("http://menu.dining.ucla.edu/Menus/Today").get();
                Elements e = d.select("div#main-content");
                for (Element ele : e.select("div.menu-block")) {
                    listDataHeader.add(ele.select("h3.col-header").text());
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
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            return foodItems;
        }
        @Override
        protected void onPostExecute(ArrayList<ArrayList<String>> result) {
            menu = result;
            Log.d("STATUS","FINISHED");
            super.onPostExecute(result);
        }
    }
}