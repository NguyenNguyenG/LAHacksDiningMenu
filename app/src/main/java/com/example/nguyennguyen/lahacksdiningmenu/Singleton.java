package com.example.nguyennguyen.lahacksdiningmenu;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by nguyennguyen on 4/2/17.
 */

public class Singleton {
    private static Singleton mInstance = null;
    private ArrayList<ArrayList<ArrayList<String>>> menu = new ArrayList<>();
    private static ProgressDialog dia;

    private Singleton()
    {
        AsyncTask<Void, Void, ArrayList<ArrayList<ArrayList<String>>>> task = new InitTask().execute();
        try {
            task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void setDialog(ProgressDialog dialog)
    {
        dia = dialog;
    }

    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public ArrayList<ArrayList<ArrayList<String>>> getMenu(){
        return this.menu;
    }

    public class InitTask extends AsyncTask<Void, Void, ArrayList<ArrayList<ArrayList<String>>>> {


        @Override
        protected void onPreExecute() {

            dia.show();

        }

        @Override
        protected ArrayList<ArrayList<ArrayList<String>>> doInBackground(Void... params) {
            ArrayList<ArrayList<ArrayList<String>>> finMenu = new ArrayList<>();

            try {
                Document diningPage = Jsoup.connect("http://menu.dining.ucla.edu/Menus/Today").get();
                Elements Menu = diningPage.select("div#main-content");
                int countHeader = -1;
                for (Element temp : Menu.get(0).children()) {

                    if (temp.tagName() == "h2") {
                        countHeader++;
                        finMenu.add(new ArrayList<ArrayList<String>>());
                    }

                    ArrayList<String> holder = new ArrayList<>();
                    if (!temp.select("h3.col-header").isEmpty())
                        holder.add(temp.select("h3.col-header").text());

                    if (!temp.select("ul.sect-list").isEmpty()) {
                        for (Element food : temp.select("ul.sect-list")) {

                            for (Element foodItem : food.select("li.sect-item")) {
                                String special = foodItem.ownText() + "!";
                                holder.add(special);
                                for (Element indivFoodItem : foodItem.select("a.recipelink")) {
                                    holder.add(indivFoodItem.text());
                                }
                            }
                        }
                        finMenu.get(countHeader).add(holder);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(int a = 0; a < finMenu.size(); a++)
            {
                for(int b = 0; b < finMenu.get(a).size(); b++)
                {
                    for(int c = 0; c < finMenu.get(a).get(b).size(); c++)
                    {
                        Log.d("Food",finMenu.get(a).get(b).get(c));
                    }
                }
            }

            return finMenu;
        }
        @Override
        protected void onPostExecute(ArrayList<ArrayList<ArrayList<String>>> result) {
            dia.hide();
            menu = result;

            Log.d("STATUS","FINISHED");
            super.onPostExecute(result);
        }
    }
}