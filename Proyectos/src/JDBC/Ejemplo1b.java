package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1b {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pruebas", "accesoDatos", "Usuario1.");
			
			Statement statement = connect.createStatement();
			String sql = "SELECT apellido, dnombre, MAX(salario) FROM empleados "
						+ "left join departamentos on empleados.dept_no = departamentos.dept_no"
						+ " group by 1, 2"
						+ " limit 1;";
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				System.out.printf("%s, %f, %s %n",
						result.getString(1),
						result.getDouble(3),
						result.getString(2));
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
