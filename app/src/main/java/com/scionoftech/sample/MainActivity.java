package com.scionoftech.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Locale;

import scionoftech.library.ExpandableHeightRecycleview;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView.Adapter mAdapter;

        ExpandableHeightRecycleview mRecyclerView = (ExpandableHeightRecycleview) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemDecoration itemDecoration =
                new HorizontalDividerItemDecoration.Builder(this).margin(0, 0).build();
        mRecyclerView.addItemDecoration(itemDecoration);

        final JSONArray countries = Get_Countries();
        mAdapter = new CountryListAdapter(countries);
        mRecyclerView.setAdapter(mAdapter);

        ((CountryListAdapter) mAdapter).setOnItemClickListener(new CountryListAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                try {
                    Toast.makeText(MainActivity.this, countries.get(position).toString(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    private JSONArray Get_Countries() {
        JSONArray c = new JSONArray();

        String[] isoCountryCodes = Locale.getISOCountries();
        for (String iso : isoCountryCodes) {
            c.put(new Locale("", iso).getDisplayCountry());
        }

        return c;
    }

}
