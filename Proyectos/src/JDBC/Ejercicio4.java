package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ejercicio4 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos","Usuario1.");
			int empNumber = Integer.parseInt(args[0]);
			String empApellido = args[1];
			int empOficio = Integer.parseInt(args[2]);
			int empDir = Integer.parseInt(args[3]);
			double empSalario = Double.parseDouble(args[4]);
			double empComision = Double.parseDouble(args[5]);
			int deptNO = Integer.parseInt(args[6]);
			
			
			Statement statement = connect.createStatement();
			PreparedStatement ps = connect.prepareStatement("insert into empleados values(?, ?, ?, ?, curdate(), ?, ?, ? )");
			ps.setInt(1,empDir);
			ps.setString(2, empApellido);
			ps.setInt(3, empOficio);
			ps.setInt(4, empDir);
			ps.setDouble(5, empSalario);
			ps.setDouble(6, empComision);
			ps.setInt(7, deptNO);
			
			int rs = ps.executeUpdate();

			System.out.println(rs);
			
			
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(SQLException f) {
				
		}
	}
}
