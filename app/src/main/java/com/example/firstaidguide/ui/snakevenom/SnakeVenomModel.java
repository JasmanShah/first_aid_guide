package com.example.firstaidguide.ui.snakevenom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SnakeVenomModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SnakeVenomModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}