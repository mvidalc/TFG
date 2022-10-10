package com.example.testdaltonismo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

public class DetallesTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_test);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        configureBackButton();
        rellenarTabla();
    }


    private void configureBackButton(){
        Button inicioButton = (Button) findViewById(R.id.btnBack2);
        inicioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetallesTestActivity.this, AfterTestActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

 private void rellenarTabla(){

        TextView txt1 = (TextView) findViewById(R.id.row1);
        if (GlobalVariables.guess1 == null)
            txt1.setText("X");
        else
            txt1.setText(GlobalVariables.guess1.toString());
        TextView txtRes1 = (TextView) findViewById(R.id.rowRes1);
        if (!txt1.getText().equals(txtRes1.getText())) {
            txt1.setBackgroundColor(Color.RED);
            txt1.setTextColor(Color.WHITE);
        }

        TextView txt2 = (TextView) findViewById(R.id.row2);
        if (GlobalVariables.guess2 == null)
            txt2.setText("X");
        else
            txt2.setText(GlobalVariables.guess2.toString());
         TextView txtRes2 = (TextView) findViewById(R.id.rowRes2);
         if (!txt2.getText().equals(txtRes2.getText())) {
             txt2.setBackgroundColor(Color.RED);
             txt2.setTextColor(Color.WHITE);
         }

        TextView txt3 = (TextView) findViewById(R.id.row3);
        if (GlobalVariables.guess3 == null)
            txt3.setText("X");
        else
            txt3.setText(GlobalVariables.guess3.toString());
         TextView txtRes3 = (TextView) findViewById(R.id.rowRes3);
         if (!txt3.getText().equals(txtRes3.getText())) {
             txt3.setBackgroundColor(Color.RED);
             txt3.setTextColor(Color.WHITE);
         }

        TextView txt4 = (TextView) findViewById(R.id.row4);
        if (GlobalVariables.guess4 == null)
            txt4.setText("X");
        else
            txt4.setText(GlobalVariables.guess4.toString());
         TextView txtRes4 = (TextView) findViewById(R.id.rowRes4);
         if (!txt4.getText().equals(txtRes4.getText())) {
             txt4.setBackgroundColor(Color.RED);
             txt4.setTextColor(Color.WHITE);
         }

        TextView txt5 = (TextView) findViewById(R.id.row5);
        if (GlobalVariables.guess5 == null)
            txt5.setText("X");
        else
            txt5.setText(GlobalVariables.guess5.toString());
         TextView txtRes5 = (TextView) findViewById(R.id.rowRes5);
         if (!txt5.getText().equals(txtRes5.getText())) {
             txt5.setBackgroundColor(Color.RED);
             txt5.setTextColor(Color.WHITE);
         }

        TextView txt6 = (TextView) findViewById(R.id.row6);
        if (GlobalVariables.guess6 == null)
            txt6.setText("X");
        else
            txt6.setText(GlobalVariables.guess6.toString());
         TextView txtRes6 = (TextView) findViewById(R.id.rowRes6);
         if (!txt6.getText().equals(txtRes6.getText())) {
             txt6.setBackgroundColor(Color.RED);
             txt6.setTextColor(Color.WHITE);
         }

        TextView txt7 = (TextView) findViewById(R.id.row7);
        if (GlobalVariables.guess7 == null)
            txt7.setText("X");
        else
            txt7.setText(GlobalVariables.guess7.toString());
         TextView txtRes7 = (TextView) findViewById(R.id.rowRes7);
         if (!txt7.getText().equals(txtRes7.getText())) {
             txt7.setBackgroundColor(Color.RED);
             txt7.setTextColor(Color.WHITE);
         }

        TextView txt8 = (TextView) findViewById(R.id.row8);
        if (GlobalVariables.guess8 == null)
            txt8.setText("X");
        else
            txt8.setText(GlobalVariables.guess8.toString());
         TextView txtRes8 = (TextView) findViewById(R.id.rowRes8);
         if (!txt8.getText().equals(txtRes8.getText())) {
             txt8.setBackgroundColor(Color.RED);
             txt8.setTextColor(Color.WHITE);
         }

        TextView txt9 = (TextView) findViewById(R.id.row9);
        if (GlobalVariables.guess9 == null)
            txt9.setText("X");
        else
            txt9.setText(GlobalVariables.guess9.toString());
         TextView txtRes9 = (TextView) findViewById(R.id.rowRes9);
         if (!txt9.getText().equals(txtRes9.getText())) {
             txt9.setBackgroundColor(Color.RED);
             txt9.setTextColor(Color.WHITE);
         }

        TextView txt10 = (TextView) findViewById(R.id.row10);
        if (GlobalVariables.guess10 == null)
            txt10.setText("X");
        else
            txt10.setText(GlobalVariables.guess10.toString());
         TextView txtRes10 = (TextView) findViewById(R.id.rowRes10);
         if (!txt10.getText().equals(txtRes10.getText())) {
             txt10.setBackgroundColor(Color.RED);
             txt10.setTextColor(Color.WHITE);
         }

        TextView txt11 = (TextView) findViewById(R.id.row11);
        if (GlobalVariables.guess11 == null)
            txt11.setText("X");
        else
            txt11.setText(GlobalVariables.guess11.toString());
         TextView txtRes11 = (TextView) findViewById(R.id.rowRes11);
         if (!txt11.getText().equals(txtRes11.getText())) {
             txt11.setBackgroundColor(Color.RED);
             txt11.setTextColor(Color.WHITE);
         }

        TextView txt12 = (TextView) findViewById(R.id.row12);
        if (GlobalVariables.guess12 == null)
            txt12.setText("X");
        else
            txt12.setText(GlobalVariables.guess12.toString());
         TextView txtRes12 = (TextView) findViewById(R.id.rowRes12);
         if (!txt12.getText().equals(txtRes12.getText())) {
             txt12.setBackgroundColor(Color.RED);
             txt12.setTextColor(Color.WHITE);
         }

        TextView txt13 = (TextView) findViewById(R.id.row13);
        if (GlobalVariables.guess13 == null)
            txt13.setText("X");
        else
            txt13.setText(GlobalVariables.guess13.toString());
         TextView txtRes13 = (TextView) findViewById(R.id.rowRes13);
         if (!txt13.getText().equals(txtRes13.getText())) {
             txt13.setBackgroundColor(Color.RED);
             txt13.setTextColor(Color.WHITE);
         }

        TextView txt14 = (TextView) findViewById(R.id.row14);
        if (GlobalVariables.guess14 == null)
            txt14.setText("X");
        else
            txt14.setText(GlobalVariables.guess14.toString());
         TextView txtRes14 = (TextView) findViewById(R.id.rowRes14);
         if (!txt14.getText().equals(txtRes14.getText())) {
             txt14.setBackgroundColor(Color.RED);
             txt14.setTextColor(Color.WHITE);
         }

        TextView txt15 = (TextView) findViewById(R.id.row15);
        if (GlobalVariables.guess15 == null)
            txt15.setText("X");
        else
            txt15.setText(GlobalVariables.guess15.toString());
         TextView txtRes15 = (TextView) findViewById(R.id.rowRes15);
         if (!txt15.getText().equals(txtRes15.getText())) {
             txt15.setBackgroundColor(Color.RED);
             txt15.setTextColor(Color.WHITE);
         }

        TextView txt16 = (TextView) findViewById(R.id.row16);
        if (GlobalVariables.guess16 == null)
            txt16.setText("X");
        else
            txt16.setText(GlobalVariables.guess16.toString());
         TextView txtRes16 = (TextView) findViewById(R.id.rowRes16);
         if (!txt16.getText().equals(txtRes16.getText())) {
             txt16.setBackgroundColor(Color.RED);
             txt16.setTextColor(Color.WHITE);
         }

        TextView txt17 = (TextView) findViewById(R.id.row17);
        if (GlobalVariables.guess17 == null)
            txt17.setText("X");
        else
            txt17.setText(GlobalVariables.guess17.toString());
         TextView txtRes17 = (TextView) findViewById(R.id.rowRes17);
         if (!txt17.getText().equals(txtRes17.getText())) {
             txt17.setBackgroundColor(Color.RED);
             txt17.setTextColor(Color.WHITE);
         }

    }

}
