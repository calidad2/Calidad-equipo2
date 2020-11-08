package com.aplicacionps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Ajustes extends AppCompatActivity {

    SwitchCompat silenciar;

    //Relacionamos la clase Ajustes con su correspondiente clase XML y activamos la orientacion horizontal
    //Incluimos un boton switch para poder silenciar o escuchar la música de la aplicacion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        silenciar = findViewById(R.id.boton_Silenciar);

        //SE SALVA EL ESTADO DEL SWITCH EN shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        silenciar.setChecked(sharedPreferences.getBoolean("value", false));

        silenciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (silenciar.isChecked()){
                    //CUANDO ESTÁ ACTIVO
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    silenciar.setChecked(true);
                }else {
                    //CUANDO ESTÁ INACTIVO
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    silenciar.setChecked(false);
                }
            }
        });
    }
    // Los siguientes metodos onPause y onResume permiten escuchar o no la musica de la aplicacion en esta pantalla
    @Override
    public void onPause() {
        super.onPause();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.PAUSE);
        startService(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        Boolean valordelboton = sharedPreferences.getBoolean("value", false);
        if (valordelboton != true) {
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", AudioService.START);
            startService(i);
        }
    }

    //Metodo para poder volver a la pantalla inicio
    public void volver(View view){
        Intent volver= new Intent (this, MainActivity.class);
        startActivity(volver);

    }
    //Al cierre el boton switch se desactiva por defecto
    public void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("value",false);
        editor.apply();
    }
}