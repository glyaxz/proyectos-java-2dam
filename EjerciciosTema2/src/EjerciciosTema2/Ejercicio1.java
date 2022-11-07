package EjerciciosTema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio1 {
	public static void main(String[] args) {
		try {
			//Variables
			String[][] clientes = {
					{"1", "Javier", "Calle del Pilar, 3", "Granada", "666777888", "12345678A"},
					{"2", "Fran", "Avenida Dilar, 76", "Granada", "667788990", "90123456B"},
					{"3", "Sergio", "Calle Doctor Oloriz, 5", "Granada", "666777888", "78901234C"},
					{"4", "Pedro", "Plaza Fontiveros, 17", "Granada", "678901234", "56789012D"},
					{"5", "Alvaro", "Calle Gonzalo Gallas, 6", "Granada", "680246801", "34566789E"}
			};
			
			String[][] productos = {
					{"1", "Tornillos de carpintero", "57", "1", "0.31"},
					{"2", "Destornillador de estrella", "15", "1", "5.99"},
					{"3", "Taladro electrico", "7", "1", "59.99"},
					{"4", "Cascos de obra", "123", "1", "1.20"},
					{"5", "Tuerca 6", "123", "1", "1.21"}
			};
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/Unidad2", "accesoDatos","Usuario1.");
			
			//Insert Clientes
			PreparedStatement ps = connect.prepareStatement("insert into clientes values(?, ?, ?, ?, ?, ?);");
			for(int i = 0; i < clientes.length; i++) {
				ps.setInt(1, Integer.parseInt(clientes[i][0]));
				ps.setString(2, clientes[i][1]);
				ps.setString(3, clientes[i][2]);
				ps.setString(4, clientes[i][3]);
				ps.setString(5, clientes[i][4]);
				ps.setString(6, clientes[i][5]);
				
				int rs = ps.executeUpdate();
				System.out.println("Clientes insertados");
			}
			
			//Insert productos
			ps = connect.prepareStatement("insert into productos values(?, ?, ?, ?, ?);");
			for(int i = 0; i < clientes.length; i++) {
				ps.setInt(1, Integer.parseInt(productos[i][0]));
				ps.setString(2, productos[i][1]);
				ps.setInt(3, Integer.parseInt(productos[i][2]));
				ps.setInt(4, Integer.parseInt(productos[i][3]));
				ps.setDouble(5, Double.parseDouble(productos[i][4]));
				
				int rs = ps.executeUpdate();
				System.out.println("Productos insertados");
			}	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
