package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Acceso_cuenta extends AppCompatActivity {

    private String res_correo,res_contra;
    private TextView tv1_acceso,tv2_acceso;
    private EditText respuesta_contraseña,respuesta_correo;
    private Button b1_acceso,b2_acceso;
    private ArrayList <String> Array_Correos=new ArrayList<>();
    private ArrayList <String> Array_Contraseñas=new ArrayList<>();
    private ArrayList <String> Array_Nombres=new ArrayList<>();
    private ArrayList <String> Array_Apellidos=new ArrayList<>();
    private ArrayList <Integer> Array_Telefonos=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_cuenta);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tv1_acceso=findViewById(R.id.tv1_acceso);
        tv2_acceso=findViewById(R.id.tv2_acceso);
        b1_acceso=findViewById(R.id.b1_acceso);
        b2_acceso=findViewById(R.id.b2_acceso);
        respuesta_contraseña=findViewById(R.id.respuesta_contraseña);
        respuesta_correo=findViewById(R.id.respuesta_correo);

        //Le añado esos datos a cada array
        Array_Nombres.add("Alba");
        Array_Apellidos.add("Rincon Gonzalez");
        Array_Contraseñas.add("XXX");
        Array_Correos.add("albar@gmail.com");
        Array_Telefonos.add(679251304);


    }

    public void atras(View e){
        //Metodo OnClick a un botón para retroceder
        Intent retrocede=new Intent(Acceso_cuenta.this,Forma_acceso.class);
        startActivity(retrocede);
    }
    public void buscar_datos(View e){
        //Metodo OnClick para poder continuar primero miro si existe ese correo electronico
        //Y que coincida con la contraseña
        res_correo=respuesta_correo.getText().toString();
        res_contra=respuesta_contraseña.getText().toString();

        for (int i=0;i<Array_Correos.size();i++){
            if(Array_Correos.get(i).equalsIgnoreCase(res_correo)){
                if(Array_Contraseñas.get(i).equals(res_contra)){
                    Intent accecido=new Intent(Acceso_cuenta.this,Catalogo_obras.class);
                    startActivity(accecido);
                }
                else{
                    Toast.makeText(getApplicationContext(),"La contraseña no coincide",Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"No existe ningun correo electronico así",Toast.LENGTH_LONG).show();
            }
        }
    }
}