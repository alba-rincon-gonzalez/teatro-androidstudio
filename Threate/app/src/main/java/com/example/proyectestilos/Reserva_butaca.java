package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Reserva_butaca extends AppCompatActivity {

    private Button b1_reserva;
    private TextView tv2_reserva,tv3_reserva,tv1_base,tv2_base,tv3_base,tv1_res_but;
    private ProgressBar barra2;
    private String horario,valor,dia;
    private double gasto;
    private int fila=0,n_butaca=0;
    private RadioButton rb1_reserva,rb2_reserva;
    private ImageView iv1_reserva,iv2_reserva,iv3_reserva,iv4_reserva,iv5_reserva,iv6_reserva,iv7_reserva,iv8_reserva,iv9_reserva,iv2_ini,iv3_ini,iv4_ini;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_butaca);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tv2_reserva=findViewById(R.id.tv2_reserva);
        tv2_reserva=findViewById(R.id.tv2_reserva);
        iv1_reserva=findViewById(R.id.iv1_reserva);
        iv2_reserva=findViewById(R.id.iv2_reserva);
        iv3_reserva=findViewById(R.id.iv3_reserva);
        iv4_reserva=findViewById(R.id.iv4_reserva);
        iv5_reserva=findViewById(R.id.iv5_reserva);
        iv6_reserva=findViewById(R.id.iv6_reserva);
        iv7_reserva=findViewById(R.id.iv7_reserva);
        iv8_reserva=findViewById(R.id.iv8_reserva);
        iv9_reserva=findViewById(R.id.iv9_reserva);
        iv2_ini=findViewById(R.id.iv2_ini);
        iv3_ini=findViewById(R.id.iv3_ini);
        iv4_ini=findViewById(R.id.iv4_ini);
        b1_reserva=findViewById(R.id.b1_reserva);
        rb1_reserva=findViewById(R.id.rb1_reserva);
        rb2_reserva=findViewById(R.id.rb2_reserva);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);
        barra2=findViewById(R.id.barra2);
        tv1_res_but=findViewById(R.id.tv1_res_but);
        n_butaca=getIntent().getExtras().getInt("asiento");
        fila=getIntent().getExtras().getInt("fila");
        valor=getIntent().getExtras().getString("nombre");
        gasto=getIntent().getExtras().getDouble("gasto");
        horario=getIntent().getExtras().getString("horario");
        dia=getIntent().getExtras().getString("dia");


    }
    public void contactame(View e){
        //Metodo OnClick que dirige a la página de Contacto de la empresa
        Intent volver_ini=new Intent(Reserva_butaca.this,Contacto.class);
        startActivity(volver_ini);
    }

    public void vuelve_inicio(View e){
        //Metodo OnClick que dirige a la página de Inicio
        Intent volver_ini=new Intent(Reserva_butaca.this,Catalogo_obras.class);
        startActivity(volver_ini);
    }
    public void lleva_act_principal(View e){
        //Metodo OnClick que dirige a la página de Acceso con Cuenta o como invitado
        Intent lleva_act_prin=new Intent(Reserva_butaca.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
    //Metodos OnClick que asigna una imagen,la fila y la butaca al pulsar sobre ella
    public void but1(View e){
        fila=1;
        n_butaca=1;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+"  butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but2(View e){
        fila=1;
        n_butaca=2;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but3(View e){
        fila=1;
        n_butaca=3;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but4(View e){
        fila=1;
        n_butaca=4;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but5(View e){
        fila=1;
        n_butaca=5;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+"  butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but6(View e){
        fila=2;
        n_butaca=1;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but7(View e){
        fila=2;
        n_butaca=2;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but8(View e){
        fila=2;
        n_butaca=3;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void but9(View e){
        fila=2;
        n_butaca=4;
        Toast.makeText(getApplicationContext(),"Seleccionó el asiento de la fila "+fila+" butaca "+n_butaca+".",Toast.LENGTH_LONG).show();
    }
    public void continua(View e){

       //Si las variables no están a 0 dirige a la siguiente activity que es la de Resumen Reserva
        //Y debe haber al menos 1 Check marcado

            if(rb1_reserva.isChecked()) {
                if(fila == 0 || n_butaca ==0){
                    Toast.makeText(getApplicationContext(),"DEBE SELECCIONAR UNA BUTACA",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent resumen_reserva=new Intent(Reserva_butaca.this,Resumen_reserva.class);
                    Bundle parametro1=new Bundle();
                    parametro1.putString("horario",horario);
                    resumen_reserva.putExtras(parametro1);
                    parametro1.putInt("fila",fila);
                    resumen_reserva.putExtras(parametro1);
                    parametro1.putInt("asiento",n_butaca);
                    resumen_reserva.putExtras(parametro1);
                    parametro1.putString("nombre",valor);
                    resumen_reserva.putExtras(parametro1);
                    parametro1.putDouble("gasto",gasto);
                    resumen_reserva.putExtras(parametro1);
                    parametro1.putString("dia",dia);
                    resumen_reserva.putExtras(parametro1);
                    startActivity(resumen_reserva);
                }
            }
            else if (rb2_reserva.isChecked()){
                Intent vuelve_inicio=new Intent(Reserva_butaca.this,Catalogo_obras.class);
                startActivity(vuelve_inicio);
            }
            else{
                Toast.makeText(getApplicationContext(),"Seleccione si quiere continuar o no",Toast.LENGTH_LONG).show();
            }
        }
    }
