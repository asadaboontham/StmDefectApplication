package com.example.asadaboomtham.stmdefectapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asadaboomtham.stmdefectapplication.ProjectDao.SelectDefect;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public Context mContext;
    public LayoutInflater mInflater;



    public ProjectListView(Context context, ArrayList<String> data,ArrayList<String> data1,ArrayList<String> data2,ArrayList<String> data3){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.data = data;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;


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
//        ViewHolder holder = null;
//        if (convertView == null){
        //load layout
        View v = mInflater.inflate(R.layout.project_list_layout, null);

//        TextView ProjectName = (TextView) v.findViewById(R.id.ProjectNameListview);
//        TextView ProjectCode = (TextView) v.findViewById(R.id.ProjectIDListview);
//        TextView ProjectDay = (TextView) v.findViewById(R.id.ProjectDayListview);
////        TextView
//        ProjectName.setText(data.get(position));
//        ProjectCode.setText(data.get(position));
//        ProjectDay.setText(data.get(position));


        //LinearLayout ll = (LinearLayout) v.findViewById(R.id.ppjlinear);
        // ll.setText(data.get(position));

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ProjectService.class);



        TextView aa = (TextView) v.findViewById(R.id.ProjectNameListview);
        aa.setText(data.get(position));

        TextView pp = (TextView) v.findViewById(R.id.ProjectIDListview);
        pp.setText(data1.get(position));

        TextView gg = (TextView) v.findViewById(R.id.ProjectDayListview);
        gg.setText(data2.get(position));


        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("aa",data3.get(position));
                //ไปดู start activity
                //      Intent intent = new Intent(MainActivity.this.)
                String pj_id = data3.get(position);

                service.select_defect(pj_id).enqueue(new Callback<SelectDefect>() {
                    @Override
                    public void onResponse(Call<SelectDefect> call, Response<SelectDefect> response) {
                        for(int i=0; i<response.body().getSelectDefect().size(); i++){
                            Log.d("pun",response.body().getSelectDefect().get(i).getDfCode());
                        }

                    }

                    @Override
                    public void onFailure(Call<SelectDefect> call, Throwable t) {

                    }
                });

            }
        });




//            holder = new ViewHolder();
//            holder.title1 = (TextView) convertView.findViewById(R.id.ProjectNameListview);
//            holder.title2 = (TextView) convertView.findViewById(R.id.ProjectIDListview);
//            holder.title3 = (TextView) convertView.findViewById(R.id.ProjectDayListview);
//            convertView.setTag(holder);
//        }else {
//            //rebind widget
//            holder = (ViewHolder) convertView.getTag();
//        }

        return v;
    }

//    public class ViewHolder{
//        TextView title1,title2,title3;
//    }
}
