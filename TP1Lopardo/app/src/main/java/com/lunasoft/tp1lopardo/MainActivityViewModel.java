package com.lunasoft.tp1lopardo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void enviar (String palabra){
        if (palabra.length() == 0 ){
            Toast.makeText(context, "Ingrese una palabra", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, TraduccionActivity.class);
            intent.putExtra("palabra", palabra);
            intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
