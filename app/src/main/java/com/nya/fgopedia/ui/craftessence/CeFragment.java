package com.nya.fgopedia.ui.craftessence;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.nya.fgopedia.R;
import com.nya.fgopedia.adapter.CeAdapter;
import com.nya.fgopedia.adapter.ServantAdapter;
import com.nya.fgopedia.ui.servant.Servant;

public class CeFragment extends Fragment {
    //search
    private EditText searchCe;
    private Button buttonCe;

    //database
    private RecyclerView recyclerViewdatabase;
    View view;
    private CeAdapter ceAdapter;
    private LinearLayoutManager mManager;

    public CeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_ce, container, false);

        //Search
        searchCe = view.findViewById(R.id.searchCe);
        buttonCe = view.findViewById(R.id.buttonCe);

        searchCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = searchCe.getText().toString();
                firebaseSearch(s);
            }
        });//End

        buttonCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = searchCe.getText().toString();
                firebaseSearch(s);
            }
        });//End

        //DatabaseServant
        recyclerViewdatabase = view.findViewById(R.id.recyclerViewce);
        mManager = new LinearLayoutManager(getContext());
        recyclerViewdatabase.setLayoutManager(mManager);

        FirebaseRecyclerOptions<Craft> options =
                new FirebaseRecyclerOptions.Builder<Craft>().setQuery(FirebaseDatabase.getInstance().getReference().child("Craft").orderByChild("id")
                        , Craft.class)
                        .build();
        ceAdapter = new CeAdapter(options);
        recyclerViewdatabase.setAdapter(ceAdapter);
        //End

        return view;
    }

    private void firebaseSearch(String s) {


        FirebaseRecyclerOptions<Craft> options = new FirebaseRecyclerOptions.Builder<Craft>().setQuery(FirebaseDatabase.getInstance()
                .getReference().child("Craft").orderByChild("name").startAt(s).endAt(s + "\uf8ff"), Craft.class).build();


        ceAdapter = new CeAdapter(options);
        recyclerViewdatabase.setHasFixedSize(true);
        recyclerViewdatabase.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewdatabase.setAdapter(ceAdapter);
        ceAdapter.startListening();
    }

    public void onStart() {
        super.onStart();
        ceAdapter.startListening();

    }

    public void onStop() {
        super.onStop();
        ceAdapter.stopListening();
    }
}