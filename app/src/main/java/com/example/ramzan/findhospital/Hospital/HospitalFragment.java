package com.example.ramzan.findhospital.Hospital;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ramzan.findhospital.Hospital.Adapter.HospitalAdapter;
import com.example.ramzan.findhospital.Hospital.Adapter.HospitalClickListener;
import com.example.ramzan.findhospital.Hospital.Model.Hospital;
import com.example.ramzan.findhospital.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalFragment extends Fragment {

    View view;
    RecyclerView hospitalListView;
    HospitalAdapter adapter;
    List<Hospital>hospitals;


    public HospitalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hospital, container, false);

        hospitalListView = view.findViewById(R.id.listview_hospital);
        hospitals = new ArrayList<>();
        getHospitals();
        setRecyclerview();

        return view;
    }

    private void setRecyclerview() {
        adapter = new HospitalAdapter(getActivity(), hospitals);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setReverseLayout(false);
        llm.setStackFromEnd(false);
        hospitalListView.setHasFixedSize(true);
        hospitalListView.setLayoutManager(llm);
        hospitalListView.setNestedScrollingEnabled(false);
        hospitalListView.setAdapter(adapter);

        adapter.setOnItemClickListener(new HospitalClickListener() {
            @Override
            public void onHospitalItemClick(Hospital item, View view) {

                if (view.getId() == R.id.tv_link){
                    String url = "http://www.google.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }else {
                    Toast.makeText(getActivity(), "Not Clickable", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public List<Hospital> getHospitals() {

        for (int i = 0; i < 10; i++) {
            hospitals.add(new Hospital("Hospital "+(i+1), "Address "+(i+1), "www.google.com"));
        }

        return hospitals;
    }
}
