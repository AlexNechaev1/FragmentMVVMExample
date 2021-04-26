package com.example.fragmentmvvmexample.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fragmentmvvmexample.Fragment.FirstScreenFragment;
import com.example.fragmentmvvmexample.Fragment.SecondScreenFragment;

public class PagerAdapter extends FragmentStateAdapter {

    private final int numOfTabs;

    public PagerAdapter(@NonNull Fragment fragment, int numOfTabs) {
        super(fragment);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (position == 0)? new FirstScreenFragment():new SecondScreenFragment();
    }

    @Override
    public int getItemCount() {
        return numOfTabs;
    }
}
