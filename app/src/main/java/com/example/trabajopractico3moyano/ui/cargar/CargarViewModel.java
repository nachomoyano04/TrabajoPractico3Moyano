package com.example.trabajopractico3moyano.ui.cargar;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.trabajopractico3moyano.modelo.Nota;

public class CargarViewModel extends AndroidViewModel {
    private MutableLiveData<Nota> mNota;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Nota> getMNota(){
        if(mNota == null){
            mNota = new MutableLiveData<>();
        }
        return mNota;
    }

    public void guardarNota(Nota nota){
        if(nota != null){
            mNota.setValue(nota);
        }
    }
    // TODO: Implement the ViewModel
}