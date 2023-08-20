package com.lunasoft.tp1lopardo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lunasoft.tp1lopardo.databinding.ActivityTraduccionBinding;

public class TraduccionActivity extends AppCompatActivity {

    private TraduccionActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityTraduccionBinding binding = ActivityTraduccionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(TraduccionActivityViewModel.class);
        Intent intent = getIntent();
        String pal = (String) intent.getStringExtra("palabra");

        vm.getPalabraM().observe(this, new Observer<Palabra>() {
            @Override
            public void onChanged(Palabra palabra) {
                binding.tvPalabraIngles.setText(palabra.getIngles());
                binding.imgPalabra.setImageResource(palabra.getFoto());
            }
        });

        vm.buscar(pal);
    }
}
