package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    private TextView tv1_contacto,tv2_contacto,tv1_base,tv2_base,tv3_base;
    private ImageView iv1_contacto,iv2_ini,iv3_ini,iv4_ini;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tv1_contacto=findViewById(R.id.tv1_contacto);
        tv2_contacto=findViewById(R.id.tv2_contacto);
        iv1_contacto=findViewById(R.id.iv1_contacto);
        iv2_ini=findViewById(R.id.iv2_ini);
        iv3_ini=findViewById(R.id.iv3_ini);
        iv4_ini=findViewById(R.id.iv4_ini);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);

    }
    public void toast_mensaje(View e){
        //Metodo que salta mensaje Toast avisando que ya esta en la página de Contacto
        //Y no puede dirigirte a ella
        Toast.makeText(getApplicationContext(),"Ya estas en Contacto",Toast.LENGTH_LONG).show();
    }
    public void vuelve_inicio(View e){
        //Metodo OnClick que dirige a la página de Inicio
        Intent volver_ini=new Intent(Contacto.this,Catalogo_obras.class);
        startActivity(volver_ini);
    }
    public void lleva_act_principal(View e){
        //Metodo OnClick que dirige a la página de Acceso con Cuenta o como invitado
        Intent lleva_act_prin=new Intent(Contacto.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
}