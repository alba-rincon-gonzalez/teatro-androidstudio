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

public class Detalle_obra_lotto extends AppCompatActivity {

    private TextView tv1_lotto,tv2_lotto,tv1_base,tv2_base,tv3_base;
    private ImageView iv1_lotto;
    private Button b1_lotto,b2_lotto;
    private String valor,url;
    private double gasto=21.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_obra_lotto);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        tv1_lotto=findViewById(R.id.tv1_lotto);
        valor=getIntent().getExtras().getString("nombre");
        tv2_lotto=findViewById(R.id.tv2_lotto);
        tv1_lotto.setText(valor);
        iv1_lotto=findViewById(R.id.iv1_lotto);
        b1_lotto=findViewById(R.id.b1_lotto);
        b2_lotto=findViewById(R.id.b2_lotto);
        tv1_base=findViewById(R.id.tv1_base);
        tv2_base=findViewById(R.id.tv2_base);
        tv3_base=findViewById(R.id.tv3_base);

        url="https://www.elteatroreinavictoria.com/obra-de-teatro/lotto/#:~:text=Una%20pareja%20enamorada%20y%20consolidada,estaba%20preparada%20para%20compartir%20su";
        b2_lotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Metodo que le vuelca OnClick y lleva a la página web
                Uri uri1=Uri.parse(url);
                Intent pag_web=new Intent(Intent.ACTION_VIEW,uri1);
                startActivity(pag_web);
            }
        });
    }
    public void vuelve_inicio(View e){
        //Metodo OnClick que dirige a la página de Inicio
        Intent volver_ini=new Intent(Detalle_obra_lotto.this,Catalogo_obras.class);
        startActivity(volver_ini);
    }
    public void reserva_detallada(View e){
        //Metodo OnClick que dirige a la página para reservar
        Intent pag_res=new Intent(Detalle_obra_lotto.this,Reserva.class);
        Bundle parametro1=new Bundle();
        parametro1.putString("nombre",valor);
        pag_res.putExtras(parametro1);
        parametro1.putDouble("gasto",gasto);
        pag_res.putExtras(parametro1);
        startActivity(pag_res);
    }
    public void lleva_act_principal(View e){
        //Metodo OnClick que dirige a la página de Acceso con Cuenta o invitado
        Intent lleva_act_prin=new Intent(Detalle_obra_lotto.this,Forma_acceso.class);
        startActivity(lleva_act_prin);
    }
    public void contactame(View e){
        //Metodo OnClick que dirige a la página de Contacto de la Empresa
        Intent volver_ini=new Intent(Detalle_obra_lotto.this,Contacto.class);
        startActivity(volver_ini);
    }
}