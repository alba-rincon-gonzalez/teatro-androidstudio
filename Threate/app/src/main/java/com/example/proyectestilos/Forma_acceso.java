package com.example.proyectestilos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Forma_acceso extends AppCompatActivity {

    private TextView tv1_pAct;
    private CheckBox cb1_pAct,cb2_pAct;
    private Button b1_pAct;
    private ImageView iv1_crea_cuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_acceso);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tv1_pAct=findViewById(R.id.tv1_pAct);
        cb1_pAct=findViewById(R.id.cb1_pAct);
        cb2_pAct=findViewById(R.id.cb2_pAct);
        b1_pAct=findViewById(R.id.b1_pAct);
        iv1_crea_cuenta=findViewById(R.id.iv1_crea_cuenta);

    }
    public void continuar(View e){
        //Metodo OnClick para un botón al pulsar en Continuar
        if (this.cb1_pAct.isChecked() && this.cb2_pAct.isChecked() ){
            //Si ambos ChackBox están pulsados salta mensaje Toast
            Toast.makeText(getApplicationContext(),"Debe elegir solo una opción",Toast.LENGTH_LONG).show();
        }
        else if (this.cb1_pAct.isChecked()){
            //Si esta pulsado este CheckBox pasa a la activity de Acceso con Cuenta o como invitado
            Intent paso_acceso=new Intent(Forma_acceso.this,Acceso_cuenta.class);
            startActivity(paso_acceso);
        }
        else if(this.cb2_pAct.isChecked()){
            //Si esta pulsado este CheckBox pasa a la activity de Inicio
            Intent paso_catalogo=new Intent(Forma_acceso.this,Catalogo_obras.class);
            startActivity(paso_catalogo);
        }

        else{
            //Si no ha pulsado ningún CheckBox
            Toast.makeText(getApplicationContext(),"Debe elegir una opción para poder acceder",Toast.LENGTH_LONG).show();
        }
    }
}