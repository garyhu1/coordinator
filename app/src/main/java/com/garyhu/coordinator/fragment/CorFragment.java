package com.garyhu.coordinator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.garyhu.coordinator.R;
import com.garyhu.coordinator.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： garyhu.
 * 时间： 2017/2/8.
 */

public class CorFragment extends Fragment {

    private static final String ARG = "key";
    private String mTitle;
//    private TextView tv;
    private RecyclerView rv;

    private List<String> mDatas;
    private RecyclerAdapter mAdapter;

    public static CorFragment getInstance(String title){
        CorFragment f = new CorFragment();
        Bundle b = new Bundle();
        b.putString(ARG,title);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        mTitle = b.getString(ARG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cor,null);
        initView(v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    public void initView(View v){
//        tv = ((TextView) v.findViewById(R.id.tv));
//        tv.setText(mTitle);
        rv = (RecyclerView) v.findViewById(R.id.rv);
    }

    public void init(){
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add(mTitle + (char) i);
        }
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(mAdapter = new RecyclerAdapter(rv.getContext(), mDatas));
    }


}
