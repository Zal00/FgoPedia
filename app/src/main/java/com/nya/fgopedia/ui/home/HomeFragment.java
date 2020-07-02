package com.nya.fgopedia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.nya.fgopedia.R;
import com.nya.fgopedia.adapterSlider.HomeAdapter;

public class HomeFragment extends Fragment {

    private RecyclerView listNews;
    View view;
    private HomeAdapter adapter;
    private LinearLayoutManager mManager;


    public HomeFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        listNews = view.findViewById(R.id.recycleViewNews);

        mManager = new LinearLayoutManager(getContext());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        listNews.setLayoutManager(mManager);


        FirebaseRecyclerOptions<News> options =
                new FirebaseRecyclerOptions.Builder<News>().setQuery(FirebaseDatabase.getInstance().getReference().child("News"), News.class)
                        .build();

        adapter = new HomeAdapter(options);

        listNews.setAdapter(adapter);

        return view;
    }

    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}