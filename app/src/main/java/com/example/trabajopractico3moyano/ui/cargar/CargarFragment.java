package com.example.trabajopractico3moyano.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trabajopractico3moyano.R;
import com.example.trabajopractico3moyano.databinding.FragmentCargarBinding;
import com.example.trabajopractico3moyano.modelo.Nota;
import com.example.trabajopractico3moyano.ui.listar.ListarViewModel;

public class CargarFragment extends Fragment {

    private ListarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(ListarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        binding.btnGuardarNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreNota = binding.etNombreNota.getText().toString();
                String contenidoNota = binding.etNuevaNota.getText().toString();
                mViewModel.cargarNota(new Nota(nombreNota, contenidoNota));
                binding.etNombreNota.setText("");
                binding.etNuevaNota.setText("");
                Toast.makeText(getContext(), "Nota guardada con éxito", Toast.LENGTH_SHORT).show();
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