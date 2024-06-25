package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

public class Intro extends AppCompatActivity {
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        iv1=findViewById(R.id.iv1);

        //Creo un hilo que durante 8 segundos se mostrará esta activity que es una imagen como INTRODUCCIÓN
        //Una vez termine pasará a la activity de Forma de Acceso con Cuenta o como invitado
        Thread t1=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(8000);
                    Intent siguiente_pantalla=new Intent(Intro.this,Forma_acceso.class);
                    startActivity(siguiente_pantalla);
                    finish();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }
}