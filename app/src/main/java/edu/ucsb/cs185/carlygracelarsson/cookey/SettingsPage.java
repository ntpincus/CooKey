package edu.ucsb.cs185.carlygracelarsson.cookey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by carlygracelarsson on 6/3/16.
 */
public class SettingsPage extends AppCompatActivity {


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_settings);

    }
}