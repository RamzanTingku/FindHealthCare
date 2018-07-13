package com.example.ramzan.findhospital.Hospital.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramzan.findhospital.Hospital.Model.Hospital;
import com.example.ramzan.findhospital.R;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.ViewHolder>{

    private Context context;
    private List<Hospital> hospitals;
    private HospitalClickListener clickListener;

    public HospitalAdapter(Context context, List<Hospital> hospitals) {
        this.context = context;
        this.hospitals = hospitals;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hospital_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Hospital hospital = hospitals.get(position);

        if (hospital.getHospitalName() != null) {
            holder.hospitalNameTV.setText(hospital.getHospitalName().toString());
        }

        if (hospital.getAddress() != null) {
            holder.addressTV.setText(hospital.getAddress().toString());
        }

        if (hospital.getLink() != null) {
            holder.linkTV.setText(hospital.getLink().toString());
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onHospitalItemClick(hospital, v);
            }
        };

        holder.linkTV.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hospitalNameTV, addressTV, linkTV;

        public ViewHolder(View itemView) {
            super(itemView);

            hospitalNameTV = itemView.findViewById(R.id.tv_hospital);
            addressTV = itemView.findViewById(R.id.tv_address);
            linkTV = itemView.findViewById(R.id.tv_link);

        }
    }


    public HospitalClickListener getOnItemClickListener() {
        return clickListener;
    }

    public void setOnItemClickListener(HospitalClickListener clickListener) {
        this.clickListener = clickListener;
    }
}