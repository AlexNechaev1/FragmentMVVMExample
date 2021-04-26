package com.example.fragmentmvvmexample;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpdatedTextViewModel extends ViewModel {

    //Initialize the live data object
    private MutableLiveData<String> updatedTextLiveData = new MutableLiveData<>();

    //"Getters and Setters"
    public void setUpdatedTextMutableLiveData(String text){
        updatedTextLiveData.setValue(text);
    }

    public MutableLiveData<String> getUpdatedTextMutableLiveData(){
        return updatedTextLiveData;
    }
}
