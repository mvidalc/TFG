package com.example.testdaltonismo;

import android.content.Intent;
import android.net.ipsec.ike.TunnelModeChildSessionParams;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class Camera2Activity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {

    JavaCameraView javaCameraView;
    Mat mat1, mat2, mat3, mat4, mat5, mat6, mat7, mat8, mat9, mat10, mat11;
    Scalar scalarLow, scalarHigh, scalarColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        OpenCVLoader.initDebug();

        javaCameraView = (JavaCameraView) findViewById(R.id.cameraView);
        javaCameraView.setCameraIndex(0);

        //rojos
        //scalarLow = new Scalar(112,90,90);
        //scalarHigh = new Scalar(128,255,255);

        //amarillos-verdes?
        //scalarLow = new Scalar(50,50,50);
        //scalarHigh = new Scalar(62,255,255);

        javaCameraView.setCvCameraViewListener(this);
        javaCameraView.enableView();

        configureInicioButton();
        configureAjustesButton();

    }

    private Scalar setColor() {
        if (GlobalVariables.colorSeleccionado.equals("rosa"))
            return new Scalar(205,153,246);
        else if (GlobalVariables.colorSeleccionado.equals("amarillo"))
            return new Scalar(255,255,0);
        else if (GlobalVariables.colorSeleccionado.equals("rojo"))
            return new Scalar(255,0,0);
        else
            return new Scalar(0,0,255);
    }

    private void setModo() {
        if (GlobalVariables.camaraDeuteran) {
            scalarLow = new Scalar(40,60,55);
            scalarHigh = new Scalar(95,255,255);
        } else {
            scalarLow = new Scalar(112,90,90);
            scalarHigh = new Scalar(128,255,255);
        }
    }

    private void configureInicioButton(){
        Button inicioButton = (Button) findViewById(R.id.btnInicio);
        inicioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Camera2Activity.this, MainActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    private void configureAjustesButton(){
        Button ajustesButton = (Button) findViewById(R.id.btnAjustes);
        ajustesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Camera2Activity.this, AjustesCamaraActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    @Override
    public void onCameraViewStarted(int width, int height) {

        mat1 = new Mat(width, height, CvType.CV_8UC1);
        mat2 = new Mat(width, height, CvType.CV_8UC1);
        mat3 = new Mat(width, height, CvType.CV_8UC1);
        mat4 = new Mat(width, height, CvType.CV_8UC1);
        mat5 = new Mat(width, height, CvType.CV_8UC1);
        mat6 = new Mat(width, height, CvType.CV_8UC1);
        mat7 = new Mat(width, height, CvType.CV_8UC1);
        mat8 = new Mat(width, height, CvType.CV_8UC1);
        mat9 = new Mat(width, height, CvType.CV_8UC1);
        mat10 = new Mat(width, height, CvType.CV_8UC1);

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {

        scalarColor = setColor();
        setModo();

        if (GlobalVariables.modoBN) {
            return camaraModoBN(inputFrame);
        } else {
            return camaraModoFiltro(inputFrame);
        }
    }

    public Mat camaraModoBN(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {

        // MAT1 - Imagen pasada a HSV (exagera los colores)
        Imgproc.cvtColor(inputFrame.rgba(), mat1, Imgproc.COLOR_BGR2HSV);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso1)
            return mat1;

        // MAT2 - Mascara (lo blanco es lo que seria el color seleccionado)
        Core.inRange(mat1, scalarLow, scalarHigh, mat2);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso2)
            return mat2;

        // MAT3 - Mascara invertida (lo blanco es lo que NO seria el color seleccionado)
        Core.bitwise_not(mat2, mat3);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso3)
            return mat3;

        // MAT4 - La imagen sin modificar en color
        mat4 = inputFrame.rgba();
        if (GlobalVariables.debbugerMode && GlobalVariables.paso4)
            return mat4;

        // MAT5 - mascara con la imagen original
        mat5.release();
        Core.bitwise_and(mat4, mat4, mat5, mat2);   //CV_8U C4
        if (GlobalVariables.debbugerMode && GlobalVariables.paso5)
            return mat5;

        // MAT6 - imagen en bn
        mat6 = inputFrame.gray();
        if (GlobalVariables.debbugerMode && GlobalVariables.paso6)
            return mat6;

        // MAT7 - fondo en bn
        mat7.release();
        Core.bitwise_and(mat6, mat6, mat7, mat3);   //CV_8U C1
        if (GlobalVariables.debbugerMode && GlobalVariables.paso7)
            return mat7;

        // MAT8 - convertir la imagen en BN a matriz de 3 bits
        mat8.release();
        Imgproc.cvtColor(mat7, mat8, Imgproc.COLOR_GRAY2RGB);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso8)
            return mat8;

        // MAT9 - convertir los pixeles seleccionados a matriz de 3 bits
        mat9.release();
        Imgproc.cvtColor(mat5, mat9, Imgproc.COLOR_BGRA2BGR);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso9)
            return mat9;

        // MAT10 - add de las dos ultimas matrices
        mat10.release();
        Core.add(mat8, mat9, mat10);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso10)
            return mat10;

        return mat10;

    }

    public Mat camaraModoBordes(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {

        // MAT1 - Imagen pasada a HSV (exagera los colores)
        Imgproc.cvtColor(inputFrame.rgba(), mat1, Imgproc.COLOR_BGR2HSV);

        // MAT2 - Mascara (lo blanco es lo que seria el color seleccionado)
        Core.inRange(mat1, scalarLow, scalarHigh, mat2);

        // MAT3 - La imagen en blanco y negro (para los bordes)
        mat3 = inputFrame.gray();

        Imgproc.GaussianBlur(mat3, mat4, new Size(15,15), 0);

        // MAT5 - Solo lo rojo pero en BN
        mat5.release();
        Core.bitwise_and(mat4, mat4, mat5, mat2);

        Mat cannyOutput = new Mat();
        Imgproc.Canny(mat5, cannyOutput, 800, 900);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();

        Imgproc.findContours(cannyOutput, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

        scalarColor = setColor();

        Mat dest = Mat.zeros(cannyOutput.size(), CvType.CV_8UC3);
        for (int i = 0; i < contours.size(); i++) {

            //double area = Imgproc.contourArea(contours.get(i));

            //if (area > 1000)
                Imgproc.drawContours(dest, contours, i, scalarColor, 2, Core.LINE_4, hierarchy, 0, new Point());
        }

        mat6 = inputFrame.rgba();

        mat7.release();
        Imgproc.cvtColor(mat6, mat7, Imgproc.COLOR_BGRA2BGR);

        mat8.release();
        Core.add(mat7, dest, mat8);

        return mat8;

    }

    public Mat camaraModoFiltro(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {

        // MAT1 - Imagen pasada a HSV (exagera los colores)
        Imgproc.cvtColor(inputFrame.rgba(), mat1, Imgproc.COLOR_BGR2HSV);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso1)
            return mat1;

        // MAT2 - Mascara (lo blanco es lo que seria el color seleccionado)
        Core.inRange(mat1, scalarLow, scalarHigh, mat2);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso2)
            return mat2;

        // MAT3 - Mascara invertida (lo blanco es lo que NO seria el color seleccionado)
        Core.bitwise_not(mat2, mat3);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso3)
            return mat3;

        // MAT4 - La imagen sin modificar en color
        mat4 = inputFrame.rgba();
        if (GlobalVariables.debbugerMode && GlobalVariables.paso4)
            return mat4;

        // MAT5 - mascara con la imagen original
        mat5.release();
        Core.bitwise_and(mat4, mat4, mat5, mat2);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso5)
            return mat5;

        // MAT6 - imagen original sin los colores seleccionados (fondo final)
        mat6.release();
        Core.bitwise_and(mat4, mat4, mat6, mat3);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso6)
            return mat6;

        // MAT7 - Matriz rosa
        mat7.release();
        mat7 = inputFrame.rgba();
        mat7.setTo(scalarColor);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso7)
            return mat7;

        // MAT8 - mascara con el rosa
        mat8.release();
        Core.bitwise_and(mat7, mat7, mat8, mat2);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso8)
            return mat8;

        // MAT7 - solo parte de colores con filtro rosa aplicado
        mat9.release();
        Core.addWeighted(mat8, 0.75, mat5, 0.25, 0.0, mat9);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso9)
            return mat9;

        // MAT10 - imagen original con filtro en los colores seleccionados
        mat10.release();
        Core.add(mat6, mat9, mat10);
        if (GlobalVariables.debbugerMode && GlobalVariables.paso10)
            return mat10;

        // devolvemos únicamente toda la imagen excepto los colores en el rango
        return mat10;

    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        javaCameraView.disableView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        javaCameraView.enableView();
    }

    @Override
    protected void onDestroy() {
        javaCameraView.disableView();
        super.onDestroy();
    }
}
