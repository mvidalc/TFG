package com.example.testdaltonismo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalVariables {

    public static Integer guess1, guess2, guess3, guess4, guess5, guess6, guess7, guess8, guess9, guess10, guess11, guess12, guess13, guess14, guess15, guess16, guess17;
    public static List<Integer> results = new ArrayList<>(Arrays.asList(12, 8, 29, 5, 3, 15, 74, 6, 45, 5, 7, 16, 73, null, null, 26, 42));
    public static List<Integer> listaGuesses = new ArrayList<Integer>();
    public static Boolean camaraProtan = false;
    public static Boolean camaraDeuteran = false;
    public static Boolean modoFiltro = false;
    public static Boolean modoBN = false;
    public static Boolean modoBordes = false;
    public static Boolean testDone = false;

    public static String colorSeleccionado = "rosa";


    public static void setCamaraProtan(){
        camaraDeuteran = false;
        camaraProtan = true;
    }

    public static void setCamaraDeuteran(){
        camaraDeuteran = true;
        camaraProtan = false;
    }

    public static void setModoFiltro(){
        modoFiltro = true;
        modoBN = false;
        modoBordes = false;
    }

    public static void setModoBN(){
        modoFiltro = false;
        modoBN = true;
        modoBordes = false;
    }

    public static void setModoBordes(){
        modoFiltro = false;
        modoBN = false;
        modoBordes = true;
    }

}
