package JDBC;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pruebas", "accesoDatos", "Usuario1.");
			
			Statement statement = connect.createStatement();
			String sql = "select apellido,oficio,salario from empleados where dept_no like 10";
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				System.out.printf("%s, %s, %f %n",
						result.getString(1),
						result.getString(2),
						result.getDouble(3));
			}
			System.out.println(" -------------------------- ");
			/*
			sql = "SELECT apellido, dnombre, MAX(salario) salario"
				+ "FROM empleados"
				+ "JOIN departamentos ON empleados.dept_no = departamentos.dept_no;";
				*/
			sql = "SELECT apellido, MAX(salario)salario, dnombre FROM empleados"
				+ "join departamentos on empleados.dept_no = departamentos.dept_no;";
			result = statement.executeQuery(sql);
			while(result.next()) {
				System.out.printf("%s %n",
						result.getString(1));
			}
			
			
			result.close();
			statement.close();
			connect.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException f) {
			f.printStackTrace();
		}
	}
}
