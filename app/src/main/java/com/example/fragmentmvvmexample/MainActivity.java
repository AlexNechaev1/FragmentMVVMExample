package com.example.fragmentmvvmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.fragmentmvvmexample.Fragment.PagerFragment;

public class MainActivity extends AppCompatActivity{

    UpdatedTextViewModel updatedTextViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Implementation is must!!!
        //
        //        def lifecycle_version = "2.3.1"
        //
        // ViewModel
        //        implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
        // LiveData
        //        implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"

        //The approach:
        //1.    Create a MVVM Class
        //2.    Create layout and class for each screen - the classes extends from Fragment class (androidx library)
        //3.    On each fragment on "onCreateView" method initialize the MVVM class with new ViewModelProvider
        //4.    Use the instance you have just created to set the new values and set the observers
        //4.1   In fragment that sends the data: call to the "set" method from the
        updatedTextViewModel = new ViewModelProvider(this).get(UpdatedTextViewModel.class);

        PagerFragment pagerFragment =new PagerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, pagerFragment ,null).commit();
    }
}