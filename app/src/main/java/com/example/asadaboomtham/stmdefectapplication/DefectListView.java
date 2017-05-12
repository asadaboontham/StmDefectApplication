package com.example.asadaboomtham.stmdefectapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nutty on 9/5/2560.
 */

public class DefectListView extends BaseAdapter {
    private final ArrayList<String> data;
    private final ArrayList<String> data1;

    public  Context mContext;
    public LayoutInflater mInflater;



    public DefectListView(Context context, ArrayList<String> data, ArrayList<String> data1){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.data = data;
        this.data1 = data1;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.defect_list_layout, null);

        TextView aa = (TextView) v.findViewById(R.id.df_id);
        aa.setText(data.get(position));

        TextView bb = (TextView) v.findViewById(R.id.df_dfs_id);
        bb.setText(data1.get(position));

        return v;
    }
}
