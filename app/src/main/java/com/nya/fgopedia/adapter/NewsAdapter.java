package com.nya.fgopedia.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.nya.fgopedia.ui.news.News;
import com.squareup.picasso.Picasso;

public class NewsAdapter extends FirebaseRecyclerAdapter<News, NewsAdapter.NewsViewHolder> {

    private Context context;

    public NewsAdapter( FirebaseRecyclerOptions<News> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position, @NonNull final News model) {
        holder.tanggal.setText(model.getTanggal());
        holder.judul.setText(model.getJudul());
        Picasso.get().load(model.getBanner()).into(holder.banner);

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(model.getWebview());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                view.getContext().startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news,parent,false);

        return new NewsViewHolder(view);
    }

    class NewsViewHolder extends RecyclerView.ViewHolder{


        TextView judul, tanggal, webview;
        ImageView banner;
        View v;

        public NewsViewHolder(View itemView){
            super(itemView);


            judul = itemView.findViewById(R.id.judul_news);
            tanggal = itemView.findViewById(R.id.tgl);
            banner = itemView.findViewById(R.id.banner);
            v = itemView;
        }
    }
}
