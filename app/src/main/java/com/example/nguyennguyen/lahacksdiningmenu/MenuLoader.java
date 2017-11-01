package com.example.nguyennguyen.lahacksdiningmenu;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by nguyennguyen on 10/30/17.
 */

public class MenuLoader extends AsyncTaskLoader<ArrayList<JSONObject>> {

    private String mUrl;
    private String LOG_E_TAG = MenuLoader.class.getSimpleName();
    private static final String breakfast = "breakfast";
    private static final String lunch = "lunch";
    private static final String dinner = "dinner";

    public MenuLoader(Context context, String url)
    {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        forceLoad();
    }
    @Override
    public ArrayList<JSONObject> loadInBackground() {

        URL url = createURL(mUrl);

        if(url == null)
            return null;

        String jsonResponse = "";
        try{
            jsonResponse = makeHttpRequest(url) ;
        }
        catch (IOException e)
        {
            Log.e(LOG_E_TAG, "Error with makeHttpRequest" , e);
        }
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject(jsonResponse);
        }catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("jsonresponse", jsonResponse);
        if(jsonObject == null)
            return null;


        ArrayList<JSONObject> result = new ArrayList<>();

        try{
            result.add(jsonObject.getJSONObject(breakfast));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try{
            result.add(jsonObject.getJSONObject(lunch));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try{
            result.add(jsonObject.getJSONObject(dinner));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }
    private String makeHttpRequest (URL url) throws IOException
    {
        String result = "";
        if(url == null)
            return result;

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try{
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            if(httpURLConnection.getResponseCode() == 200)
            {
                inputStream = httpURLConnection.getInputStream();
                result = readFromStream(inputStream);
            }
            else
                Log.e(LOG_E_TAG, "Error In Connecting with" + httpURLConnection.getResponseCode());
        }catch (IOException e) {
            Log.e(LOG_E_TAG, "Error from makeHttpRequest", e);
        }finally {
            if(httpURLConnection != null)
                httpURLConnection.disconnect();
            if(inputStream != null)
                inputStream.close();
        }
        return result;
    }
    private String readFromStream(InputStream inputStream) throws IOException
    {
        StringBuilder response = new StringBuilder();
        if(inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = bufferedReader.readLine();
            while(line != null)
            {
                response.append(line);
                line = bufferedReader.readLine();
            }
        }
        return response.toString();

    }
    private URL createURL(String url)
    {
        if(url.isEmpty())
            return null;
        URL resultURL = null;
        try{
            resultURL = new URL(url);
        }catch (MalformedURLException e)
        {
            Log.e(LOG_E_TAG, "url string is malformed and URL cannot be created" + url, e);
        }
        return resultURL;
    }


}
