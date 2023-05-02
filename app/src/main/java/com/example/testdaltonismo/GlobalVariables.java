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
    public static Boolean testDone = false;
    public static String colorSeleccionado = "rosa";
    public static Boolean paso1 = false, paso2 = false, paso3 = false, paso4 = false, paso5 = false, paso6 = false, paso7 = false, paso8 = false, paso9 = false, paso10 = false;
    public static Boolean debbugerMode = false;


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
    }

    public static void setModoBN(){
        modoFiltro = false;
        modoBN = true;
    }

    public static void setPaso1() {
        paso1 = true;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso2() {
        paso1 = false;
        paso2 = true;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso3() {
        paso1 = false;
        paso2 = false;
        paso3 = true;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso4() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = true;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso5() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = true;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso6() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = true;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso7() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = true;
        paso8 = false;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso8() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = true;
        paso9 = false;
        paso10 = false;
    }

    public static void setPaso9() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = true;
        paso10 = false;
    }

    public static void setPaso10() {
        paso1 = false;
        paso2 = false;
        paso3 = false;
        paso4 = false;
        paso5 = false;
        paso6 = false;
        paso7 = false;
        paso8 = false;
        paso9 = false;
        paso10 = true;
    }

}
