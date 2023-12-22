package com.corenetworks.presentacion;

import com.corenetworks.persistencia.AccesoFunciones;

import java.sql.SQLException;

public class ProbarFuncion {
    public static void main(String[] args) {
        AccesoFunciones af1= new AccesoFunciones();
        try {
            System.out.println("Cantidad en existencia   " +af1.probarFunction());
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        try {
            System.out.println("nombre del producto " + af1.probarFunctionConParametro(10));
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
    }


}
