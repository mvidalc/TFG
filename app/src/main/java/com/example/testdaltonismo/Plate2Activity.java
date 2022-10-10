package com.example.testdaltonismo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Plate2Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plate2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        configureInicioButton();
        configureSiguienteButton();
        configureAtrasButton();
    }

    private void configureInicioButton(){
        Button inicioButton = (Button) findViewById(R.id.btnInicio);
        inicioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Plate2Activity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureAtrasButton(){
        Button atrasButton = (Button) findViewById(R.id.btnAtras2);
        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Plate2Activity.this, Plate1Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureSiguienteButton(){
        Button siguienteButton = (Button) findViewById(R.id.btnNext2);
        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText guess = (EditText) findViewById(R.id.intGuess2);
                if (TextUtils.isEmpty(guess.getText()))
                    GlobalVariables.guess2 = null;
                else
                    GlobalVariables.guess2 = Integer.parseInt(guess.getText().toString());
                startActivity(new Intent(Plate2Activity.this, Plate3Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

}
