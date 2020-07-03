package com.nya.fgopedia.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.nya.fgopedia.R;

public class idClassAdapter extends RecyclerView.Adapter<idClassAdapter.ViewHolder> {
    private static final String TAG = "idClassAdapter";

    private int[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView icon;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getPosition() + " clicked.");
                }
            });
            icon = (ImageView) v.findViewById(R.id.classServant);
        }
        public ImageView getImageView() {
            return icon;
        }
    }

    public idClassAdapter (int[] dataSet) {
        this.mDataSet = dataSet;
    }

    @Override
    public idClassAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_class_servant, viewGroup, false);
        return new idClassAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(idClassAdapter.ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        viewHolder.getImageView().setImageResource(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

}
