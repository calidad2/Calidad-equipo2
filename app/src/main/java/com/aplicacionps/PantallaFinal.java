package com.aplicacionps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplicacionps.AudioService;
import com.aplicacionps.MainActivity;
import com.aplicacionps.R;
import com.aplicacionps.SUP_EscenarioCasa;

import java.util.Random;


public class PantallaFinal extends AppCompatActivity {
    //Se crea una variable para almacenar el porcentaje final obtenido y 2 textview para mostrar el
    //porcentaje y el Mensaje final


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int actualPercentage;
        TextView message;
        TextView percent;
        super.onCreate(savedInstanceState);
        //Relacionamos la clase PantallaFinal.java con su XML activity_pantallafinal.xml
        setContentView(R.layout.activity_pantallafinal);
        //Cambiamos la orientación para que la pantalla se pueda ver en horizontal y que se muestre a
        //pantalla completa, sin barra de notificaciones
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Se obtiene el porcentaje de la actividad anterior
        String dato = getIntent().getStringExtra("dato");
        actualPercentage = Integer.parseInt(dato);
        //Se relaciona el TextView "Porciento" con el del activity y muestra el porcentaje final obtenido
        percent = (TextView) findViewById(R.id.porciento);
        percent.setText("PORCENTAJE = " + dato);
        //Se relaciona el TextView "Mensaje" con el del activity
        message = (TextView) findViewById(R.id.mensajeFinal);
        //Se obtiene un numero aleatorio que dependiendo del porcentaje final hará que aparezca un
        //Mensaje diferente cada vez
        int randomNum = (int) (Math.random() * 100);

        //Si el porcentaje final obtenido es 0 no se puede contagiar
        if (actualPercentage == 0) {
            message.setText("¡ENHORABUENA! No te has contagiado ya que tienes un 0 por ciento de probabilidades. Sigue así.");
            //Si el porcentaje final es 100 o mas se contagiará si o si
        }
        else {
            //Si el numero aleatorio obtenido es menor o igual que el porcentaje obtenido, se contagiará
            if (randomNum <= actualPercentage) {
                //Dependiendo del porcentaje que se haya obtenido al final aparecerá un Mensaje diferente cada vez
                if (actualPercentage <= 30) {
                    message.setText("Mala suerte, te has contagiado. Incluso con poco porcentaje te puedes contagiar. Ten más cuidado la proxima vez");
                }
                else {
                    message.setText("Te has contagiado. Tienes que tener más cuidado si no quieres que te vuelva a pasar");
                }
                //Por el contrario, si es mayor no se contagiará
            } else {
                //Dependiendo del porcentaje que se haya obtenido al final aparecerá un Mensaje diferente cada vez
                if (actualPercentage <= 30) {
                    message.setText("No te has contagiado aunque habian pocas posibilidades. Intentalo de nuevo para bajarlas.");
                }
                else {
                    message.setText("Has tenido muchiiiisima suerte. Pero puede que algún día no la tengas y lo pilles. Ten cuidado.");
                }
            }
        }
    }

    //Al pulsar el boton de volver a jugar, el juego te lleva a la casa del jugador para iniciar de nuevo
    //el juego_autobus_fuera
    public void volverajugar(View view){
        Intent goBackStore = new Intent (this, SUP_EscenarioCasa.class);
        startActivity(goBackStore);
    }

    //Al pulsar el boton de menu, te lleva a la pantalla principal del juego
    public void menuprincipal(View view){
        Intent principalMenu = new Intent (this, MainActivity.class);
        startActivity(principalMenu);
    }

    @Override
    public void onBackPressed() {
        //Este método hace que no podamos retroceder de escenario en la historia jugable

    }

    //Los siguientes metodos sirven para poner musica que se va a escuchar en la aplicacion
    @Override
    public void onPause() {
        super.onPause();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", 4);
        startService(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        Boolean buttonValue = sharedPreferences.getBoolean("value", false);
        if (!buttonValue) {
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", 3);
            startService(i);
        }
    }

}