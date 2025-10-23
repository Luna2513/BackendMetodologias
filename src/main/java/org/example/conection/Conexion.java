package org.example.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Atributos de una Conexion
    //url
    private String url="jdbc:mysql://localhost:3307/usuarios_bd";
    //usuario
    private String usuario="root";
    //contraseña
    private String contraseña="";

    public Connection conectar(){

        try{
            //Intentare generar una conexion hacia BD
            Connection conexionHaciaBD=DriverManager.getConnection(url,usuario,contraseña);
            System.out.println("✔️ Exito en la conexion con la base de datos");
            return conexionHaciaBD;
        }catch(Exception error){
            System.out.println("❌ Upps fallamos en la conexion");
            return null;
        }

    }

}