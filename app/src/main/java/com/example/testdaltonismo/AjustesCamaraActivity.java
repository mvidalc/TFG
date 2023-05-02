package com.example.testdaltonismo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class AjustesCamaraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes_camara);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        configureBackButton();
        configureToggleButtonsModo();
        configureToggleButtonsColor();
        configureToggleButtonsTipo();

        configureDebugONButton();
        configureDebugOFFButton();

    }

    private void configureToggleButtonsModo() {

        Button btnFiltro = (Button) findViewById(R.id.btnFiltro);
        Button btnBN = (Button) findViewById(R.id.btnBN);

        if (GlobalVariables.modoBN) {
            btnBN.performClick();
        } else {
            btnFiltro.performClick();
        }

        MaterialButtonToggleGroup grupo = findViewById(R.id.toggleBtns);
        grupo.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    if (checkedId == R.id.btnFiltro) {
                        GlobalVariables.setModoFiltro();
                    } else if (checkedId == R.id.btnBN) {
                        GlobalVariables.setModoBN();
                    }
                }
            }
        });
    }

    private void configureToggleButtonsColor() {

        Button btnRosa = (Button) findViewById(R.id.btnRosa);
        Button btnAmarillo = (Button) findViewById(R.id.btnAmarillo);
        Button btnRojo = (Button) findViewById(R.id.btnRojo);
        Button btnAzul = (Button) findViewById(R.id.btnAzul);

        TextView colorSeleccionado = (TextView) findViewById(R.id.colorSeleccionado);

        if (GlobalVariables.colorSeleccionado.equals("amarillo")) {
            btnAmarillo.performClick();
            colorSeleccionado.setText("Amarillo");
        } else if (GlobalVariables.colorSeleccionado.equals("rojo")) {
            btnRojo.performClick();
            colorSeleccionado.setText("Rojo");
        }  else if (GlobalVariables.colorSeleccionado.equals("azul")) {
            btnAzul.performClick();
            colorSeleccionado.setText("Azul");
        } else {
            btnRosa.performClick();
            colorSeleccionado.setText("Rosa");
        }

        MaterialButtonToggleGroup grupo = findViewById(R.id.toggleBtnsColores);
        grupo.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    if (checkedId == R.id.btnRosa) {
                        GlobalVariables.colorSeleccionado = "rosa";
                        colorSeleccionado.setText("Rosa");
                    } else if (checkedId == R.id.btnAmarillo) {
                        GlobalVariables.colorSeleccionado = "amarillo";
                        colorSeleccionado.setText("Amarillo");
                    } else if (checkedId == R.id.btnRojo) {
                        GlobalVariables.colorSeleccionado = "rojo";
                        colorSeleccionado.setText("Rojo");
                    } else if (checkedId == R.id.btnAzul) {
                        GlobalVariables.colorSeleccionado = "azul";
                        colorSeleccionado.setText("Azul");
                    }
                }
            }
        });
    }

    private void configureToggleButtonsTipo() {

        Button btnDeuteran = (Button) findViewById(R.id.btnDeuteran);
        Button btnProtan = (Button) findViewById(R.id.btnProtan);

        if (GlobalVariables.camaraDeuteran == true) {
            btnDeuteran.performClick();
        } else {
            btnProtan.performClick();
        }

        MaterialButtonToggleGroup grupo = findViewById(R.id.toggleBtnsTipo);

        grupo.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    if (checkedId == R.id.btnProtan) {
                        GlobalVariables.setCamaraProtan();
                    } else if (checkedId == R.id.btnDeuteran) {
                        GlobalVariables.setCamaraDeuteran();
                    }
                }
            }
        });
    }


    private void configureBackButton(){
        Button inicioButton = (Button) findViewById(R.id.btnBack2);
        inicioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesCamaraActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureDebugONButton(){
        Button debugONButton = (Button) findViewById(R.id.btnDebugON);
        debugONButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.debbugerMode = true;
            }
        });
    }

    private void configureDebugOFFButton(){
        Button debugOFFButton = (Button) findViewById(R.id.btnDebugOFF);
        debugOFFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.debbugerMode = false;
            }
        });
    }
}
