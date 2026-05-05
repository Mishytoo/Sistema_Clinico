package com.barrientos.sistema_clinico.util;

//import android.util.Log;

public class Out {
    private static String TAG = "NULL";
    private static String error = "";
    private static int one = 1;
    private static int zero = 0;

    public Out() {}

    public Out(String println){
        String clase, metodo, linea;
        clase = new Exception().getStackTrace()[one].getClassName().replaceAll("cibertec.proyecto_rojas.com.","");
        metodo = new Exception().getStackTrace()[one].getMethodName() + "();";
        linea = "[L-" + new Exception().getStackTrace()[one].getLineNumber()+"]";
        TAG = clase + "." + metodo + linea;
        System.out.println(TAG + ": " + println);
    }

    public void v(String println){
        String clase, metodo, linea;
        //$override
        try {
            clase = new Exception().getStackTrace()[one].getClassName().replaceAll("cibertec.proyecto_rojas.com.","");
            metodo = new Exception().getStackTrace()[one].getMethodName() + "();";
            linea = "[L-" + new Exception().getStackTrace()[one].getLineNumber()+"]";
            TAG = clase + "." + metodo + linea;
            System.out.println(TAG + ": " + println);

        }catch (Exception e){
            clase = new Exception().getStackTrace()[one].getClassName();
            metodo = new Exception().getStackTrace()[zero].getMethodName() + "();";
            linea = "[L-" + new Exception().getStackTrace()[zero].getLineNumber()+"]";
            error = " - [ERROR => " + e.getMessage()+"]";
            TAG = clase + "." + metodo + linea + error;
            System.out.println(TAG + ": " + println);
            e.printStackTrace();
        }

    }

    private void i(String println){



    }
}
