package com.example.ramzan.findhospital.Pharmecy;


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
import com.example.ramzan.findhospital.Pharmecy.Adapter.PharmecyAdapter;
import com.example.ramzan.findhospital.Pharmecy.Adapter.PharmecyClickListener;
import com.example.ramzan.findhospital.Pharmecy.Model.Pharmecy;
import com.example.ramzan.findhospital.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PharmecyFragment extends Fragment {

    View view;
    RecyclerView pharmecyListView;
    PharmecyAdapter adapter;
    List<Pharmecy> pharmecies;

    public PharmecyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pharmecy, container, false);

        pharmecyListView = view.findViewById(R.id.listview_pharmecy);
        pharmecies = new ArrayList<>();
        getPharmecies();
        setRecyclerview();

        return view;
    }

    private void setRecyclerview() {
        adapter = new PharmecyAdapter(getActivity(), pharmecies);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setReverseLayout(false);
        llm.setStackFromEnd(false);
        pharmecyListView.setHasFixedSize(true);
        pharmecyListView.setLayoutManager(llm);
        pharmecyListView.setNestedScrollingEnabled(false);
        pharmecyListView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PharmecyClickListener() {
            @Override
            public void onPharmecyItemClick(Pharmecy item, View view) {
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

    public List<Pharmecy> getPharmecies() {

        for (int i = 0; i < 10; i++) {
            pharmecies.add(new Pharmecy("Pharmecy "+(i+1), "Address "+(i+1), "www.google.com"));
        }

        return pharmecies;
    }

}
