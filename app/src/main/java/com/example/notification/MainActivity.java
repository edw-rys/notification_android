package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * Botón
     */
    private Button boton;
    /**
     * Objeto de notificación
     */
    Notification.Builder notificacion;

    public  static final int id_unico = 424;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Buscar botón
        this.boton = this.findViewById(R.id.btn_notificacion);
        // Instancia la notificación
        this.notificacion = new Notification.Builder(this);

    }

    /**
     * Crear notificación
     * @param view
     */
    public void createNotification(View view) {
        // Configuración de las notificaciones
        this.notificacion.setSmallIcon(R.mipmap.ic_launcher);
        this.notificacion.setTicker("Nueva notificación");
        this.notificacion.setWhen(System.currentTimeMillis());
        this.notificacion.setContentTitle("Notificación");
        this.notificacion.setContentText("Esta es una notificación");

        // Llamará a la otra activity luego de pulsar en la notificación
                                    // Esta clase.this,  Otra clase.class
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Se añade la otra activity (que se abrirá luego de pulsar) en la notificación
        notificacion.setContentIntent(pendingIntent);

        // Administrador de notificaciones
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Construye la notificación
        notificationManager.notify(this.id_unico, this.notificacion.build());
    }
}