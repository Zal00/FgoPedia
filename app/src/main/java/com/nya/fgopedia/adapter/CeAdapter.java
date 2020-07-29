package com.nya.fgopedia.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.nya.fgopedia.DetailCeActivity;
import com.nya.fgopedia.R;
import com.nya.fgopedia.ui.craftessence.Craft;
import com.nya.fgopedia.ui.servant.DetailActivity;
import com.squareup.picasso.Picasso;

public class CeAdapter extends FirebaseRecyclerAdapter<Craft, CeAdapter.CeViewHolder> {

    public CeAdapter(@NonNull FirebaseRecyclerOptions<Craft> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CeAdapter.CeViewHolder holder, final int position, @NonNull Craft model) {
        Picasso.get().load(model.getIconimg()).into(holder.icomimg);
        holder.name.setText(model.getName());
        Picasso.get().load(model.getType()).into(holder.type);
        holder.rarity.setText(model.getRarity());

        //detail list
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailCeActivity.class);
                intent.putExtra("key",getRef(position).getKey());
                view.getContext().startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public CeAdapter.CeViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_ce,parent,false);

        final CeAdapter.CeViewHolder vHolder = new CeAdapter.CeViewHolder(view);

        return vHolder;
    }

    class CeViewHolder extends RecyclerView.ViewHolder{

        TextView name, rarity;
        ImageView icomimg, type;
        View v;

        public CeViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.name_ce);
            rarity = itemView.findViewById(R.id.rarity_ce);
            icomimg = itemView.findViewById(R.id.icon_img);
            type = itemView.findViewById(R.id.type);

            v = itemView;
        }
    }
}
