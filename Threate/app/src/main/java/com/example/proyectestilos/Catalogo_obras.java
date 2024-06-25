package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Catalogo_obras extends AppCompatActivity {

    private TextView tv1_ini,tv2_ini,tv3_ini,tv4_ini,tv5_ini,tv1_base,tv2_base,tv3_base;
    private ImageButton ib1_ini,ib2_ini;
    private ImageView iv2_ini,iv3_ini,iv4_ini;
    private Button b1_ini,b2_ini;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_obras);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tv1_ini=findViewById(R.id.tv1_ini);
        tv2_ini=findViewById(R.id.tv2_ini);
        tv3_ini=findViewById(R.id.tv3_ini);
        tv4_ini=findViewById(R.id.tv4_ini);
        tv5_ini=findViewById(R.id.tv5_ini);
        ib1_ini=findViewById(R.id.ib1_ini);
        ib2_ini=findViewById(R.id.ib2_ini);
        iv2_ini=findViewById(R.id.iv2_ini);
        iv3_ini=findViewById(R.id.iv3_ini);
        iv4_ini=findViewById(R.id.iv4_ini);
        b1_ini=findViewById(R.id.b1_ini);
        b2_ini=findViewById(R.id.b2_ini);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);

    }
    public void detalle_innom(View e){
        //Metodo OnClick que dirige a otra activity enviando el dato del nombre de la obra
        //Dirige a la actividad de la obra de Innombrables
        Intent acceso_pag_detalle_innom=new Intent(Catalogo_obras.this,Detalle_obra_innom.class);
        Bundle parametro1=new Bundle();
        String param1=tv2_ini.getText().toString();
        parametro1.putString("nombre",param1);
        acceso_pag_detalle_innom.putExtras(parametro1);
        startActivity(acceso_pag_detalle_innom);

    }
    public void detalle_lotto(View e){
        //Metodo OnClick que dirige a otra activity enviando el dato del nombre de la obra
        //Dirige a la actividad de la obra de Innombrables
        Intent acce_detalle_lotto=new Intent(Catalogo_obras.this,Detalle_obra_lotto.class);
        Bundle parametro1=new Bundle();
        String param1=tv3_ini.getText().toString();
        parametro1.putString("nombre",param1);
        acce_detalle_lotto.putExtras(parametro1);
        startActivity(acce_detalle_lotto);
    }
    public void mensaje_toast(View e){
        //Metodo OnClick donde salta mensaje Toast que avisa que ya estas en Inicio
        //Y no puede dirigirte ahí
        Toast.makeText(getApplicationContext(),"Ya estas en Inicio",Toast.LENGTH_LONG).show();
    }
    public void contactame(View e){
        //Metodo OnClick que dirige a la página de Contacto de la empresa
        Intent volver_ini=new Intent(Catalogo_obras.this,Contacto.class);
        startActivity(volver_ini);
    }
    public void lleva_act_principal(View e){
        //Metodo Onclick que dirige a la página de Acceso con Cuenta o como invitado
        Intent lleva_act_prin=new Intent(Catalogo_obras.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
}