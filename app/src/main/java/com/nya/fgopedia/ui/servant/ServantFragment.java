package com.nya.fgopedia.ui.servant;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nya.fgopedia.R;
import com.nya.fgopedia.adapter.ServantAdapter;

import java.util.List;

public class ServantFragment extends Fragment {
    //search
    private EditText editText;
    private Button searchButton;

    //database
    private RecyclerView recyclerViewdatabase;
    View view;
    private ServantAdapter servantAdapter;
    private LinearLayoutManager mManager;

    public ServantFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_servant, container, false);

        //Search
        editText = view.findViewById(R.id.searchServant);
        searchButton = view.findViewById(R.id.button2);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                firebaseSearch(s);
            }
        });//End

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                firebaseSearch(s);
            }
        });//End

        //DatabaseServant
        recyclerViewdatabase = view.findViewById(R.id.recyclerViewServant);
        mManager = new LinearLayoutManager(getContext());
        recyclerViewdatabase.setLayoutManager(mManager);

        FirebaseRecyclerOptions<Servant> options =
                new FirebaseRecyclerOptions.Builder<Servant>().setQuery(FirebaseDatabase.getInstance().getReference().child("Servant").orderByChild("name")
                        , Servant.class)
                        .build();
       servantAdapter = new ServantAdapter(options);
        recyclerViewdatabase.setAdapter(servantAdapter);
        //End

        return view;
    }

    private void firebaseSearch(String s) {


        FirebaseRecyclerOptions<Servant> options = new FirebaseRecyclerOptions.Builder<Servant>().setQuery(FirebaseDatabase.getInstance()
                .getReference().child("Servant").orderByChild("name").startAt(s).endAt(s + "\uf8ff"), Servant.class).build();


        servantAdapter = new ServantAdapter(options);
        recyclerViewdatabase.setHasFixedSize(true);
        recyclerViewdatabase.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewdatabase.setAdapter(servantAdapter);
        servantAdapter.startListening();
    }
    
    public void onStart() {
        super.onStart();
        servantAdapter.startListening();

    }

    public void onStop() {
        super.onStop();
        servantAdapter.stopListening();
    }
}