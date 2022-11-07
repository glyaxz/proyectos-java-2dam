package JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo2 {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connect = DriverManager.getConnection(
					"jdbc:sqlite:/home/glyaxz/depart.db");
			
			DatabaseMetaData dbmd = connect.getMetaData();
			ResultSet result = null;
			
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.println("Informacion de la base de datos:");
			System.out.println("-------------------------------");
			System.out.println("Nombre: " + nombre);
			System.out.println("Driver: " + driver);
			System.out.println("URL: 	" + url);
			System.out.println("Usuario:" + usuario);
			
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}catch(SQLException f) {
			f.getMessage();
		}
	}
}
