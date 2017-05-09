package com.example.asadaboomtham.stmdefectapplication;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.asadaboomtham.stmdefectapplication.ProjectDao.SelectProject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectActivity extends AppCompatActivity {
    private LinearLayout stm_line;

    private ProjectService service;

    private ListView jsonlistView;
    private ListView listview;
    private ListView listview1;
    private ArrayList<String> exData;
    private ArrayList<String> data1;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ProjectService.class);

        service.select_project().enqueue(new Callback<SelectProject>() {
            @Override
            public void onResponse(Call<SelectProject> call, Response<SelectProject> response) {

                //         Log.d("RESPONSE",response.body().getDefect().get(3).getPjCode());

                listview = (ListView) findViewById(R.id.ProjectListview);
                // listview1 = (ListView) findViewById(R.id.aaaa);

                ArrayList<String> data = new ArrayList<>();
                ArrayList<String> data1 = new ArrayList<>();
                ArrayList<String> data2 = new ArrayList<>();
                ArrayList<String> data3 = new ArrayList<>();

                for(int i=0; i<response.body().getDefect().size(); i++){
                    data.add(response.body().getDefect().get(i).getPjName());
                    data1.add(response.body().getDefect().get(i).getPjCode());
                    data2.add(response.body().getDefect().get(i).getPjStartDate());
                    data3.add(response.body().getDefect().get(i).getPjId());
                }

                listview.setAdapter(new ProjectListView(getApplicationContext(), data,data1,data2,data3));
                // listview.setAdapter(new ProjectListView(getApplicationContext(), data1));

            }

            @Override
            public void onFailure(Call<SelectProject> call, Throwable t) {
                Log.d("RESPONSE","Error");
            }
        });


//
//
////        listview.setAdapter(new ProjectListView(getApplicationContext()));
//      //  listview.setAdapter(new EfficientAdapter(getApplicationContext(),data));
//     //   listview.setAdapter(new ProjectListView (getApplicationContext()));
//
        exData = new ArrayList<String>();
////        exData.add("Test1");
////        exData.add("Test2");
////        exData.add("Test3");
////        exData.add("Test4");
////        exData.add("Test5");
//
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute(); //
                progressDialog = new ProgressDialog(ProjectActivity.this);
                progressDialog.setCancelable(false); //ไม่ให้กดยกเลิก
                progressDialog.setMessage("Downloading....");
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    URL url = new URL("http://10.51.4.17/TSP57/ISERL/application/views/stm/defect_log/android/service_project.php");

                    URLConnection urlConnection = url.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    httpURLConnection.setAllowUserInteraction(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    //ส่งแบบ input stream
                    InputStream inputStream = null;
                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
                        inputStream = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
                            "iso-8859-1"), 8); //ภาษาไทย

                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;

                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    } //วนจนหมดข้อมูล
                    inputStream.close(); //
                    Log.d("JSON Result", stringBuilder.toString()); //text json

                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    JSONArray exArray = jsonObject.getJSONArray("defect");

                    for (int i = 0; i < exArray.length(); i++) {
                        JSONObject jsonObj = exArray.getJSONObject(i);
                        exData.add(jsonObj.getString("pj_name"));
                        exData.add(jsonObj.getString("pj_code"));
                        exData.add(jsonObj.getString("pj_end_date"));
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
////                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout
////                        .simple_list_item_1, android.R.id.text1 ,exData);
//
                progressDialog.dismiss(); //ให้หยุดหมุน ไรไม่รู้
            }
        }.execute();
    }
}
