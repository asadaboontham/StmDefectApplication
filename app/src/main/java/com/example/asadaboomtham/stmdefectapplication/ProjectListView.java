package com.example.asadaboomtham.stmdefectapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nutty on 9/5/2560.
 */

public class ProjectListView extends BaseAdapter {
    private LinearLayout stm_line;

    private ProjectService service;
    private final ArrayList<String> data;
    private final ArrayList<String> data1;
    private final ArrayList<String> data2;
    private final ArrayList<String> data3;
    private final ArrayList<String> data4;

    public  Context mContext;
    public LayoutInflater mInflater;



    public ProjectListView(Context context, ArrayList<String> data,ArrayList<String> data1,ArrayList<String> data2,ArrayList<String> data3,ArrayList<String> data4){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.data = data;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
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
        View v = mInflater.inflate(R.layout.project_list_layout, null);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ProjectService.class);
        LinearLayout kk =(LinearLayout) v.findViewById(R.id.ppjlinear);
        TextView aa = (TextView) v.findViewById(R.id.ProjectNameListview);
        aa.setText(data.get(position));

        TextView pp = (TextView) v.findViewById(R.id.ProjectIDListview);
        pp.setText(data1.get(position));

        TextView gg = (TextView) v.findViewById(R.id.ProjectDayListview);
        gg.setText(data2.get(position));



        kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ProjectDetailActivity.class);
                intent.putExtra("project", data1.get(position));
                intent.putExtra("name", data.get(position));
                intent.putExtra("pst", data4.get(position));
                intent.putExtra("pj_id", data3.get(position));
                mContext.startActivity(intent);

                Log.d("xxx",data3.get(position));

                //ไปดู start activity

            }
        });


        return v;
    }
}
