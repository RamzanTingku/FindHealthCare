package com.example.ramzan.findhospital.Pharmecy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ramzan.findhospital.Pharmecy.Model.Pharmecy;
import com.example.ramzan.findhospital.R;

import java.util.List;

public class PharmecyAdapter extends RecyclerView.Adapter<PharmecyAdapter.ViewHolder>{

    private Context context;
    private List<Pharmecy> pharmecies;
    private PharmecyClickListener clickListener;

    public PharmecyAdapter(Context context, List<Pharmecy> pharmecies) {
        this.context = context;
        this.pharmecies = pharmecies;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pharmecy_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Pharmecy pharmecy = pharmecies.get(position);

        if (pharmecy.getPharmecyName() != null) {
            holder.pharmecyNameTV.setText(pharmecy.getPharmecyName().toString());
        }

        if (pharmecy.getAddress() != null) {
            holder.addressTV.setText(pharmecy.getAddress().toString());
        }

        if (pharmecy.getLink() != null) {
            holder.linkTV.setText(pharmecy.getLink().toString());
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPharmecyItemClick(pharmecy, v);
            }
        };

        holder.linkTV.setOnClickListener(listener);

    }

    @Override
    public int getItemCount() {
        return pharmecies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pharmecyNameTV, addressTV, linkTV;

        public ViewHolder(View itemView) {
            super(itemView);

            pharmecyNameTV = itemView.findViewById(R.id.tv_pharmecy);
            addressTV = itemView.findViewById(R.id.tv_address);
            linkTV = itemView.findViewById(R.id.tv_link);

        }
    }


    public PharmecyClickListener getOnItemClickListener() {
        return clickListener;
    }

    public void setOnItemClickListener(PharmecyClickListener clickListener) {
        this.clickListener = clickListener;
    }
}