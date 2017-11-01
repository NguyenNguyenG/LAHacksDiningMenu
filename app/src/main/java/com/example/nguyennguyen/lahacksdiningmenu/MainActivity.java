package com.example.nguyennguyen.lahacksdiningmenu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.content.Loader;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import android.app.LoaderManager;

public class MainActivity extends Activity implements LoaderManager.LoaderCallbacks<ArrayList<JSONObject>> {
    private Button mCallApiButton;
    private static final String mUrl = "http://bruindining.herokuapp.com/overview?date=";
    private Intent intent;
    private final int Loader_ID = 1;
    ProgressDialog mProgress;

    /**
     * Create the main activity.
     * @param savedInstanceState previously saved instance data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout activityLayout = new LinearLayout(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        activityLayout.setLayoutParams(lp);
        activityLayout.setOrientation(LinearLayout.VERTICAL);
        activityLayout.setPadding(16, 16, 16, 16);

        ViewGroup.LayoutParams tlp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        mCallApiButton = new Button(this);
        mCallApiButton.setText("Click");

        activityLayout.addView(mCallApiButton);

        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Loading Menu ...");

        setContentView(activityLayout);

        intent = new Intent(this, MessageActivity.class);


        mCallApiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallApiButton.setEnabled(false);
                mProgress.show();
                mProgress.setCanceledOnTouchOutside(false);
                getLoaderManager().initLoader(Loader_ID, null, MainActivity.this);
                mCallApiButton.setEnabled(true);

            }
        });
    }

    @Override
    public Loader<ArrayList<JSONObject>> onCreateLoader(int id, Bundle args) {
        return new MenuLoader(getApplicationContext(), mUrl);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<JSONObject>> loader, ArrayList<JSONObject> data) {
        mProgress.dismiss();
        Singleton.getInstance(data);
        startActivity(intent);
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<JSONObject>> loader) {

    }
}