package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Resumen_reserva extends AppCompatActivity {

    private TextView tv1_resumen,tv2_resumen,tv3_resumen,tv4_resumen,tv5_resumen,tv1_base,tv2_base,tv3_base,tv1_res;
    private String horario,nombre,dia;
    private ProgressBar barra3;
    private int fila,n_asiento;
    private double gasto;
    private ImageView iv2_ini,iv3_ini,iv4_ini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_reserva);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tv1_resumen=findViewById(R.id.tv1_resumen);
        tv2_resumen=findViewById(R.id.tv2_resumen);
        tv3_resumen=findViewById(R.id.tv3_resumen);
        tv4_resumen=findViewById(R.id.tv4_resumen);
        tv5_resumen=findViewById(R.id.tv5_resumen);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);
        iv2_ini=findViewById(R.id.iv2_ini);
        iv3_ini=findViewById(R.id.iv3_ini);
        iv4_ini=findViewById(R.id.iv4_ini);
        barra3=findViewById(R.id.barra3);
        tv1_res=findViewById(R.id.tv1_res);

        dia=getIntent().getExtras().getString("dia");
        nombre=getIntent().getExtras().getString("nombre");
        tv1_resumen.setText("Ha reservado para la obra "+nombre);
        horario=getIntent().getExtras().getString("horario");
        tv2_resumen.setText("Día ->" +dia+"        Hora -> "+horario);
        fila=getIntent().getExtras().getInt("fila");
        tv3_resumen.setText("Fila -> "+fila);
        n_asiento=getIntent().getExtras().getInt("asiento");
        tv4_resumen.setText("Butaca -> "+n_asiento);
        gasto=getIntent().getExtras().getDouble("gasto");
        tv5_resumen.setText(tv5_resumen.getText().toString()+gasto+" euros.");

    }

    public void vuelve_inicio(View e){
        //Metodo OnClick que dirige a la página de Inicio
        Intent volver_ini=new Intent(Resumen_reserva.this,Catalogo_obras.class);
        startActivity(volver_ini);
    }
    public void contactame(View e){
        //Metodo OnClick que dirige a la página de Contacto
        Intent volver_ini=new Intent(Resumen_reserva.this,Contacto.class);
        startActivity(volver_ini);
    }
    public void lleva_act_principal(View e){
        //Metodo OnClick que dirige a la página de Acceso con Cuenta o como invitado
        Intent lleva_act_prin=new Intent(Resumen_reserva.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
}