package com.example.testdaltonismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        configureTestButton();
        configureCamaraButton();

        /*
        configurePaso1Button();
        configurePaso2Button();
        configurePaso3Button();
        configurePaso4Button();
        configurePaso5Button();
        configurePaso6Button();
        configurePaso7Button();
        configurePaso8Button();
        configurePaso9Button();
        configurePaso10Button();

         */
    }

    private void configureTestButton(){
        Button testButton = (Button) findViewById(R.id.btnTest);

        if (GlobalVariables.testDone){
            testButton.setText("Rehacer Test");
        } else {
            testButton.setText("Comenzar");
        }

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureCamaraButton(){
        Button camaraButton = (Button) findViewById(R.id.btnCamara);

        if (GlobalVariables.testDone) {
            camaraButton.setVisibility(View.VISIBLE);
        } else {
            camaraButton.setVisibility(View.GONE);
        }

        camaraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    /*
    private void configurePaso1Button(){
        Button paso1Button = (Button) findViewById(R.id.btnPaso1);

        if (GlobalVariables.debbugerMode) {
            paso1Button.setVisibility(View.VISIBLE);
        } else {
            paso1Button.setVisibility(View.GONE);
        }

        paso1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso1();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso2Button(){
        Button paso2Button = (Button) findViewById(R.id.btnPaso2);

        if (GlobalVariables.debbugerMode) {
            paso2Button.setVisibility(View.VISIBLE);
        } else {
            paso2Button.setVisibility(View.GONE);
        }

        paso2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso2();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso3Button(){
        Button paso3Button = (Button) findViewById(R.id.btnPaso3);

        if (GlobalVariables.debbugerMode) {
            paso3Button.setVisibility(View.VISIBLE);
        } else {
            paso3Button.setVisibility(View.GONE);
        }

        paso3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso3();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso4Button(){
        Button paso4Button = (Button) findViewById(R.id.btnPaso4);

        if (GlobalVariables.debbugerMode) {
            paso4Button.setVisibility(View.VISIBLE);
        } else {
            paso4Button.setVisibility(View.GONE);
        }

        paso4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso4();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso5Button(){
        Button paso5Button = (Button) findViewById(R.id.btnPaso5);

        if (GlobalVariables.debbugerMode) {
            paso5Button.setVisibility(View.VISIBLE);
        } else {
            paso5Button.setVisibility(View.GONE);
        }

        paso5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso5();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso6Button(){
        Button paso6Button = (Button) findViewById(R.id.btnPaso6);

        if (GlobalVariables.debbugerMode) {
            paso6Button.setVisibility(View.VISIBLE);
        } else {
            paso6Button.setVisibility(View.GONE);
        }

        paso6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso6();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso7Button(){
        Button paso7Button = (Button) findViewById(R.id.btnPaso7);

        if (GlobalVariables.debbugerMode) {
            paso7Button.setVisibility(View.VISIBLE);
        } else {
            paso7Button.setVisibility(View.GONE);
        }

        paso7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso7();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso8Button(){
        Button paso8Button = (Button) findViewById(R.id.btnPaso8);

        if (GlobalVariables.debbugerMode) {
            paso8Button.setVisibility(View.VISIBLE);
        } else {
            paso8Button.setVisibility(View.GONE);
        }

        paso8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso8();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso9Button(){
        Button paso9Button = (Button) findViewById(R.id.btnPaso9);

        if (GlobalVariables.debbugerMode) {
            paso9Button.setVisibility(View.VISIBLE);
        } else {
            paso9Button.setVisibility(View.GONE);
        }

        paso9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso9();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configurePaso10Button(){
        Button paso10Button = (Button) findViewById(R.id.btnPaso10);

        if (GlobalVariables.debbugerMode) {
            paso10Button.setVisibility(View.VISIBLE);
        } else {
            paso10Button.setVisibility(View.GONE);
        }

        paso10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalVariables.setPaso10();
                startActivity(new Intent(MainActivity.this, Camera2Activity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

     */
}