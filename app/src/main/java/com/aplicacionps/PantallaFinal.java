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
        int porcentajeActual;
        TextView mensaje;
        TextView porciento;
        super.onCreate(savedInstanceState);
        //Relacionamos la clase PantallaFinal.java con su XML activity_pantallafinal.xml
        setContentView(R.layout.activity_pantallafinal);
        //Cambiamos la orientación para que la pantalla se pueda ver en horizontal y que se muestre a
        //pantalla completa, sin barra de notificaciones
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Se obtiene el porcentaje de la actividad anterior
        String dato = getIntent().getStringExtra("dato");
        porcentajeActual = Integer.parseInt(dato);
        //Se relaciona el TextView "Porciento" con el del activity y muestra el porcentaje final obtenido
        porciento = (TextView) findViewById(R.id.porciento);
        porciento.setText("PORCENTAJE = " + dato);
        //Se relaciona el TextView "Mensaje" con el del activity
        mensaje = (TextView) findViewById(R.id.mensajeFinal);
        //Se obtiene un numero aleatorio que dependiendo del porcentaje final hará que aparezca un
        //Mensaje diferente cada vez

        Random r = new Random();
        int numAleatorio = r.nextInt(100);

        //Si el porcentaje final obtenido es 0 no se puede contagiar
        if (porcentajeActual == 0) {
            mensaje.setText("¡ENHORABUENA! No te has contagiado ya que tienes un 0 por ciento de probabilidades. Sigue así.");
            //Si el porcentaje final es 100 o mas se contagiará si o si
        }
        else {
            //Si el numero aleatorio obtenido es menor o igual que el porcentaje obtenido, se contagiará
            if (numAleatorio <= porcentajeActual) {
                //Dependiendo del porcentaje que se haya obtenido al final aparecerá un Mensaje diferente cada vez
                if (porcentajeActual <= 30) {
                    mensaje.setText("Mala suerte, te has contagiado. Incluso con poco porcentaje te puedes contagiar. Ten más cuidado la proxima vez");
                }
                else {
                    mensaje.setText("Te has contagiado. Tienes que tener más cuidado si no quieres que te vuelva a pasar");
                }
                //Por el contrario, si es mayor no se contagiará
            } else {
                //Dependiendo del porcentaje que se haya obtenido al final aparecerá un Mensaje diferente cada vez
                if (porcentajeActual <= 30) {
                    mensaje.setText("No te has contagiado aunque habian pocas posibilidades. Intentalo de nuevo para bajarlas.");
                }
                else {
                    mensaje.setText("Has tenido muchiiiisima suerte. Pero puede que algún día no la tengas y lo pilles. Ten cuidado.");
                }
            }
        }
    }

    //Al pulsar el boton de volver a jugar, el juego te lleva a la casa del jugador para iniciar de nuevo
    //el juego_autobus_fuera
    public void volverajugar(View view){
        Intent volverSuper = new Intent (this, SUP_EscenarioCasa.class);
        startActivity(volverSuper);
    }

    //Al pulsar el boton de menu, te lleva a la pantalla principal del juego
    public void menuprincipal(View view){
        Intent menuprincipal = new Intent (this, MainActivity.class);
        startActivity(menuprincipal);
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
        Boolean valordelboton = sharedPreferences.getBoolean("value", false);
        if (!valordelboton) {
            Intent i = new Intent(this, AudioService.class);
            i.putExtra("action", 3);
            startService(i);
        }
    }

}