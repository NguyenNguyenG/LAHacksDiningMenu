package com.example.nguyennguyen.lahacksdiningmenu;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by nguyennguyen on 4/2/17.
 */

public class Singleton {
    private static Singleton mInstance = null;
    private static ArrayList<JSONObject> menu = new ArrayList<>();
    private Singleton()
    {

    }
    public JSONObject getMenu(String query)
    {
        if(query == "breakfast")
        {
            if(menu.get(0).length() == 0)
                return menu.get(1);
            else
                return menu.get(0);
        }
        else if(query == "lunch")
            return menu.get(1);
        else
            return menu.get(2);
    }

    public static Singleton getInstance(ArrayList<JSONObject> men){
        if(mInstance == null)
        {
            mInstance = new Singleton();
            menu = men;
        }
        return mInstance;
    }
    public static Singleton getInstance()
    {
        return mInstance;
    }
}
