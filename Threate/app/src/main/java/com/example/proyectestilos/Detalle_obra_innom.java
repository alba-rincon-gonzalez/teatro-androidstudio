package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle_obra_innom extends AppCompatActivity {

    private TextView tv1_innom,tv2_innom,tv1_base,tv2_base,tv3_base;
    private ImageView iv1_innom;
    private Button b1_innom,b2_innom;
    private String valor,url;
    private double gasto=23.35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_obra_innom);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tv1_innom=findViewById(R.id.tv1_innom);
        valor=getIntent().getExtras().getString("nombre");
        tv2_innom=findViewById(R.id.tv2_innom);
        tv1_innom.setText(valor);
        iv1_innom=findViewById(R.id.iv1_innom);
        b1_innom=findViewById(R.id.b1_innom);
        b2_innom=findViewById(R.id.b2_innom);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);
        url="https://www.elteatroreinavictoria.com/obra-de-teatro/los-innombrables/#:~:text=24%20horas%20antes%20del%20asalto,m%C3%A1s%20absurdo%20a%20la%20banda.";
        b2_innom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Metodo que le asigna OnClick y le dirige a la página web
                Uri uri1=Uri.parse(url);
                Intent pag_web=new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(pag_web);
            }
        });
    }
    public void vuelve_inicio(View e){
        //Metodo OnClick que le dirige a la página de Inicio
        Intent volver_ini=new Intent(Detalle_obra_innom.this,Catalogo_obras.class);
        startActivity(volver_ini);
    }
    public void contactame(View e){
        //Metodo OnClick que dirige a la página de Contacto de la empresa
        Intent volver_ini=new Intent(Detalle_obra_innom.this,Contacto.class);
        startActivity(volver_ini);
    }

    public void reserva_detallada(View e){
        //Metodo OnClick que dirige a la página para reservar
        Intent pag_res=new Intent(Detalle_obra_innom.this,Reserva.class);
        Bundle parametro1=new Bundle();
        parametro1.putString("nombre",valor);
        pag_res.putExtras(parametro1);
        parametro1.putDouble("gasto",gasto);
        pag_res.putExtras(parametro1);
        startActivity(pag_res);
    }
    public void lleva_act_principal(View e){
        //Metodo OnClick que dirige a la página de Acceso con Cuenta o como invitado
        Intent lleva_act_prin=new Intent(Detalle_obra_innom.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
}