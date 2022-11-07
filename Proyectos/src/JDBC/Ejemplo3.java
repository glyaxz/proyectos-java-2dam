package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class Ejemplo3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos","Usuario1.");
			
			Statement statement = connect.createStatement();
			String query = "select * from empleados;";
			ResultSet rs = statement.executeQuery(query);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int nColumns = rsmd.getColumnCount();
			String nula;
			System.out.printf("Numero de columnas recuperadas: %d%n", nColumns);
			
			for(int i = 1; i <=nColumns; i++) {
				System.out.println("Columna " + i);
				System.out.println("Nombre de columna: " + rsmd.getColumnName(i) + " - Tipo de columna: " + rsmd.getColumnType(i));
				
				if(rsmd.isNullable(i) == 0) {
					nula = "no";
				}else {
					nula = "si";
				}
				
				System.out.println("Puede ser nula? " + nula);
				System.out.println("Numero ancho de las columnas: " + rsmd.getColumnDisplaySize(i)); 
			} 
			
			statement.close();
			rs.close();
			connect.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException f) {
			f.printStackTrace();
		}
		
	}
}
