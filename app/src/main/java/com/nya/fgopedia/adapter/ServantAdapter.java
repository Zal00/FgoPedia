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
import com.nya.fgopedia.R;
import com.nya.fgopedia.ui.servant.DetailActivity;
import com.nya.fgopedia.ui.servant.Servant;
import com.squareup.picasso.Picasso;

public class ServantAdapter extends FirebaseRecyclerAdapter<Servant, ServantAdapter.ServantViewHolder> {


    public ServantAdapter(@NonNull FirebaseRecyclerOptions<Servant> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ServantAdapter.ServantViewHolder holder, final int position, @NonNull Servant model) {
        Picasso.get().load(model.getIcomimg()).into(holder.icomimg);
        holder.name.setText(model.getName());
        Picasso.get().load(model.getIcon()).into(holder.icon);
        holder.rarity.setText(model.getRarity());

        //detail list
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("key",getRef(position).getKey());
                view.getContext().startActivity(intent);
            }
        });


    }

    @NonNull
    @Override
    public ServantAdapter.ServantViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_servant,parent,false);

        final ServantViewHolder vHolder = new ServantViewHolder(view);


        return vHolder;
    }



    class ServantViewHolder extends RecyclerView.ViewHolder{


        TextView name, rarity;
        ImageView icomimg, icon;
        View v;

        public ServantViewHolder(View itemView){
            super(itemView);

            name = itemView.findViewById(R.id.servant_name);
            rarity = itemView.findViewById(R.id.rarity);
            icomimg = itemView.findViewById(R.id.icom_img);
            icon = itemView.findViewById(R.id.icon_class);

            v = itemView;
        }
    }
}