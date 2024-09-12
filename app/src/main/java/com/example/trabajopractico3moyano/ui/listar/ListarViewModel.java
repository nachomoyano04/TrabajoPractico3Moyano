package com.example.trabajopractico3moyano.ui.listar;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajopractico3moyano.modelo.Nota;

import java.util.ArrayList;
import java.util.List;

public class ListarViewModel extends AndroidViewModel {
    private MutableLiveData<List<Nota>> mNotas = new MutableLiveData<>(new ArrayList<>());

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Nota>> getMNotas() {
        if(mNotas == null){
            mNotas = new MutableLiveData<>();
        }
        return mNotas;
    }

    public void cargarNota(Nota nota) {
        List<Nota> notas = mNotas.getValue();
        if (notas == null) {
            notas = new ArrayList<>();
        }
        notas.add(nota);
        mNotas.setValue(notas);
    }

    // TODO: Implement the ViewModel
}