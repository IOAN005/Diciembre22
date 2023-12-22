package com.corenetworks.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccesoFunciones extends Conexion{
    public int probarFunction() throws SQLException, ClassNotFoundException {
        //1. Declaracion de variable
        CallableStatement sentencia = null;
        ResultSet rejilla =null;
        String sql ="select public.cantidades_existencia()";
        int resultado =0;
        //2.Abrir la conexion
        abrirConexion();

        //3.Crear el Statment
        sentencia= miConexion.prepareCall(sql);

        //4.Ejecutar el statment
        rejilla= sentencia.executeQuery();
        if(rejilla.next()){
            resultado=rejilla.getInt("cantidades_existencia");
        }
        //.5 devolver el resultado
        return resultado;
    }
    public String probarFunctionConParametro(int id) throws SQLException, ClassNotFoundException {
        //1. Declaracion de variable
        CallableStatement sentencia = null;
        ResultSet rejilla = null;
        String sql = "select public.nombre_producto(?)";
        String resultado = null;
        //2.Abrir la conexion
        abrirConexion();

        //3.Crear el Statment
        sentencia = miConexion.prepareCall(sql);
        sentencia.setInt(1,id);

        //4.Ejecutar el statment
        rejilla = sentencia.executeQuery();
        if (rejilla.next()) {
            resultado = rejilla.getString("nombre_producto");
        }
        //.5 devolver el resultado
        return resultado;
    }
}
