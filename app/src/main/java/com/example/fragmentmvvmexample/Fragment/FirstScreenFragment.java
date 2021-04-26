package com.example.fragmentmvvmexample.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragmentmvvmexample.UpdatedTextViewModel;
import com.example.fragmentmvvmexample.R;

public class FirstScreenFragment extends Fragment {

    UpdatedTextViewModel updatedTextViewModel;
    EditText textBox;
    Button updateTextBtn;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //To make the communication between the fragments work, we have to set the "getActivity()" method as the Owner

        updatedTextViewModel = new ViewModelProvider(getActivity()).get(UpdatedTextViewModel.class);

        //Loads the layout into v view
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        textBox = v.findViewById(R.id.text_edit_text);

        //Sets the Button through the v view using the given Id
        updateTextBtn = v.findViewById(R.id.updated_text_btn);
        updateTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calls the "getter" of updatedTextMutableLiveData object from UpdatedTextViewModel class and sets the sting value from the edit text
                updatedTextViewModel.setUpdatedTextMutableLiveData(textBox.getText().toString());
                textBox.setText("");
            }
        });
        return v;
    }
}
