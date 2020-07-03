package com.nya.fgopedia.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nya.fgopedia.R;
import com.nya.fgopedia.adapter.idClassAdapter;

public class DashboardFragment extends Fragment {

    private RecyclerView mRecylerView;
    private idClassAdapter adapter;
    private RecyclerView.LayoutManager mLayout;
    private int[] mDataset;

    int [] icon ={R.drawable.icon_saber, R.drawable.icon_lancer, R.drawable.icon_archer, R.drawable.icon_rider,
    R.drawable.icon_caster, R.drawable.icon_assasin, R.drawable.icon_berseker, R.drawable.icon_ruler, R.drawable.icon_avenger,
    R.drawable.icon_mooncancer, R.drawable.icon_alterego, R.drawable.icon_foreigner};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initDataset();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mRecylerView = (RecyclerView) root.findViewById(R.id.recyclerViewClass);

        mLayout = new LinearLayoutManager(getActivity());
        mRecylerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));

        adapter = new idClassAdapter(mDataset);
        mRecylerView.setAdapter(adapter);
        return root;
    }

    private void initDataset() {
        mDataset = new int[icon.length];
        for (int i = 0; i < icon.length; i++) {
            mDataset[i] = icon[i];

        }
    }
}