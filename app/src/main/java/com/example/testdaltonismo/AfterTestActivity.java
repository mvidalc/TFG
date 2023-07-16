package com.example.testdaltonismo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class AfterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_test);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        GlobalVariables.testDone = true;

        configureAtrasButton();
        calcularResultado();
        configureDetallesButton();
        configureCamaraButton();
    }

    private void calcularResultado(){
        // Creamos el array con los resultados (esto habrá que optimizarlo)
        ArrayList<Integer> respuestas = new ArrayList<Integer>();

        // Añadimos los resultados
        respuestas.add(GlobalVariables.guess1);
        respuestas.add(GlobalVariables.guess2);
        respuestas.add(GlobalVariables.guess3);
        respuestas.add(GlobalVariables.guess4);
        respuestas.add(GlobalVariables.guess5);
        respuestas.add(GlobalVariables.guess6);
        respuestas.add(GlobalVariables.guess7);
        respuestas.add(GlobalVariables.guess8);
        respuestas.add(GlobalVariables.guess9);
        respuestas.add(GlobalVariables.guess10);
        respuestas.add(GlobalVariables.guess11);
        respuestas.add(GlobalVariables.guess12);
        respuestas.add(GlobalVariables.guess13);
        respuestas.add(GlobalVariables.guess14);
        respuestas.add(GlobalVariables.guess15);
        respuestas.add(GlobalVariables.guess16);
        respuestas.add(GlobalVariables.guess17);

        GlobalVariables.listaGuesses = respuestas;

        Integer aciertos = 0;
        Boolean deuteran = false;
        Boolean protan = false;

        /* Para los platos 16 y 17. Si solo han visto uno de los dos numeros (resultado < 10)
         * entonces se considera grave, y según el número que hayan elegido diferenciamos entre protan y deutan.
         * Si ha visto un numero de dos dígitos pero solo ha acertado uno, lo consideramos mild.
         */

        for (int i = 0; i < respuestas.size(); i++) {
            if (GlobalVariables.results.get(i) == respuestas.get(i)){
                aciertos++;
            } else {
                if (i == 15 && respuestas.get(i) != null) {
                    if (respuestas.get(i) == 6) {
                        protan = true;
                    } else if (respuestas.get(i) == 2) {
                        deuteran = true;
                    }
                } else if (i == 16 && respuestas.get(i) != null) {
                    if (respuestas.get(i) == 2) {
                        protan = true;
                    } else if (respuestas.get(i) == 4) {
                        deuteran = true;
                    }
                }
            }
        }

        TextView textView = (TextView) findViewById(R.id.descResText);
        StringBuilder sb = new StringBuilder();

        if (aciertos  >= 13) {
            textView.setText("Visión Normal\n\nPara mostrar las funcionalidades de la aplicación,\n" +
                    " se aplicará la corrección de color \n" +
                    "para personas con Deuteranopia");
            GlobalVariables.setCamaraDeuteran();
        } else {
            sb.append("Daltonismo\n");
            GlobalVariables.setCamaraDeuteran();
            if (deuteran && !protan){
                sb.append("\nDiscromatopsia: Deuteranopia\n");
                sb.append("\nDificultad a la hora de visualizar tonalidades verdes");
                GlobalVariables.setCamaraDeuteran();
            } else if (!deuteran && protan) {
                sb.append("\nDiscromatopsia: Protanopia\n");
                sb.append("\nDificultad a la hora de visualizar tonalidades rojas");
                GlobalVariables.setCamaraProtan();
            }

            if ((!deuteran && !protan) || (deuteran && protan)) {
                sb.append("\n\nComo no se ha podido determinar\n" +
                        " el tipo de daltonismo utilizando el test\n" +
                        "se inicializará la cámara para el caso de Deuteranopia\n" +
                        "(Puede cambiar el tipo en la ventana de Ajustes de la cámara)");
            }
            textView.setText(sb.toString());
        }
    }

    private void configureAtrasButton(){
        Button atrasButton = (Button) findViewById(R.id.btnBack);
        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterTestActivity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureDetallesButton(){
        TextView detallesTextView = (TextView) findViewById(R.id.detallesTextView);
        detallesTextView.setPaintFlags(detallesTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        detallesTextView.setTextColor(Color.BLUE);
        detallesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AfterTestActivity.this, DetallesTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureCamaraButton(){

        Button camaraButton = (Button) findViewById(R.id.btnCamaraAfterTest);
        camaraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(AfterTestActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AfterTestActivity.this, new String[]{Manifest.permission.CAMERA}, 101);
                }
                else {
                    startActivity(new Intent(AfterTestActivity.this, Camera2Activity.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            }
        });
    }

}
