package com.lunasoft.tp1lopardo;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TraduccionActivityViewModel extends AndroidViewModel {

    private Context context;
    private List<Palabra> bd = new ArrayList<>();
    private MutableLiveData<Palabra> traduccion;
    public TraduccionActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

        bd.add(new Palabra("banana", "banana", R.drawable.bananas));
        bd.add(new Palabra("naranja", "orange", R.drawable.orange));
        bd.add(new Palabra("manzana", "apple", R.drawable.apple));
        bd.add(new Palabra("sandia", "watermelon", R.drawable.watermelon));
        bd.add(new Palabra("anana", "pineapple", R.drawable.pineapple));
        bd.add(new Palabra("frutilla", "strawberry", R.drawable.strawberry));
    }

    public void buscar(String pal) {
        boolean flag = true;
        for (Palabra palabra: bd){
            if (palabra.getEspanol().equals(pal)){
                traduccion.setValue(palabra);
                flag = false;
            }
        }
        if (flag){
                Palabra noexiste = new Palabra("noexiste", "No encontramos su palabra", R.drawable.error);
                traduccion.setValue(noexiste);
        }
    }

    public LiveData<Palabra> getPalabraM() {
        if (traduccion == null) {
            traduccion= new MutableLiveData<Palabra>();
        }
        return traduccion;
    }

}
