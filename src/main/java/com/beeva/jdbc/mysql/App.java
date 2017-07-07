package com.beeva.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection connection = null;
        try{
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","Beeva2017*");	
        }catch(SQLException e){
        	System.out.println("Fallo ls conexion DX :(");
        	e.printStackTrace();
        	return;
        }
        
        if(connection != null){
        	System.out.println("Conectado, ya podemos hacer cosas");
        	String insert="insert into empleado (nombre) values ('Santiago')";
        	String query="select * from empleado";
        	try{
        		connection.prepareStatement(insert).executeUpdate();
        		ResultSet rs= connection.prepareStatement(query).executeQuery();
        		while(rs.next()){
        			System.out.println("nombre: "+rs.getString("nombre"));
        		}
        		connection.close();
        	}catch(SQLException e){
        		e.printStackTrace();
        	}
        }else{
        	System.out.println("Ruegale a dios");
        }
        
    }
}
