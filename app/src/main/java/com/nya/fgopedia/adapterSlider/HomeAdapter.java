package com.nya.fgopedia.adapterSlider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nya.fgopedia.R;
import com.nya.fgopedia.ui.home.News;
import com.squareup.picasso.Picasso;

public class HomeAdapter extends FirebaseRecyclerAdapter<News, HomeAdapter.HomeViewHolder> {

    public HomeAdapter(@NonNull FirebaseRecyclerOptions<News> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HomeViewHolder holder, int position, @NonNull News model) {
        holder.tanggal.setText(model.getTanggal());
        holder.judul.setText(model.getJudul());
        Picasso.get().load(model.getBanner()).into(holder.banner);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news,parent,false);

        return new HomeViewHolder(view);
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        TextView judul, tanggal;
        ImageView banner;

        public HomeViewHolder(View itemView){
            super(itemView);

            judul = itemView.findViewById(R.id.judul_news);
            tanggal = itemView.findViewById(R.id.tgl);
            banner = itemView.findViewById(R.id.banner);
        }
    }
}
