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

public class Reserva extends AppCompatActivity {

    private Button b1_reserva;
    private TextView tv1_reserva,tv2_reserva,tv3_reserva,tv1_base,tv2_base,tv3_base,tv4_reserva;
    private ListView lv1,lv2;
    private String horario="0",dia="0",valor;

    private ProgressBar barra1;
    private int fila,n_butaca;
    private double gasto;
    private RadioButton rb1_reserva,rb2_reserva;
    private ImageView iv2_ini,iv3_ini,iv4_ini;
    private ArrayList<String> Contenido_horario=new ArrayList <String>();
    private ArrayList<String> Contenido_dia=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Contenido_horario.add("17:00 - 18:00");
        Contenido_horario.add("18:00 - 19:00");
        Contenido_horario.add("19:00 - 20:00");
        Contenido_horario.add("20:00 - 21:00");

        Contenido_dia.add("26 de Abril");
        Contenido_dia.add("27 de Abril");

        lv1=findViewById(R.id.lv1);
        lv2=findViewById(R.id.lv2);
        tv1_reserva=findViewById(R.id.tv1_reserva);
        iv2_ini=findViewById(R.id.iv2_ini);
        iv3_ini=findViewById(R.id.iv3_ini);
        iv4_ini=findViewById(R.id.iv4_ini);
        b1_reserva=findViewById(R.id.b1_reserva);
        rb1_reserva=findViewById(R.id.rb1_reserva);
        rb2_reserva=findViewById(R.id.rb2_reserva);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);
        tv4_reserva=findViewById(R.id.tv4_reserva);
        barra1=findViewById(R.id.barra1);
        valor=getIntent().getExtras().getString("nombre");
        gasto=getIntent().getExtras().getDouble("gasto");

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Contenido_horario);
        lv1.setAdapter(adaptador);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int j, long l) {
                //Metodo que instala un OnClick con su Adaptador y el array
                horario=Contenido_horario.get(j);
                //Asigno a una variable el texto que se ha pulsado
                Toast.makeText(getApplicationContext(),"Seleccionó horario de "+horario,Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> adaptador2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Contenido_dia);
        lv2.setAdapter(adaptador2);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Metodo que instala un OnClick con su Adaptador y el array
                dia=Contenido_dia.get(i);
                //Asigno a una variable el texto que se ha pulsado
                Toast.makeText(getApplicationContext(),"Seleccionó el día "+dia,Toast.LENGTH_LONG).show();
            }
        });

    }
    public void contactame(View e){
        //Metodo OnClick que dirige a la página para reservar
        Intent volver_ini=new Intent(Reserva.this,Contacto.class);
        startActivity(volver_ini);
    }

    public void vuelve_inicio(View e){
        //Metodo OnClick que dirige a la página de Inicio
        Intent volver_ini=new Intent(Reserva.this,Catalogo_obras.class);
        startActivity(volver_ini);
    }
    public void lleva_act_principal(View e){
        //Metodo OnClick que dirige a la página de Acceso con Cuenta o como invitado
        Intent lleva_act_prin=new Intent(Reserva.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
    public void continua(View e){
        //Metodo OnClick para un botón y si las variables de día y horario ya almacenan
        //Un valor permitirá continuar a la siguiente página que es para elegir butaca
        //Si ha elegido la opción de no continuar volverá para atras


            if(rb1_reserva.isChecked()) {
                if(horario.equals("0") || dia.equals("0")){
                Toast.makeText(getApplicationContext(),"DEBE SELECCIONAR UN DIA Y HORA",Toast.LENGTH_LONG).show();
            }
                else {
                    Intent resumen_reserva=new Intent(Reserva.this,Reserva_butaca.class);
                    Bundle parametro1=new Bundle();
                    parametro1.putString("dia",dia);
                    resumen_reserva.putExtras(parametro1);
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
                    startActivity(resumen_reserva);
                }

            }
            else if (rb2_reserva.isChecked()){
                Intent vuelve_inicio=new Intent(Reserva.this,Catalogo_obras.class);
                startActivity(vuelve_inicio);
            }
            else{
                Toast.makeText(getApplicationContext(),"Seleccione si quiere continuar o no",Toast.LENGTH_LONG).show();
            }
        }

    }
