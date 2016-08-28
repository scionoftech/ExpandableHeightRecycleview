package com.scionoftech.sample.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scionoftech.sample.R;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by kshediv on 26/10/15.
 */
public class CountryListAdapter extends RecyclerView
        .Adapter<CountryListAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private JSONArray mDataset;
    private static MyClickListener myClickListener;
    private JSONArray item;
    // Allows to remember the last item shown on screen
    private Context context;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView item;
        //  RatingBar ratingBar;

        public DataObjectHolder(View itemView) {
            super(itemView);

            item = (TextView) itemView.findViewById(R.id.item);
            //  ratingBar = (RatingBar) itemView.findViewById(R.id.rating);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getLayoutPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public CountryListAdapter(Context c, JSONArray myDataset) {
        mDataset = myDataset;
        item = myDataset;
        context = c;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, final int position) {


    }

    public void addItem(JSONObject dataObj, int index) {
        mDataset.put(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        // mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.length();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
