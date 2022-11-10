package EjerciciosTema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Ejercicio3 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos","Usuario1.");	
			
			PreparedStatement ps = connect.prepareStatement("select * from departamentos ?");
			
			
			Ejercicio3.muestraDepartamentos(ps);
			
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void muestraDepartamentos(PreparedStatement ps) {
		try {
	        
	        boolean whileTrue = true;
			
			while(whileTrue) {
				System.out.println("Bienvenido/a a la Base de Datos 'Departamentos'");
				System.out.print("Seleccione una de las opciones: \n"
								+ "1. Seleccionar Departamento // 2. Primero // 3. Ultimo // 4. Salir \n"
								+ "Seleccione su opcion: ");
				String inputValue = new Scanner(System.in).nextLine();
				switch(inputValue) {
				case "1":;
					System.out.print("Introduzca el ID del departamento a buscar: ");
					String input = new Scanner(System.in).nextLine();
					
					ps.setString(1, "where dept_no = " + input);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getString(1));
					}
					break;
					
				case "2":
			        System.out.println("Has seleccionado el primer departamento");
			        ps.setString(1, "where dept_no = 10");
			        
			        
					break;
				case "3":
			        System.out.println("Has seleccionado el ultimo departamento");
			        ps.setString(1, "where dept_no = max(dept_no)");
					break;
				case "4":
			        System.out.println("Adios!");
			        whileTrue = false;
					break;
				default:
					System.out.println("La opcion introducida no es valida");
					break;
				}
			}
		}catch(SQLException e) {
			System.out.println("Sql Error: " + e.getMessage());
		}
		
	}
}
