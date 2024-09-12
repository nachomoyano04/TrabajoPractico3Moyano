package com.example.trabajopractico3moyano.ui.listar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trabajopractico3moyano.R;
import com.example.trabajopractico3moyano.databinding.FragmentListarBinding;
import com.example.trabajopractico3moyano.modelo.Nota;

import java.util.ArrayList;
import java.util.List;

public class ListarFragment extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;
    private ListarNotaAdapter adapter;

    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentListarBinding.inflate(inflater, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(ListarViewModel.class);

        adapter = new ListarNotaAdapter(new ArrayList<>(), inflater);
//        GridLayoutManager grid = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        binding.rvNotas.setAdapter(adapter);
        binding.rvNotas.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getMNotas().observe(getViewLifecycleOwner(), new Observer<List<Nota>>() {
            @Override
            public void onChanged(List<Nota> notas) {
                if (notas != null) {
                    Log.d("ListarFragment", "Notas recibidas: " + notas.size()); // Verifica si notas no es null y tiene tamaño
                    adapter.setNotas(notas); // Actualiza el adaptador con la nueva lista de notas
                } else {
                    Log.d("ListarFragment", "Notas son null");
                }
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        // TODO: Use the ViewModel
    }

}