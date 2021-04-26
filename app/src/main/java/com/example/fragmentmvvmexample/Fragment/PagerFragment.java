package com.example.fragmentmvvmexample.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.fragmentmvvmexample.Adapter.PagerAdapter;
import com.example.fragmentmvvmexample.R;

public class PagerFragment extends Fragment {

    public PagerFragment(){};

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_main,container,false);

        ViewPager2 viewPager = v.findViewById(R.id.pager);

        PagerAdapter pagerAdapter = new PagerAdapter(this,2);

        viewPager.setAdapter(pagerAdapter);

        return v;
    }
}
