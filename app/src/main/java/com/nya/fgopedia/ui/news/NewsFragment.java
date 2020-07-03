package com.nya.fgopedia.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.nya.fgopedia.R;
import com.nya.fgopedia.adapter.HomeAdapter;

public class NewsFragment extends Fragment {

    private RecyclerView listNews;
    View view;
    private HomeAdapter adapter;
    private LinearLayoutManager mManager;


    public NewsFragment() {

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