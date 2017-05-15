package com.example.asadaboomtham.stmdefectapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.asadaboomtham.stmdefectapplication.ProjectDao.DefectAllPr;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Page2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ProjectService service;
    public View v;

    private OnFragmentInteractionListener mListener;

    public Page2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page2.
     */
    // TODO: Rename and change types and number of parameters
    public static Page2 newInstance(String param1, String param2) {
        Page2 fragment = new Page2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page2, container, false);
        v = view;

        MainFragment activity = (MainFragment) getActivity();
        String pj_id = activity.ProjectId();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ProjectService.class);

        service.defect_all_pr(pj_id).enqueue(new Callback<DefectAllPr>() {
            @Override
            public void onResponse(Call<DefectAllPr> call, Response<DefectAllPr> response) {
                Log.d("pun1", response.body().getDefectPr().get(0).getLow());

                BarChart chart = (BarChart) v.findViewById(R.id.BarchartDF);
                final ArrayList<BarEntry> entries = new ArrayList<>();

                int low = Integer.parseInt(response.body().getDefectPr().get(0).getLow());
                int mediem = Integer.parseInt(response.body().getDefectPr().get(1).getMediem());
                int high = Integer.parseInt(response.body().getDefectPr().get(2).getHigh());
                int urgent = Integer.parseInt(response.body().getDefectPr().get(3).getUrgent());

                entries.add(new BarEntry(1, low));
                entries.add(new BarEntry(2, mediem));
                entries.add(new BarEntry(3, high));
                entries.add(new BarEntry(4, urgent));

                BarDataSet dataset = new BarDataSet(entries, "#");
                dataset.setValueTextSize(8);
                dataset.setColors(ColorTemplate.COLORFUL_COLORS); // set the color

                ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                dataSets.add(dataset);

                BarData data = new BarData(dataSets);
                chart.setData(data);  // set data on chart.
            }

            @Override
            public void onFailure(Call<DefectAllPr> call, Throwable t) {

            }
        });

        //return inflater.inflate(R.layout.fragment_page2, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
