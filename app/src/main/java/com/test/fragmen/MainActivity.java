package com.test.fragmen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Button btnCreateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la interfaz
        editTextInput = findViewById(R.id.editTextInput);
        btnCreateFragment = findViewById(R.id.btnCreateFragment);

        // Acciones cuando se pulse el botón
        btnCreateFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto del EditText
                String texto = editTextInput.getText().toString().trim();

                // Comprobar si el texto no está vacío
                if (!texto.isEmpty()) {
                    agregarOActualizarFragmento(texto);
                }
            }
        });
    }

    // Método para crear o actualizar el fragmento
    private void agregarOActualizarFragmento(String texto) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Customf fragmentoExistente = (Customf) fragmentManager.findFragmentById(R.id.fragmentContainer);

        if (fragmentoExistente != null) {
            // Si el fragmento ya existe, solo actualizamos su contenido
            fragmentoExistente.actualizarTexto(texto);
        } else {
            // Si el fragmento no existe, lo creamos y lo añadimos al contenedor
            Customf nuevoFragmento = Customf.newInstance(texto);
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainer, nuevoFragmento);
            transaction.commit();
        }
    }
}
