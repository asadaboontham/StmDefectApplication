package com.example.asadaboomtham.stmdefectapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nutty on 9/5/2560.
 */

public class DefectListView extends BaseAdapter {
    private final ArrayList<String> df_code;
    private final ArrayList<String> dfs_id;
    private final ArrayList<String> df_description;
    private final ArrayList<String> df_dft_id;
    private final ArrayList<String> df_sv_id;
    private final ArrayList<String> df_pr_id;
    private final ArrayList<String> df_fixed_person;
    private final ArrayList<String> df_module;
    private final ArrayList<String> df_step;
    private final ArrayList<String> df_reference;


    public  Context mContext;
    public LayoutInflater mInflater;



    public DefectListView(Context context,
                          ArrayList<String> df_code,
                          ArrayList<String> dfs_id,
                          ArrayList<String> df_description,
                          ArrayList<String> df_dft_id,
                          ArrayList<String> df_sv_id,
                          ArrayList<String> df_pr_id,
                          ArrayList<String> df_fixed_person,
                          ArrayList<String> df_module,
                          ArrayList<String> df_step,
                          ArrayList<String> df_reference){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.df_code = df_code;
        this.dfs_id = dfs_id;
        this.df_description = df_description;
        this.df_dft_id = df_dft_id;
        this.df_sv_id = df_sv_id;
        this.df_pr_id = df_pr_id;
        this.df_fixed_person = df_fixed_person;
        this.df_module = df_module;
        this.df_step = df_step;
        this.df_reference = df_reference;
    }

    @Override
    public int getCount() {
        return df_code.size();
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
        aa.setText(df_code.get(position));

        TextView bb = (TextView) v.findViewById(R.id.df_dfs_id);
        bb.setText(dfs_id.get(position));

        LinearLayout kk =(LinearLayout) v.findViewById(R.id.dflinear);
        kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DefectLogDetailActivity.class);
                intent.putExtra("df_code", df_code.get(position));
                intent.putExtra("dfs_id", dfs_id.get(position));
                intent.putExtra("df_description", df_description.get(position));
                intent.putExtra("df_dft_id", df_dft_id.get(position));
                intent.putExtra("df_sv_id", df_sv_id.get(position));
                intent.putExtra("df_pr_id", df_pr_id.get(position));
                intent.putExtra("df_fixed_person", df_fixed_person.get(position));
                intent.putExtra("df_module", df_module.get(position));
                intent.putExtra("df_step", df_step.get(position));
                intent.putExtra("df_reference", df_reference.get(position));
                mContext.startActivity(intent);

             //   Log.d("dfs_df_fixed_personid",dfs_df_fixed_personid.get(position));

                //ไปดู start activity

            }
        });

        return v;
    }
}
