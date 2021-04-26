package com.example.fragmentmvvmexample.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentmvvmexample.UpdatedTextViewModel;
import com.example.fragmentmvvmexample.R;

public class SecondScreenFragment extends Fragment {

    UpdatedTextViewModel updatedTextViewModel;
    TextView textView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //To make the communication between the fragments work, we have to set the "getActivity()" method as the Owner
        updatedTextViewModel = new ViewModelProvider(getActivity()).get(UpdatedTextViewModel.class);

        //Loads the layout into v view
        View v = inflater.inflate(R.layout.frgament_second, container, false);

        textView = v.findViewById(R.id.updated_text_view);

        //Sets the Button through the v view using the given Id
        Button eraseTextBtn = v.findViewById(R.id.eraseBtn);
        eraseTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedTextViewModel.setUpdatedTextMutableLiveData("");
            }
        });

        //String Observer variable
        Observer<String> textObserver = new Observer<String>() {
            @Override
            //Every time the observer has notified about the change, it invokes the onChange method
            public void onChanged(String text) {
                textView.setText(text);
            }
        };
        updatedTextViewModel.getUpdatedTextMutableLiveData().observe(this,textObserver);

        return v;

    }
}
