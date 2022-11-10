package EjerciciosTema2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {		
		//Global Variables
		boolean whileTrue = true;

		while(whileTrue) {
			System.out.println("Bienvenid@ al gestor de empleados."
					+ "\nSelecciona una acción: 1. Consulta | 2. Insertar | 3. Modificar | 4. Eliminar | 5. Salir");
			System.out.print("==> ");
			String input = new Scanner(System.in).nextLine();
			boolean whileTrue1 = true;
			switch(input) {
			case "1":
				while(whileTrue1) {
					System.out.println("Has escogido consulta. \nIntroduzca el numero del empleado a consultar (Introduzca 10000 para salir): ");
					try {
						int inputValue = new Scanner(System.in).nextInt();
						if(inputValue == 10000) {
							System.out.println("¡Adios!");
							whileTrue1 = false;
						}else if(inputValue <= 9999 || inputValue >= 0){
							showEmployee(inputValue);
						}else {
							System.out.println("El numero introducido no es válido. Los valores permitidos son 0 - 9999");
						}
					}catch(Exception e) {
						System.out.println("El valor introducido no es válido");
					}
				}
				break;
			case "2":
				createEmployee();
				break;
			case "3":
				modifyEmployee();
				break;
			case "4":
				deleteEmployee();
				break;
			case "5":
				System.out.println("¡Adios!");
				whileTrue = false;
				break;
			default:
				System.out.println("El valor introducido no es válido");
				break;
			}
		}	
	}
	
	public static void showEmployee(int value) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos", "Usuario1.");
			PreparedStatement ps = connect.prepareStatement("select * from empleados where emp_no = ?");
			ps.setInt(1, value);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int empNo = rs.getInt("emp_no");
				String apellido = rs.getString("apellido");
				String oficio = rs.getString("oficio");
				int dir = rs.getInt("dir");
				Date fechaAlt = rs.getDate("fecha_alt");
				double salario = rs.getDouble("salario");
				int deptNo = rs.getInt("dept_no");
				
				System.out.println(empNo + " | " + apellido + " | " + oficio + " | " + dir + " | " + fechaAlt + " | " + salario + " | " + deptNo);
			}
			
			ps.close();
			connect.close();
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Error: " + e.getMessage());
		}
	}
	
	public static void createEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos",
					"Usuario1.");
			PreparedStatement ps = connect.prepareStatement("insert into empleados values(?,?,?,?,?,?,?,?)");
			System.out.println("Has escogido insertar. \nSiga las instrucciones para crear un empleado.");
			Scanner scanner = new Scanner(System.in);
			
			try {
				System.out.println("Introduzca un numero de empleado (No puede ser mayor a 9999 ni menor a 0)");
				int empNo = scanner.nextInt();
				System.out.println("Introduzca un apellido");
				String apellido = scanner.nextLine();
				System.out.println("Introduzca un oficio");
				String oficio = scanner.nextLine();
				System.out.println("Introduzca un director");
				int dir = scanner.nextInt();
				LocalDate fechaAlt = LocalDate.now();	
				System.out.println("Introduzca un salario (Formato: 0000,00)");
				double salario = scanner.nextDouble();
				System.out.println("Introduzca una comision (Indicar 0 no se quiere poner comision)");
				double comision = scanner.nextDouble();
				System.out.println("Introduzca un numero de departamento válido");
				int deptNo = scanner.nextInt();
				
				PreparedStatement query = connect.prepareStatement("select * from empleados where emp_no = " + dir);
				if(query.executeQuery().next()) {
					ps.setInt(1, empNo);
					ps.setString(2, apellido);
					ps.setString(3, oficio);
					ps.setInt(4, dir);
					ps.setDate(5, Date.valueOf(fechaAlt));
					ps.setDouble(6, salario);
					ps.setDouble(7, comision);
					ps.setInt(8, deptNo);
					
					ps.executeUpdate();
					
					System.out.println(" - Empleado Creado - ");
				}else {
					System.out.println("El director introducido no existe");
				}
				
			}catch(Exception e) {
				System.out.println("El valor introducido no es valido");
			}
			
			ps.close();
			connect.close();
		} catch (SQLException e) {
			switch(e.getErrorCode()) {
				case 1022:
					System.out.println("Has introducido un numero de empleado existente");
					break;
				default:
					System.out.println("Error no esperado - " + e.getErrorCode() + " - " + e.getMessage());
					break;
			}
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/Unidad2", "accesoDatos",
						"Usuario1.");
				PreparedStatement ps = connect.prepareStatement("");

			} catch (SQLException e) {
				System.out.println("SQL Error: " + e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("Driver Error: " + e.getMessage());
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Error: " + e.getMessage());
		}
	}
	
	public static void deleteEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos",
					"Usuario1.");
			PreparedStatement ps = connect.prepareStatement("delete from empleados where emp_no = ?");
			
			System.out.println("Has escogido eliminar. \nIntroduzca el numero de empleado a eliminar (Si es director de otros empleados, los empleados se quedaran sin director):");
			String input = new Scanner(System.in).nextLine();
			
			try{
				int inputValue = Integer.parseInt(input);
				ps.setInt(1, inputValue);
				
				ps.executeUpdate();
				
				//delete from dir
				
				System.out.println(" - Empleado eliminado - ");
				
				
			}catch(Exception e) {
				System.out.println("El valor introducido no es válido.\nEl empleado no ha sido eliminado");
			}
			ps.close();
			connect.close();

		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Error: " + e.getMessage());
		}
	}
	
	public static void modifyEmployee() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "accesoDatos",
					"Usuario1.");
			PreparedStatement ps;
			
			System.out.println("Has escogido modificar.\nIntroduce el numero de empleado que quieres modificar: ");
			String inputValue = new Scanner(System.in).nextLine();
			
			try {
				int empNo = Integer.parseInt(inputValue);
				System.out.println("Que deseas modificar?\n" + 
									"1. Apellido | 2. Oficio | 3. Director | 4. Fecha de alta | 5. Salario | 6. Comision | 7. Departamento | 8. Salir\n"
									+ "Introduzca un Valor: ");
				System.out.print("==> ");
				
				inputValue = new Scanner(System.in).nextLine();
				String input;
				switch(inputValue) {
				case "1":
					System.out.print("Has escogido Apellido. Introduzca el nuevo valor: ");
					input = new Scanner(System.in).nextLine();
					ps = connect.prepareStatement("update empleados set apellido = ? where emp_no = ?");
					ps.setInt(2, empNo);
					ps.setString(1, input);
					ps.executeUpdate();
					System.out.println(" - Empleado modificado - ");
					break;
				case "2":
					System.out.print("Has escogido Oficio. Introduzca el nuevo valor: ");
					input = new Scanner(System.in).nextLine();
					ps = connect.prepareStatement("update empleados set oficio = ? where emp_no = ?");
					ps.setInt(2, empNo);
					ps.setString(1, input);
					ps.executeUpdate();
					System.out.println(" - Empleado modificado - ");
					break;
				case "3":
					System.out.print("Has escogido Director. Introduzca el nuevo valor (Ha de existir el empleado - Introducir 'Ninguno' para dejar en blanco): ");
					input = new Scanner(System.in).nextLine();
					
					if(input.equalsIgnoreCase("ninguno")) {
						ps = connect.prepareStatement("update empleados set dir = ? where emp_no = ?");
						ps.setInt(2, empNo);
						ps.setInt(1, Integer.parseInt(input));
						ps.executeUpdate();
						System.out.println(" - Empleado modificado - ");
					}else {
						PreparedStatement query = connect.prepareStatement("select * from empleados where emp_no = " + input + "LIMIT 1");
						if(query.executeQuery().next()) {
							ps = connect.prepareStatement("update empleados set dir = ? where emp_no = ?");
							ps.setInt(2, empNo);
							ps.setInt(1, Integer.parseInt(input));
							ps.executeUpdate();
							System.out.println(" - Empleado modificado - ");
						}else {
							System.out.println("El director introducido no existe");
						}
					}
				case "4":
					try { 
						System.out.print("Has escogido Fecha de alta. Introduzca el dia de alta (1-31): ");
						int dia = Integer.parseInt(new Scanner(System.in).nextLine());
						System.out.print("Has escogido Fecha de alta. Introduzca el mes de alta (1-12): ");
						int mes = Integer.parseInt(new Scanner(System.in).nextLine());
						System.out.print("Has escogido Fecha de alta. Introduzca el año de alta: ");
						int anyo = Integer.parseInt(new Scanner(System.in).nextLine());
						
						Date fechaAlt = new Date(anyo, mes, dia);
						ps = connect.prepareStatement("update empleados set fecha_alt = ? where emp_no = ?");
						ps.setInt(2, empNo);
						ps.setDate(1, fechaAlt);
						ps.executeUpdate();
						System.out.println(" - Empleado modificado - ");
					}catch(Exception e) {
						System.out.println("El valor introducido no es valido");
					}
					break;
				case "5":
					System.out.print("Has escogido Salario. Introduzca el nuevo valor (Formato => 0000,00): ");
					try {
						double inp = new Scanner(System.in).nextDouble();
						ps = connect.prepareStatement("update empleados set salario = ? where emp_no = ?");
						ps.setInt(2, empNo);
						ps.setDouble(1, inp);
						ps.executeUpdate();
						System.out.println(" - Empleado modificado - ");
					
					}catch(Exception e) {
						System.out.println("El valor introducido no es válido");
					}
					break;
				case "6":
					System.out.print("Has escogido Comision. Introduzca el nuevo valor (Formato => 0000,00 | Introducir 'Ninguno' para dejar en blanco): ");
					try {
						String inp = new Scanner(System.in).nextLine();
						if(inp.equalsIgnoreCase("Ninguno")) {
							ps = connect.prepareStatement("update empleados set comision = ? where emp_no = ?");
							ps.setInt(2, empNo);
							ps.setNull(1, Types.FLOAT);
							ps.executeUpdate();
							System.out.println(" - Empleado modificado - ");
						}else {
							ps = connect.prepareStatement("update empleados set salario = ? where emp_no = ?");
							ps.setInt(2, empNo);
							ps.setDouble(1, Double.parseDouble(inp));
							ps.executeUpdate();
							System.out.println(" - Empleado modificado - ");
						}
					}catch(Exception e) {
						System.out.println("El valor introducido no es válido");
					}
					break;
				case "7":
					System.out.print("Has escogido Numero de deparmamento. Introduzca el nuevo valor (Ha de existir el departamento): ");
					input = new Scanner(System.in).nextLine();
					try {
						PreparedStatement query = connect.prepareStatement("select * from empleados where dept_no = " + input + "LIMIT 1");
						if(query.executeQuery().next()) {
							ps = connect.prepareStatement("update empleados set dept_no = ? where emp_no = ?");
							ps.setInt(2, empNo);
							ps.setDouble(1, Integer.parseInt(input));
							ps.executeUpdate();
							System.out.println(" - Empleado modificado - ");
						}else {
							System.out.println("El departamento introducido no existe");
						}
					}catch(Exception e) {
						System.out.println("El valor introducido no es válido");
					}
					
					break;
				case "8":
					System.out.println("¡Adios!");
					break;
				default:
					System.out.println("El valor introducido no es válido");
					break;
				}
				
			}catch(Exception e) {
				//System.out.println("El valor introducido no es válido");
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Error: " + e.getMessage());
		}
	}
}
