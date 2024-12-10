package com.test.fragmen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Customf extends Fragment {

    private TextView textViewFragment;

    // Método estático para crear una instancia del fragmento con un argumento
    public static Customf newInstance(String texto) {
        Customf fragment = new Customf();
        Bundle args = new Bundle();
        args.putString("TEXTO", texto);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar la vista del fragmento
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Enlazar el TextView
        textViewFragment = view.findViewById(R.id.textViewFragment);

        // Obtener el argumento pasado y mostrarlo en el TextView
        if (getArguments() != null) {
            String texto = getArguments().getString("TEXTO");
            textViewFragment.setText(texto);
        }
    }

    // Método para actualizar el texto del fragmento
    public void actualizarTexto(String texto) {
        if (textViewFragment != null) {
            textViewFragment.setText(texto);
        }
    }
}
